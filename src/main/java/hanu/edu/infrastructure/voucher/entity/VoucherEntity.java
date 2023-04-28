package hanu.edu.infrastructure.voucher.entity;

import hanu.edu.domain.voucher.model.Voucher;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity(name = "voucher")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VoucherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long customerId;
    private String title;
    private double rate;
    private Date dueDate;
    @ManyToOne
    @JoinColumn(name = "customer")
    private CustomerEntity customer;

    public static VoucherEntity toEntity(Voucher voucher) {
        return VoucherEntity.builder()
                .id(voucher.getId())
                .customerId(voucher.getCustomerId())
                .title(voucher.getTitle())
                .rate(voucher.getRate())
                .dueDate(voucher.getDueDate())
                .build();
    }

    public Voucher toVoucher() {
        return new Voucher(id, customerId, title, rate, dueDate);
    }

}
