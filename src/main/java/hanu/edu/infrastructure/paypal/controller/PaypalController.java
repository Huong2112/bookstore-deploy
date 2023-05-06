package hanu.edu.infrastructure.paypal.controller;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import hanu.edu.infrastructure.paypal.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer/paypal")
public class PaypalController {

    private static final String SUCCESS_URL = "/success";
    private static final String CANCEL_URL = "/cancel";

    @Autowired
    PaypalService service;

    @PostMapping("/pay/{totalPrice}")
    public ResponseEntity<?> payment(@PathVariable double totalPrice) throws PayPalRESTException {
        Payment payment = service.createPayment(
                totalPrice,
                "USD",
                "paypal",
                "sale",
                "Order",
                "http://localhost:3000/" + SUCCESS_URL,
                "http://localhost:3000/" + CANCEL_URL);
//                "http://localhost:8080/" + SUCCESS_URL);

        return new ResponseEntity<>(payment.getLinks(), org.springframework.http.HttpStatus.OK);
    }
}
