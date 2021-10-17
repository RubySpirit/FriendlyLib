package com.spirituspoland.friendlylib.service;

import com.spirituspoland.friendlylib.model.Category;
import com.spirituspoland.friendlylib.model.Title;
import com.spirituspoland.friendlylib.repository.TitleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TitleService {
    private final TitleRepository titleRepository;


    public Page<Title> findAllTitlesByCategory(List<Category> categories, Pageable pageable) {
        return titleRepository.findAllByCategoriesIn(categories, pageable);
    }
}
