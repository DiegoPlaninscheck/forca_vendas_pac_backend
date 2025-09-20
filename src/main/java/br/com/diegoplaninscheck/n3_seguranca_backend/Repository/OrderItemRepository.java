package br.com.diegoplaninscheck.n3_seguranca_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.diegoplaninscheck.n3_seguranca_backend.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
