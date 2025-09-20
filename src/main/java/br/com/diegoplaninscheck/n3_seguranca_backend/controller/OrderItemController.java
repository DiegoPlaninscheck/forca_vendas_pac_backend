package br.com.diegoplaninscheck.n3_seguranca_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegoplaninscheck.n3_seguranca_backend.model.OrderItem;
import br.com.diegoplaninscheck.n3_seguranca_backend.service.OrderItemService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/ordersItem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER_CREATE') || hasRole('admin')")
    @Operation(summary = "Create new Order Item")
    public ResponseEntity<OrderItem> create(@RequestBody OrderItem orderItem) {
        System.out.println(orderItem.getPrice());
        System.out.println(orderItem.getQuantity());
        System.out.println(orderItem.getProduct());
        return ResponseEntity.ok(orderItemService.create(orderItem));
    }

    @GetMapping
    @PreAuthorize("hasRole('USER_GET') || hasRole('admin')")
    @Operation(summary = "List all Order Item")
    public ResponseEntity<List<OrderItem>> listar() {
        return ResponseEntity.ok(orderItemService.listAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER_GET') || hasRole('admin')")
    @Operation(summary = "Find Order Item by ID")
    public ResponseEntity<OrderItem> findById(@PathVariable Long id) {
        return orderItemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER_UPDATE') || hasRole('admin')")
    @Operation(summary = "Update Order Item by ID")
    public ResponseEntity<OrderItem> update(@PathVariable Long id, @RequestBody OrderItem orderItem) {
        try {
            return ResponseEntity.ok(orderItemService.update(id, orderItem));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER_DELETE') || hasRole('admin')")
    @Operation(summary = "Delete Order Item by ID")
    public ResponseEntity<List<OrderItem>> remove(@PathVariable Long id) {
        orderItemService.remove(id);
        return ResponseEntity.ok(orderItemService.listAll());
    }
}
