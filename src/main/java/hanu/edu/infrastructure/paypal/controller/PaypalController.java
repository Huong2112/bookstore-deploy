package hanu.edu.infrastructure.paypal.controller;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import hanu.edu.domain.shoppingCart.service.OutputCart;
import hanu.edu.infrastructure.paypal.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer/paypal")
public class PaypalController {


    private static final String SUCCESS_URL = "pay/success";
    private static final String CANCEL_URL = "pay/cancel";

    @Autowired
    PaypalService service;

    @PostMapping("/pay")
    public ResponseEntity<?> payment(@RequestBody List<OutputCart> outputCart) throws PayPalRESTException {
        double totalPrice = 0;
        for (OutputCart cart : outputCart) {
            totalPrice += cart.getTotalPrice();
        }
        Payment payment = service.createPayment(
                totalPrice,
                "USD",
                "paypal",
                "sale",
                "Order",
                "http://localhost:8080/" + CANCEL_URL,
                "http://localhost:8080/" + SUCCESS_URL);
        return new ResponseEntity<>(payment.getLinks(), org.springframework.http.HttpStatus.OK);
    }
}
