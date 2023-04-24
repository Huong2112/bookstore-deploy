package hanu.edu.infrastructure.voucher.repository;

import hanu.edu.infrastructure.voucher.entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherJPARepository extends JpaRepository<VoucherEntity, Long> {

    VoucherEntity findByTitle(String title);
}
