package br.com.fiap.domain.model;

import java.time.LocalDate;

import org.mindrot.jbcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class User extends PanacheMongoEntity {
    public String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public LocalDate birthDate;
    public String email;
    public Long cellphone;
    public String cpf;
    public String password;
    public Boolean sendNotification;

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt(12));
    }
}
