package com.nextuple.restapi.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(value="purchase")
public class Purchase {
     @Id
     private String id;
     private String purchaseId;
     private String productName;
     private  int quantity;
     private double price;

     public Purchase(String purchaseId, String productName, int quantity, double price) {
          this.purchaseId = purchaseId;
          this.productName = productName;
          this.quantity = quantity;
          this.price = price;
     }
}
