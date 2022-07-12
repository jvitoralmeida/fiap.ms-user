package br.com.fiap.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.smallrye.common.constraint.NotNull;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.Optional;

@MongoEntity(collection = "user")
public class User  {
    public ObjectId id;
    public String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public LocalDate birthDate;
    public String email;
    public Long cellphone;
    public String cpf;
    @BsonIgnore
    public String password;
    public Boolean sendNotification;
}
