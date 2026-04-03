package com.inno.transactional.limit.check.transactionaldailylimitcheck.mapper;

import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.UserLimit;
import com.inno.transactional.limit.check.transactionaldailylimitcheck.model.dto.UserLimitDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserLimitMapper {
    UserLimit toEntity(UserLimitDTO dto);

    UserLimitDTO toDto(UserLimit entity);
}
