package com.nextuple.restapi.repository;

import com.nextuple.restapi.model.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends MongoRepository<Purchase,String> {
}
