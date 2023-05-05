package hanu.edu.domain.product.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.repository.ProductRepository;
import hanu.edu.domain.security.exception.BaseException;
import hanu.edu.infrastructure.product.entity.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//CRUD methods
@Service
//@AllArgsConstructor
public class ProductResourceService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AmazonS3 s3Client;

    @Value("${amazon.s3.default-bucket}")
    private String bucketName;


    public void create(Product product) {
        Product productFromDB = productRepository.getByName(product.getName());
        if (productFromDB != null) {
            throw new BaseException("500", "Duplicate name!");
        }
        productRepository.save(ProductEntity.toEntity(product));
    }

    public void update(Product product) {
        productRepository.save(ProductEntity.toEntity(product));
    }

    public Product getById(long id) {
        return productRepository.getById(id);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> getAllByPage(int page) {
        return productRepository.getAllProductsByPage(page, 20);
    }

    public Page<Product> getAllByCategory(int page, String category) {
        return productRepository.getProductByCategory(page, 20, category);
    }

    public void uploadImages(long productId, List<MultipartFile> productImages) {
        Product product = productRepository.getById(productId);
        product.setImages(uploadImagesToS3(productImages));
        productRepository.save(ProductEntity.toEntity(product));
    }

    private List<String> uploadImagesToS3(List<MultipartFile> productImages) {

        List<String> imagesUrls = new ArrayList<>();
        for (MultipartFile multipartFile: productImages) {
            String key = UUID.randomUUID().toString() + "-" + multipartFile.getOriginalFilename();
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(multipartFile.getContentType());
            objectMetadata.setContentLength(multipartFile.getSize());
            try {
//                logger.info("try to upload image");
                s3Client.putObject(new PutObjectRequest(bucketName, key, multipartFile.getInputStream(), objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
//                logger.info("image uploaded");
                String imageUrl = s3Client.getUrl(bucketName, key).toString();
//                logger.info("imageUrl: " + imageUrl);
                imagesUrls.add(imageUrl);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return imagesUrls;
    }
}
