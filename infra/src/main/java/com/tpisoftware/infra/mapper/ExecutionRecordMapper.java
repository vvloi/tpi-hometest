package com.tpisoftware.infra.mapper;

import com.tpisoftware.core.dto.data.ExecutionRecordData;
import com.tpisoftware.infra.entity.ExecutionRecordEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExecutionRecordMapper {
    List<ExecutionRecordData> fromEntity(List<ExecutionRecordEntity> entities);
}
