package hanu.edu.infrastructure.voucher.repository;

import hanu.edu.infrastructure.voucher.entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VoucherJPARepository extends JpaRepository<VoucherEntity, Long> {
    VoucherEntity findByTitle(String title);
    List<VoucherEntity> findByCustomerId(long id);
}
