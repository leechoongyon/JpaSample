package com.example.repository;

import com.example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value="" +
            "SELECT" +
            "   B.ID as id " +
            "  ,B.TITLE as title " +
            "  ,max(B.price) as price  " +
            "FROM " +
            "   BOOK B " +
            "WHERE " +
            "   B.price =:price " +
            "GROUP BY " +
            "   B.ID, B.TITLE"
            , nativeQuery = true)
    public List<Book> findByNativeQuery(@Param("price") double price);
}