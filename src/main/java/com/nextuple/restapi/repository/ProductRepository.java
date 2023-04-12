package com.nextuple.restapi.repository;

import com.nextuple.restapi.model.Product;
import com.nextuple.restapi.model.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
    @Query("{name : '?0'}")
    Product findByName(String name);
}
