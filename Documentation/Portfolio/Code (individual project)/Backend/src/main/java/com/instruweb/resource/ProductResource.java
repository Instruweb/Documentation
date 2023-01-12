package com.instruweb.resource;

import com.instruweb.domain.Product;
import com.instruweb.service.ProductService;
import io.quarkus.security.Authenticated;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/products")
public class ProductResource {
    @Inject
    ProductService productService;

    public ProductResource() {}

    @GET
    @Path("/{name}")
    public Product getProduct(String name) {
        return productService.getProduct(name);
    }

    @GET
    @Path("/id/{id}")
    public Product getProductById(Integer id) {
        return productService.getProductById(id);
    }

    @GET
    @Path("/")
    public List<Product> getAllProducts() { return productService.getAllProducts(); }

    @GET
    @Path("/main_category/{id}")
    public List<Product> getAllProductsByMainCategoryId(Integer id) { return productService.getAllProductsByMainCategoryId(id); }

    @POST
    @Transactional
    @Authenticated
    @Path("/admin/create")
    public Response createProduct(Product product) {
        Product productWithId = productService.createProduct(product);
        return Response.created(URI.create("/api/products/" + productWithId.getId())).build();
    }
}
