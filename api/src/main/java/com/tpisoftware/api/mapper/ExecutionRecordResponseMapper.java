package com.tpisoftware.api.mapper;

import com.tpisoftware.api.dto.response.ExecutionRecordResponse;
import com.tpisoftware.core.dto.data.ExecutionRecordData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExecutionRecordResponseMapper {
    List<ExecutionRecordResponse> fromData(List<ExecutionRecordData> executionRecordDataList);
}
