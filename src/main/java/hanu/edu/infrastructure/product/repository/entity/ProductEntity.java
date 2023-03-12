package hanu.edu.infrastructure.product.repository.entity;

import hanu.edu.domain.product.model.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Table(name = "product")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    private long id;
    private String name;
    private double price;
    private String description;
    private long inStock;
    private String images;
    private float rate;

    public static ProductEntity toEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .inStock(product.getInStock())
                .images(product.getImages() == null ? null : imagesToString(product.getImages()))
                .rate(product.getRate()).build();
    }

    public static String imagesToString(List<String> images) {
        String imagesToString = "";
        for(String image: images) {
            imagesToString += image + " ";
        }
        return imagesToString;
    }
    public Product toProduct() {
        List<String> imageList = new ArrayList<>();
        if(images != null) {
            String[] imageArray = images.split(" ");
            for(int i = 0; i < imageArray.length; i++) {
                imageList.add(imageArray[i]);
            }
        }
        return new Product(id, name, price, description, inStock, imageList, rate);
    }
}
