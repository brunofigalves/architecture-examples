package com.sample.user.spi.mongodb.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.Set;

@MongoEntity(collection = "users")
@Data
public class UserEntity {
    private ObjectId id;
    @BsonProperty("user_id")
    private String userId;
    private String name;
    private String email;
    @BsonProperty("shipping_address")
    private AddressEntity shippingAddress;
    @BsonProperty("billing_address")
    private AddressEntity billingAddress;
    private Set<AddressEntity> addresses;

    public UserEntity() {
        // ORM purpose
    }

    public UserEntity(
            String userId,
            String name,
            String email,
            AddressEntity shippingAddress,
            AddressEntity billingAddress,
            Set<AddressEntity> addresses) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.addresses = addresses;
    }
}
