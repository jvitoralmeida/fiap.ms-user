package br.com.fiap.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import org.bson.codecs.pojo.annotations.BsonIgnore;

import java.time.LocalDate;
import java.util.Optional;

public class User extends PanacheMongoEntity {
    public String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public LocalDate birthDate;
    public String email;
    public Long cellphone;
    public String cpf;
    @BsonIgnore
    public String password;
    public Boolean sendNotification;

    public static Optional<PanacheMongoEntityBase> findByCpf(String cpf) {
        return User.find("cpf", cpf).firstResultOptional();
    }
}
