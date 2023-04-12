package com.nextuple.restapi.dao.request;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequestDao {
    private String productName;
    private int quantity;

}
