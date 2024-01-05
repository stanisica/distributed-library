package com.distributedlibrary.city.repository;

import com.distributedlibrary.city.model.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRentalRepository extends JpaRepository<BookRental, UUID> {
    @Query("SELECT r.id FROM rentals r WHERE r.isbn = ?1")
    UUID findByISBN(String isbn);
}
