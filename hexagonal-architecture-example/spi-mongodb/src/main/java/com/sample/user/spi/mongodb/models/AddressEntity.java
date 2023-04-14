package com.sample.user.spi.mongodb.models;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Data
public class AddressEntity {
    private String street;
    private String city;
    private String state;
    private String country;
    @BsonProperty("zip_code")
    private String zipCode;

    public AddressEntity() {
        // ORM purpose
    }

    public AddressEntity(String street, String city, String state, String country, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
}
