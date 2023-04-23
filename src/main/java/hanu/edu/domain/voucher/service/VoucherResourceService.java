package hanu.edu.domain.voucher.service;

import hanu.edu.domain.voucher.model.Voucher;
import hanu.edu.domain.voucher.repository.VoucherRepository;
import hanu.edu.infrastructure.voucher.entity.VoucherEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VoucherResourceService {
    private final VoucherRepository voucherRepository;

    public void create(Voucher voucher) {
        voucherRepository.save(VoucherEntity.toEntity(voucher));
    }

    public Voucher getById(long id) {
        return voucherRepository.getById(id);
    }

    public void deleteById(long id) {
        voucherRepository.deleteById(id);
    }
}
