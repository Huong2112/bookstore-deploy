package hanu.edu.domain.voucher.repository;

import hanu.edu.domain.voucher.model.Voucher;
import hanu.edu.infrastructure.voucher.entity.VoucherEntity;

public interface VoucherRepository {

    Voucher getById(long id);

    void save(VoucherEntity voucherEntity);

    void deleteById(long id);

    Voucher getByTitle(String title);
}
