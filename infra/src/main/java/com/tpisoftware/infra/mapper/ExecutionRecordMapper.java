package com.tpisoftware.infra.mapper;

import com.tpisoftware.core.dto.data.ExecutionRecordData;
import com.tpisoftware.infra.entity.ExecutionRecordEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExecutionRecordMapper {
    List<ExecutionRecordData> fromEntity(List<ExecutionRecordEntity> entities);
}
