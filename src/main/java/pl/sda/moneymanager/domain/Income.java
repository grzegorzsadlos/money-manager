package pl.sda.moneymanager.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Income extends BaseEntity {

    private long incomeValueInCent;

    @ManyToOne
    private Person person;

    @ManyToOne
    private IncomeSource incomeSource;
}
