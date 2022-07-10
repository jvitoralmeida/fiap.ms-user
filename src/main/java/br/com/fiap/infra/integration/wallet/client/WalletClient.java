package br.com.fiap.infra.integration.wallet.client;

import br.com.fiap.domain.model.Wallet;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RegisterRestClient(configKey = "wallet-client")
public interface WalletClient {


    @POST
    @Path("/wallet")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response createWallet(Wallet userCredentials);
}