package com.inno.transactional.limit.check.transactionaldailylimitcheck.service.impl;

import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.UserLimit;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.dto.TransactionRequestDTO;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.dto.UserLimitDTO;
import org.springframework.stereotype.Service;

@Service
public class UserLimitServiceImpl {
    public UserLimit createOrUpdate(UserLimitDTO dto) {
        return null;
    }

    public boolean checkAndProcess(TransactionRequestDTO dto) {
        return false;
    }
}
