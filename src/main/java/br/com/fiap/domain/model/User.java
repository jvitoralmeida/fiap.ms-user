package br.com.fiap.domain.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

@MongoEntity(collection = "user")
public class User {
    public ObjectId id;
    public String name;
    public String birthDate;
    public String email;
    public Long cellphone;
    public String cpf;
    @BsonIgnore
    public String password;
    public Boolean sendNotification;
}
