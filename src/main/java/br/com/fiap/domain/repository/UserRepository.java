package br.com.fiap.domain.repository;

import br.com.fiap.domain.model.User;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {

    public Optional<User> findByCpf(String cpf) {
        return find("cpf", cpf).firstResultOptional();
    }
}
