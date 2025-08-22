package br.com.diegoplaninscheck.n3_seguranca_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.diegoplaninscheck.n3_seguranca_backend.Repository.UserRepository;
import br.com.diegoplaninscheck.n3_seguranca_backend.model.User;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User update(Long id, User newUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setCnpj(newUser.getCnpj());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public void remove(Long id) {
        userRepository.deleteById(id);
    }

}
