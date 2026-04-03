package com.inno.transactional.limit.check.transactionaldailylimitcheck.service;

import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.UserLimit;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.dto.TransactionRequestDTO;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.dto.UserLimitDTO;

public interface UserLimitService {
    UserLimit createOrUpdate(UserLimitDTO dto);
    boolean checkAndProcess(TransactionRequestDTO dto);
}
