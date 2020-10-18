package pl.sda.moneymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.sda.moneymanager.domain.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor


public class IncomeDto extends BaseEntity {
    private long incomeValueInCent;
    private PersonDto person;
    private IncomeSourceDto incomeSource;
}
