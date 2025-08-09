package vintage.spring.store.vintage_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vintage.spring.store.vintage_spring.entities.Cliente;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}
