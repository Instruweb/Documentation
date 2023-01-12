package com.instruweb.service;

import com.instruweb.domain.MainCategory;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class MainCategoryServiceTest {
    @Inject
    MainCategoryService mainCategoryService;

    @Test
    void testGetMainCategoryByName() {
        // Arrange
        String categoryName = "Gitaren";

        // Act
        MainCategory mainCategory = mainCategoryService.getMainCategory(categoryName);

        // Assert
        Assertions.assertEquals(categoryName, mainCategory.getName());
    }

    @Test
    void testGetAllMainCategories() {
        // Arrange
        List<MainCategory> mainCategoryList = new ArrayList<>();

        // Act
        List<MainCategory> getMainCategories = mainCategoryService.getAllMainCategories();

        // Assert
        Assertions.assertNotEquals(mainCategoryList, getMainCategories);
    }
}
