package com.mogorovskiy.faketwitter.services;

import com.mogorovskiy.faketwitter.domain.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category createCategory(Category category);
}
