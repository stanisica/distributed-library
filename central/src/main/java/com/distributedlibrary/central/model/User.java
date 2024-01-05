package com.distributedlibrary.central.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity(name = "users")
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class User {
    @Id
    @Column(nullable = false, updatable = false, unique = true)
    UUID id;

    @Column(nullable = false)
    String firstname;

    @Column(nullable = false)
    String lastname;

    @Column(nullable = false, unique = true)
    String jmbg;

    @Column(columnDefinition = "integer default 0")
    Integer booksRented;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    Address address;

    public boolean rentBook(){
        if (booksRented >= 3){
            return false;
        }
        booksRented++;
        return true;
    }

    public boolean returnBook(){
        if (booksRented == 0){
            return false;
        }
        booksRented--;
        return true;
    }
}
