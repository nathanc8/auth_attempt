package com.example.test_auth.config; // Adaptez le package selon votre structure

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.test_auth.model.User; // Adaptez le chemin selon votre structure
import com.example.test_auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Vérifier si l'utilisateur existe déjà
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User(
                    "admin",
                    "admin@example.com",
                    passwordEncoder.encode("password"),
                    "ROLE_ADMIN", // Notez le préfixe ROLE_ qui est souvent nécessaire pour Spring Security
                    true
            );
            userRepository.save(admin);
            System.out.println("=======================================");
            System.out.println("Utilisateur admin créé avec succès!");
            System.out.println("Username: admin");
            System.out.println("Password: password");
            System.out.println("=======================================");
        } else {
            System.out.println("L'utilisateur admin existe déjà");
        }
    }
}