package pl.sda.moneymanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("osoba")
    private PersonDto person;
    private IncomeSourceDto incomeSource;
}
