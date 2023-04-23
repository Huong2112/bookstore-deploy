package hanu.edu.application.order.controller;

import hanu.edu.domain.order.model.OrderStatus;
import hanu.edu.domain.order.service.UpdateStatusOrderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateOrderStatusController {

    @Autowired
    private UpdateStatusOrderService updateStatusOrderService;

    @PutMapping("/order/{id}")
    public void updateOrderStatus(@PathVariable long id, @RequestBody InputStatus inputStatus) {
        updateStatusOrderService.updateStatusOrder(id, inputStatus.fromStatus, inputStatus.toStatus);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    static class InputStatus {
        public String fromStatus;
        public String toStatus;
    }
}
