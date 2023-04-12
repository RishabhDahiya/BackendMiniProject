package com.nextuple.restapi.dao.response;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TransactionDao {
    private int totalTransaction;
    private int saleTransaction;
    private int purchaseTransaction;


}
