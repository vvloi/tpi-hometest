package com.tpisoftware.infra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Timestamp;

@Entity
@Table(name = "execution_record")
@Getter
@Setter
public class ExecutionRecordEntity {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "serno_sequence"),
                    @Parameter(name = "initial_value", value = "4"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "serno", nullable = false)
    private int serno;

    @Column(name = "serviceName", nullable = false)
    private String serviceName;

    @Column(name = "msgid", nullable = false)
    private String msgid;

    @Column(name = "requestPayload", nullable = false)
    private String requestPayload;

    @Column(name = "request_timestamp", nullable = false)
    private Timestamp requestTimestamp;
}
