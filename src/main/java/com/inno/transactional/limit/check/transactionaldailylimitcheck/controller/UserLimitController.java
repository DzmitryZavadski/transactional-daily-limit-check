package com.inno.transactional.limit.check.transactionaldailylimitcheck.controller;

import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.UserLimit;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.dto.TransactionRequestDTO;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.dto.UserLimitDTO;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.service.UserLimitService;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.service.impl.UserLimitServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits")
@RequiredArgsConstructor
public class UserLimitController {
    private final UserLimitServiceImpl userLimitServiceImpl;

    @PostMapping
    public UserLimit createOrUpdate(@RequestBody UserLimitDTO dto) {
        return userLimitServiceImpl.createOrUpdate(dto);
    }

    @PostMapping("/check")
    public boolean check(@RequestBody TransactionRequestDTO dto) {
        return userLimitServiceImpl.checkAndProcess(dto);
    }

}
