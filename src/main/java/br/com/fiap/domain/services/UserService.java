package br.com.fiap.domain.services;

import br.com.fiap.domain.model.Auth;
import br.com.fiap.domain.model.User;
import br.com.fiap.domain.model.UserLogin;
import br.com.fiap.infra.integration.keycloak.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.common.jaxrs.StatusTypeImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
@RequiredArgsConstructor
public class UserService {

    private final KeycloakService keycloakService;

    public Response authenticateUser(UserLogin login){

        return keycloakService.authenticate(login);
    }

    public Response createNewUser(User user) {
        Response newUser = keycloakService.createNewUser(new UserLogin(user.cpf, user.password));
        user.persist();
        return newUser;
    }
}
