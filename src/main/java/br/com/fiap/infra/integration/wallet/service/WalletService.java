package br.com.fiap.infra.integration.wallet.service;

import br.com.fiap.domain.model.Wallet;
import br.com.fiap.infra.integration.wallet.client.WalletClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class WalletService {

    @RestClient
    WalletClient walletClient;

    public Response createWallet(Wallet wallet) {
        return walletClient.createWallet(wallet);
    }

}
