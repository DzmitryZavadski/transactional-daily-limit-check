package com.inno.transactional.limit.check.transactionaldailylimitcheck.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDto {
    private Long userId;
    private BigDecimal amount;
}
