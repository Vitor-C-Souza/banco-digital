package br.com.vcsouza.banco_digital.domain.repository;


import br.com.vcsouza.banco_digital.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByAccountNumber(String number);
}
