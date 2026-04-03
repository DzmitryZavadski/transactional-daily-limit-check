package com.inno.transactional.limit.check.transactionaldailylimitcheck.repository;

import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.UserLimit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLimitRepository extends JpaRepository<UserLimit,Long> {
    Optional<UserLimit> findByUserId(Long userId);
}
