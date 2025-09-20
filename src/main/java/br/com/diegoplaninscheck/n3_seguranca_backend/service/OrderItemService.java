package br.com.diegoplaninscheck.n3_seguranca_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.diegoplaninscheck.n3_seguranca_backend.Repository.OrderItemRepository;
import br.com.diegoplaninscheck.n3_seguranca_backend.model.OrderItem;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem create(OrderItem OrderItem) {
        return orderItemRepository.save(OrderItem);
    }

    public List<OrderItem> listAll() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem update(Long id, OrderItem newOrderItem) {
        return orderItemRepository.findById(id).map(order -> {
            order.setProduct(newOrderItem.getProduct());
            order.setPrice(newOrderItem.getPrice());
            return orderItemRepository.save(newOrderItem);
        }).orElseThrow(() -> new RuntimeException("Order Item not found!"));
    }

    public void remove(Long id) {
        orderItemRepository.deleteById(id);
    }
}
