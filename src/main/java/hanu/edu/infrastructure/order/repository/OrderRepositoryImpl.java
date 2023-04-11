package hanu.edu.infrastructure.order.repository;

import hanu.edu.domain.order.model.Order;
import hanu.edu.domain.order.model.OrderStatus;
import hanu.edu.domain.order.repository.OrderRepository;
import hanu.edu.infrastructure.order.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private OrderJPARepository orderJPARepository;

    @Override
    public void save(Order order) {
        orderJPARepository.save(OrderEntity.toEntity(order));
    }

    @Override
    public Order getById(long id) {
        return orderJPARepository.findById(id).get().toOrder();
    }

    @Override
    public List<Order> getByOrderStatus(OrderStatus status) {
        return orderJPARepository.findByOrderStatus(String.valueOf(status)).stream().map(OrderEntity::toOrder)
                .collect(Collectors.toList());
    }
}
