package com.distributedlibrary.central.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity(name = "addresses")
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class Address {
    @Id
    @Column(nullable = false,updatable = false,unique = true)
    UUID id;

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    String street;

    @Column(nullable = false)
    String number;
}
