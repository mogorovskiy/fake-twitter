package com.mogorovskiy.faketwitter.services.impl;

import com.mogorovskiy.faketwitter.domain.entities.Category;
import com.mogorovskiy.faketwitter.repositories.CategoryRepository;
import com.mogorovskiy.faketwitter.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        String categoryName = category.getName();
        if (categoryRepository.existsByNameIgnoreCase(categoryName)) {
            throw new IllegalArgumentException("Category already exists with name:" + categoryName);
        }
        categoryRepository.save(category);
    }
}
