package com.nextuple.restapi.service;

import com.nextuple.restapi.dao.request.PurchaseRequestDao;
import com.nextuple.restapi.dao.request.SaleRequestDao;
import com.nextuple.restapi.dao.response.PurchaseResponseDao;
import com.nextuple.restapi.dao.response.SaleResponseDao;
import com.nextuple.restapi.dao.response.TransactionDao;
import com.nextuple.restapi.dao.response.UpdateDao;
import com.nextuple.restapi.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ShopService {

    PurchaseResponseDao purchase(List<PurchaseRequestDao> purchaseRequestDaoList);
    SaleResponseDao sale(List<SaleRequestDao> saleRequestDaos);

    List<Product> showAllProducts();

    TransactionDao showNumberOfTransactions();

    UpdateDao update(String produtName,double newPrice);


}
