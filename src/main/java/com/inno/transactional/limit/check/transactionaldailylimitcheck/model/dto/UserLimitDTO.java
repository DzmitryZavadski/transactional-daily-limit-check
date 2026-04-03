package com.inno.transactional.limit.check.transactionaldailylimitcheck.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserLimitDTO {
    private Long userId;
    private String limitAmount;
}
