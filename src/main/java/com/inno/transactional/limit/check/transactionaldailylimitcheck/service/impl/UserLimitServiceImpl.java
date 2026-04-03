package com.inno.transactional.limit.check.transactionaldailylimitcheck.service.impl;

import com.inno.transactional.limit.check.transactionaldailylimitcheck.exception.NotFoundException;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.UserLimit;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.dto.TransactionRequestDTO;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.dto.UserLimitDTO;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.repository.UserLimitRepository;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.service.UserLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserLimitServiceImpl implements UserLimitService {

    private UserLimitRepository userLimitRepository;

    @Override
    public UserLimit createOrUpdate(UserLimitDTO dto) {
        return userLimitRepository.findByUserId(dto.getUserId())
                .map(existing -> {
                    existing.setLimitAmount(dto.getLimitAmount());
                    existing.setRemainingAmount(dto.getLimitAmount());
                    existing.setLastUpdated(LocalDateTime.now());
                    return userLimitRepository.save(existing);
                })
                .orElseGet(() -> userLimitRepository.save(
                                UserLimit.builder()
                                        .userId(dto.getUserId())
                                        .limitAmount(dto.getLimitAmount())
                                        .remainingAmount(dto.getLimitAmount())
                                        .lastUpdated(LocalDateTime.now())
                                        .build()
                        )
                );
    }

    @Override
    public boolean checkAndProcess(TransactionRequestDTO transactionRequestDTO) {
        UserLimit limit = userLimitRepository.findByUserId(transactionRequestDTO.getUserId())
                .orElseThrow(() -> new NotFoundException("User limit not found"));

        if (transactionRequestDTO.getAmount().compareTo(limit.getRemainingAmount()) <= 0) {
            limit.setRemainingAmount(
                    limit.getRemainingAmount().subtract(transactionRequestDTO.getAmount())
            );
            userLimitRepository.save(limit);
            return true;
        }
        return false;
    }
}
