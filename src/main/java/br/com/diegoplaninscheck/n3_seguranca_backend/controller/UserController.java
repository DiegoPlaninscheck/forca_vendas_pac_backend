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

import br.com.diegoplaninscheck.n3_seguranca_backend.model.User;
import br.com.diegoplaninscheck.n3_seguranca_backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER_CREATE') || hasRole('admin')")
    @Operation(summary = "Create new User")
    public ResponseEntity<User> create(@RequestBody User user) {
        System.out.println(user.getName());
        System.out.println(user.getCnpj());
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping
    @PreAuthorize("hasRole('USER_GET') || hasRole('admin')")
    @Operation(summary = "List all Users")
    public ResponseEntity<List<User>> listar() {
        return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER_GET') || hasRole('admin')")
    @Operation(summary = "Find User by ID")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER_UPDATE') || hasRole('admin')")
    @Operation(summary = "Update User by ID")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.update(id, user));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER_DELETE') || hasRole('admin')")
    @Operation(summary = "Delete User by ID")
    public ResponseEntity<List<User>> remove(@PathVariable Long id) {
        userService.remove(id);
        return ResponseEntity.ok(userService.listAll());
    }
}
