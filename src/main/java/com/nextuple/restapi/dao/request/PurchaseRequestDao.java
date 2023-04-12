package com.nextuple.restapi.dao.request;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequestDao {
    private String productName;
    private int quantity;
    private double price;

}
