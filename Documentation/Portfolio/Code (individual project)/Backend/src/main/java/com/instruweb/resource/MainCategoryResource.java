package com.instruweb.resource;

import com.instruweb.domain.MainCategory;
import com.instruweb.service.MainCategoryService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/categories")
public class MainCategoryResource {
    @Inject
    MainCategoryService mainCategoryService;

    public MainCategoryResource() {}

    @GET
    @Path("/{name}")
    public MainCategory getMainCategory(String name) {return mainCategoryService.getMainCategory(name);}

    @GET
    @Path("/")
    public List<MainCategory> getAllMainCategories() {return mainCategoryService.getAllMainCategories();}
}
