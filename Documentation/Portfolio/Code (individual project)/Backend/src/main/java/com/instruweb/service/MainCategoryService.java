package com.instruweb.service;

import com.instruweb.domain.MainCategory;
import com.instruweb.repository.MainCategoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class MainCategoryService {
    @Inject
    MainCategoryRepository mainCategoryRepository;

    public MainCategoryService() {}

    public MainCategory getMainCategory(String name) {
        MainCategory mainCategory = mainCategoryRepository.find("name", name).firstResult();

        if (mainCategory == null) {
            throw new NotFoundException();
        }

        return mainCategory;
    }

    public List<MainCategory> getAllMainCategories() {
        List<MainCategory> mainCategoriesList = mainCategoryRepository.listAll();

        if (mainCategoriesList == null) {
            throw new NotFoundException();
        }

        return mainCategoriesList;
    }
}
