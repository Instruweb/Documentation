package com.instruweb.repository;

import com.instruweb.domain.MainCategory;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MainCategoryRepository implements PanacheRepository<MainCategory> {}
