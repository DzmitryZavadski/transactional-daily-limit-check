package com.inno.transactional.limit.check.transactionaldailylimitcheck.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserLimitDto {
    private Long userId;
    private String limitAmount;
}
