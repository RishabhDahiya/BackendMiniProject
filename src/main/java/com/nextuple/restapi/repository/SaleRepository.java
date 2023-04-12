package com.nextuple.restapi.repository;

import com.nextuple.restapi.model.Purchase;
import com.nextuple.restapi.model.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends MongoRepository<Sale,String> {
}
