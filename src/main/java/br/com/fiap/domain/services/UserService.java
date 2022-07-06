package br.com.fiap.domain.services;

import br.com.fiap.domain.model.User;
import br.com.fiap.domain.model.UserLogin;
import br.com.fiap.domain.repository.UserRepository;
import br.com.fiap.infra.integration.keycloak.service.KeycloakService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
@RequiredArgsConstructor
public class UserService {

    private final KeycloakService keycloakService;
    private final UserRepository repository;
    public Response authenticateUser(UserLogin login){

        return keycloakService.authenticate(login);
    }

    public Response createNewUser(User user) {
        Response newUser = keycloakService.createNewUser(new UserLogin(user.cpf, user.password));
        repository.persist(user);
        return newUser;
    }
}
