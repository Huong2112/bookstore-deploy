package hanu.edu.application.order.controller;

import hanu.edu.domain.order.model.Order;
import hanu.edu.domain.order.service.GetOrderByStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetOrderByStatusController {

    @Autowired
    private GetOrderByStatusService getOrderByStatusService;

    @GetMapping("/order/{status}")
    public List<Order> getOrderByStatus(@PathVariable String status) {
        return getOrderByStatusService.getOrderByStatus(status);
    }
}
