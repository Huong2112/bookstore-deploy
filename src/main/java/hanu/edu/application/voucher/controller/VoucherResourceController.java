package hanu.edu.application.voucher.controller;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.service.CustomerResourceService;
import hanu.edu.domain.user.model.User;
import hanu.edu.domain.user.service.UserResourceService;
import hanu.edu.domain.voucher.model.Voucher;
import hanu.edu.domain.voucher.model.VoucherDTO;
import hanu.edu.domain.voucher.service.VoucherResourceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class VoucherResourceController {
    private final VoucherResourceService voucherResourceService;

    private final UserResourceService userResourceService;

    @PostMapping("/admin/voucher")
    public ResponseEntity<String> create(@RequestBody VoucherDTO voucherDTO) {
        voucherResourceService.create(new Voucher(voucherDTO.getCustomerId(), voucherDTO.getTitle(), voucherDTO.getRate(), voucherDTO.getDueDate()));
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/admin/vouchers")
    public List<Voucher> getAll() {
        List<Voucher> vouchers = voucherResourceService.getAllVouchers();
        HashMap<Voucher, String> map = new HashMap<>();
        for (Voucher voucher : vouchers) {
            long customerId = voucher.getCustomerId();
            Optional<User> user = userResourceService.getUserById(customerId);
            String email;
            if (user.isPresent()) {
                email = user.get().getEmail();
            } else {
                email = "";
            }
            voucher.setCustomerEmail(email);
        }
        return vouchers;
    }
    @GetMapping("/admin/voucher/{id}")
    public Voucher getById(@PathVariable long id) {
        return voucherResourceService.getById(id);
    }

    @DeleteMapping("/admin/voucher/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        voucherResourceService.deleteById(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/vouchers/{customerId}")
    public List<Voucher> getVouchersByCustomerId(@PathVariable long customerId) {
        return voucherResourceService.getVouchersByCustomerId(customerId);
    }
}
