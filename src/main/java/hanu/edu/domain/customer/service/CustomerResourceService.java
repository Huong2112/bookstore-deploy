package hanu.edu.domain.customer.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.repository.CustomerRepository;
import hanu.edu.domain.user.repository.UserRepository;
import hanu.edu.domain.user.service.UserResourceService;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

//CRUD methods
@Service
public class CustomerResourceService extends UserResourceService {

    @Autowired
    BCryptPasswordEncoder encoder;


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Value("${amazon.s3.default-bucket}")
    private String bucketName;
    @Autowired
    private AmazonS3 s3client;

    public CustomerResourceService() {
    }

    public void create(Customer customer) {
        userRepository.save(CustomerEntity.toEntity(customer));
    }

    public void update(Customer customer) {
        customer.setPassword(encoder.encode(customer.getPassword()));
        customerRepository.save(CustomerEntity.toEntity(customer).toCustomer());
    }

    public Customer getById(long customerId) {
        int passwordLength = customerRepository.getById(customerId).getPassword().length();
        String password = customerRepository.getById(customerId).getPassword();
        char[] chars = password.toCharArray();
        for (char decoderPass : chars) {
            decoderPass -= passwordLength;
            customerRepository.getById(customerId).setPassword(String.valueOf(decoderPass));
        }
        return customerRepository.getById(customerId);
    }

    public void changeAvatar(long customerId, MultipartFile file) {
        try {
            String link = uploadFile(file);
            Customer customer = getById(customerId);
            customer.setAvatar(link);
            customerRepository.save(CustomerEntity.toEntity(customer).toCustomer());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }


    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString();
        InputStream inputStream = file.getInputStream();

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());


        s3client.putObject(new PutObjectRequest(bucketName, fileName, inputStream, metadata).withCannedAcl(CannedAccessControlList.PublicRead));
        return s3client.getUrl(bucketName, fileName).toString();
    }

//    public void deleteById(long customerId) {
//        customerRepository.deleteById(customerId);
//    }

}
