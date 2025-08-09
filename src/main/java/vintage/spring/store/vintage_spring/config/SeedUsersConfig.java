package vintage.spring.store.vintage_spring.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import vintage.spring.store.vintage_spring.entities.Cliente;
import vintage.spring.store.vintage_spring.repository.ClienteRepository;

@Configuration
public class SeedUsersConfig {

    @Bean
    CommandLineRunner seedUsers(ClienteRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.findByEmail("admin@vintage.com").isEmpty()) {
                var admin = new Cliente();
                admin.setNome("Administrador");
                admin.setEmail("admin@vintage.com");
                admin.setSenha(encoder.encode("123")); // BCRYPT!
                admin.setRole("ADMIN");
                repo.save(admin);
            }
        };
    }
}
