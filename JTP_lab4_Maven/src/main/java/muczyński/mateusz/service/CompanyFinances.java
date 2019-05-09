package muczyński.mateusz.service;

import lombok.Getter;
import muczyński.mateusz.loggers.LoggerWarn;

import java.math.BigDecimal;

@Getter
public class CompanyFinances {
    private final  BigDecimal INITIAL_BUDGET = new BigDecimal(200000);
    private final  BigDecimal NOT_MUCH_MONEY = new BigDecimal(200000 * 0.1);
    private BigDecimal budget;

    public CompanyFinances() {
        budget = INITIAL_BUDGET;
    }

    public boolean expense(BigDecimal value){
        if(budget.compareTo(NOT_MUCH_MONEY) < 0){
            LoggerWarn.getInstance().warn("MALO PIENIEDZY: " + budget);
        }
        if(budget.subtract(value).compareTo(BigDecimal.ZERO) < 0){
            return false;
        }

        budget = budget.subtract(value);
        return true;
    }
}
