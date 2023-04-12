package com.nextuple.restapi.service.impl;

import com.nextuple.restapi.dao.request.PurchaseRequestDao;
import com.nextuple.restapi.dao.request.SaleRequestDao;
import com.nextuple.restapi.dao.response.PurchaseResponseDao;
import com.nextuple.restapi.dao.response.SaleResponseDao;
import com.nextuple.restapi.dao.response.TransactionDao;
import com.nextuple.restapi.dao.response.UpdateDao;
import com.nextuple.restapi.model.Product;
import com.nextuple.restapi.model.Purchase;
import com.nextuple.restapi.model.Sale;
import com.nextuple.restapi.repository.ProductRepository;
import com.nextuple.restapi.repository.PurchaseRepository;
import com.nextuple.restapi.repository.SaleRepository;
import com.nextuple.restapi.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SaleRepository saleRepository;


    public PurchaseResponseDao purchase(List<PurchaseRequestDao> purchaseRequestDaoList)
    {
        try {
              String purchaseID = UUID.randomUUID().toString();
            for (PurchaseRequestDao purchaseRequestDao: purchaseRequestDaoList) {
                 Purchase purchase = new Purchase(purchaseID,purchaseRequestDao.getProductName()
                         ,purchaseRequestDao.getQuantity(),
                         purchaseRequestDao.getPrice());


                 Product product=productRepository.findByName(purchaseRequestDao.getProductName());
                 if(product!=null)
                 {
                     int quantity = product.getQuantity()+purchaseRequestDao.getQuantity();
                     product.setQuantity(quantity);
                 }
                 else {
                      product = new Product(purchaseRequestDao.getProductName()
                             , purchaseRequestDao.getPrice(), purchaseRequestDao.getQuantity());
                 }
                productRepository.save(product);
                purchaseRepository.save(purchase);
            }
            return new PurchaseResponseDao("purchased successfull");
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return  new PurchaseResponseDao("purchase failed");
    }


    public SaleResponseDao sale(List<SaleRequestDao> saleRequestDaoList)
    {
          try {
                 String SaleId = UUID.randomUUID().toString();

              for (SaleRequestDao saleRequestDao:saleRequestDaoList) {

                  Product product = productRepository.findByName(saleRequestDao.getProductName());
                  if(product==null)
                      return new SaleResponseDao("Product Not Available"+saleRequestDao.getProductName());

                    if(product.getQuantity()<saleRequestDao.getQuantity())
                    {
                        return new SaleResponseDao("Inventory not sufficient for :"+saleRequestDao.getProductName()+"requested :"+
                                saleRequestDao.getQuantity()+" available :"+product.getQuantity());
                    }
              }
              for (SaleRequestDao saleRequestDao:saleRequestDaoList) {

                  Product product = productRepository.findByName(saleRequestDao.getProductName());
                         Sale sale= new Sale(SaleId,saleRequestDao.getProductName(),saleRequestDao.getQuantity(),product.getPrice());
                         product.setQuantity(product.getQuantity()-saleRequestDao.getQuantity());

                         saleRepository.save(sale);
                         productRepository.save(product);
              }
              return new SaleResponseDao("Sale Succesfull");
          }
          catch (Exception ex)
          {
                ex.printStackTrace();
          }
          return new SaleResponseDao("Sale Failed");
    }

    public List<Product>showAllProducts()
    {
        return productRepository.findAll();
    }

  public TransactionDao showNumberOfTransactions()
  {
        List<Purchase> purchaseList= purchaseRepository.findAll();

        List<Sale> saleList = saleRepository.findAll();

      HashSet<String> purchaseSet =new HashSet<>();
      for (Purchase purchase:purchaseList) {
          purchaseSet.add(purchase.getPurchaseId());
      }
      HashSet<String> saleSet =new HashSet<>();
      for (Sale sale:saleList) {
          saleSet.add(sale.getSaleId());
      }

      return new TransactionDao(purchaseSet.size()+saleSet.size(),saleSet.size(),purchaseSet.size());
  }

    @Override
    public UpdateDao update(String produtName, double newPrice) {
        Product product = productRepository.findByName(produtName);
        if(product==null)
            return new UpdateDao("Product not Available");
        product.setPrice(newPrice);
        productRepository.save(product);

        return new UpdateDao("update Succesfully");
    }
}
