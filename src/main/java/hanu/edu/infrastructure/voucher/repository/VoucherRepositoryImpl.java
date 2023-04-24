package hanu.edu.infrastructure.voucher.repository;

import hanu.edu.domain.voucher.model.Voucher;
import hanu.edu.domain.voucher.repository.VoucherRepository;
import hanu.edu.infrastructure.product.entity.ProductEntity;
import hanu.edu.infrastructure.voucher.entity.VoucherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class VoucherRepositoryImpl implements VoucherRepository {
    @Autowired
    private VoucherJPARepository voucherJPARepository;

    @Override
    public Voucher getById(long id) {
        Optional<VoucherEntity> voucher = voucherJPARepository.findById(id);
        return voucher.isEmpty() ? null : voucher.get().toVoucher();
    }

    @Override
    public void save(VoucherEntity voucherEntity) {
        voucherJPARepository.save(voucherEntity);
    }


    @Override
    public void deleteById(long id) {
        voucherJPARepository.deleteById(id);
    }

    @Override
    public Voucher getByTitle(String title) {
        VoucherEntity voucherEntity = voucherJPARepository.findByTitle(title);
        return voucherEntity == null ? null : voucherEntity.toVoucher();
    }
}
