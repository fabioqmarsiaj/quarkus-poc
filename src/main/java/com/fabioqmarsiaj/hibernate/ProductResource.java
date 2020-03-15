package com.fabioqmarsiaj.hibernate;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Path("/products")
@Transactional
public class ProductResource {

    @Inject
    EntityManager entityManager;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Product> getProducts(){
        return entityManager.createQuery("select p from Product p", Product.class).getResultList();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    public void addProduct(Product product){
        entityManager.persist(product);
    }
}
