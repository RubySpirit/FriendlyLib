package com.spirituspoland.friendlylib.repository;

import com.spirituspoland.friendlylib.model.Book;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
}
