package br.com.diegoplaninscheck.n3_seguranca_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.diegoplaninscheck.n3_seguranca_backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
