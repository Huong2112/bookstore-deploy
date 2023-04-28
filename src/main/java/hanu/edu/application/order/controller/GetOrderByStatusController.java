package hanu.edu.application.order.controller;

import hanu.edu.domain.order.service.GetOrderByStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetOrderByStatusController {

    @Autowired
    private GetOrderByStatusService getOrderByStatusService;

    @GetMapping("/order")
    public List<GetOrderByStatusService.OutputOrder> getOrderByStatus(@RequestParam String status) {
        return getOrderByStatusService.getOrderByStatus(status);
    }
}
