package com.tpisoftware.infra.repository;

import com.tpisoftware.infra.entity.ExecutionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExecutionRecordDAO extends JpaRepository<ExecutionRecordEntity, Integer> {
    @Query(value = "SELECT serno, \"serviceName\" service_name, msgid, \"requestPayload\" request_payload, request_timestamp FROM execution_record", nativeQuery = true)
    List<ExecutionRecordEntity> findAll();
}
