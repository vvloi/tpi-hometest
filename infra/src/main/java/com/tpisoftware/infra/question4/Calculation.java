package com.tpisoftware.infra.question4;

import com.tpisoftware.infra.repository.ExecutionRecordDAO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.env.Environment;

@Getter
@Setter
public class Calculation {
    private Environment environment;
    private ExecutionRecordDAO executionRecordDAO;

    private Calculation() {}

    private static class CalculationHolder {
        private static final Calculation INSTANCE = new Calculation();
    }

    public static Calculation getInstance() {
        return CalculationHolder.INSTANCE;
    }
}
