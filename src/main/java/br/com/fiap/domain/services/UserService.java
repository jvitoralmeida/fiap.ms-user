package br.com.fiap.domain.services;

import br.com.fiap.domain.model.User;
import br.com.fiap.domain.model.UserLogin;
import br.com.fiap.domain.model.Wallet;
import br.com.fiap.domain.repository.UserRepository;
import br.com.fiap.infra.integration.keycloak.service.KeycloakService;
import br.com.fiap.infra.integration.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class UserService {

    private final KeycloakService keycloakService;
    private final UserRepository repository;

    private final WalletService walletService;

    public Response authenticateUser(UserLogin login){

        return keycloakService.authenticate(login);
    }

    public Response createNewUser(User user) {
        Response newUser = keycloakService.createNewUser(new UserLogin(user.cpf, user.password));
        repository.persist(user);

        walletService.createWallet(new Wallet(user.name,user.cpf,"0.0", List.of()));

        return newUser;
    }
}
