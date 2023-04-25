package hanu.edu.domain.voucher.service;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.repository.CustomerRepository;
import hanu.edu.domain.voucher.model.Voucher;
import hanu.edu.domain.voucher.repository.VoucherRepository;
import hanu.edu.infrastructure.voucher.entity.VoucherEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VoucherResourceService {
    private final VoucherRepository voucherRepository;
    private final CustomerRepository customerRepository;

    public void create(Voucher voucher) {
        voucherRepository.save(VoucherEntity.toEntity(voucher));
    }

    public Voucher getById(long id) {
        return voucherRepository.getById(id);
    }

    public List<Voucher> getAllVouchers() {
        return voucherRepository.getAllVouchers();
    }
    public Customer getCustomer(long customerId) {
        return customerRepository.getById(customerId);
    }

    public List<Voucher> getVouchersByCustomerId(long id) {
        return voucherRepository.getVouchersByCustomerId(id);
    }

    public void deleteById(long id) {
        voucherRepository.deleteById(id);
    }
}
