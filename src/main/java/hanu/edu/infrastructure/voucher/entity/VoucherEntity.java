package hanu.edu.infrastructure.voucher.entity;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.voucher.model.Voucher;
import hanu.edu.infrastructure.product.entity.ProductEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity(name = "voucher")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VoucherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private double rate;
    private Date dueDate;

    public static VoucherEntity toEntity(Voucher voucher) {
        return VoucherEntity.builder()
                .id(voucher.getId())
                .title(voucher.getTitle())
                .rate(voucher.getRate())
                .dueDate(voucher.getDueDate()).build();
    }

    public Voucher toVoucher() {
        return new Voucher(id, title, rate, dueDate);
    }

}
