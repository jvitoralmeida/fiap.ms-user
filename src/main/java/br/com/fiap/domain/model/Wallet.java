package br.com.fiap.domain.model;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Wallet {
    public String name;
    public String cpf;
    public String balance;
    public List stores;
}
