package hanu.edu.infrastructure.order.repository;

import hanu.edu.infrastructure.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderJPARepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByOrderStatus(String orderStatus);
}
