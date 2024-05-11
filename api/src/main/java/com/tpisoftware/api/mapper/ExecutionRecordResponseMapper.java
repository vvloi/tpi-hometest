package com.tpisoftware.api.mapper;

import com.tpisoftware.api.dto.response.ExecutionRecordResponse;
import com.tpisoftware.core.dto.data.ExecutionRecordData;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExecutionRecordResponseMapper {
    List<ExecutionRecordResponse> fromData(List<ExecutionRecordData> executionRecordDataList);
}
