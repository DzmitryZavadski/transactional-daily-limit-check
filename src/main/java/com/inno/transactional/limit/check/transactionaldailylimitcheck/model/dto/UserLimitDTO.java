package com.inno.transactional.limit.check.transactionaldailylimitcheck.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserLimitDTO {
    private Long userId;
    private BigDecimal limitAmount;
}
