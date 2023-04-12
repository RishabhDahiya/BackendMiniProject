package com.nextuple.restapi.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(value="Sale")
public class Sale {
    @Id
    private String id;


    private String saleId;
    private String productName;
    private  int quantity;
    private double price;

    public Sale(String saleId, String productName, int quantity, double price) {
        this.saleId = saleId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}

