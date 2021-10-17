package com.spirituspoland.friendlylib.repository;

import com.spirituspoland.friendlylib.model.Category;
import com.spirituspoland.friendlylib.model.Title;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title, UUID> {

    Page<Title> findAllByCategoriesIn(List<Category> categories, Pageable pageable);

}
