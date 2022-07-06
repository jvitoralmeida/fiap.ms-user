package br.com.fiap.infra.integration.keycloak.service;

import br.com.fiap.domain.model.UserLogin;
import br.com.fiap.infra.integration.keycloak.client.KeycloakClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class KeycloakService {

    @RestClient
    KeycloakClient keycloakClient;

    public Response authenticate(UserLogin login) {
        return keycloakClient.authenticate(login);
    }

    public Response createNewUser(UserLogin userForm) {
        return keycloakClient.create(userForm);
    }
}
