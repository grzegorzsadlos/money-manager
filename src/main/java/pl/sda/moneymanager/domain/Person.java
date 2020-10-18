package pl.sda.moneymanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person extends BaseEntity {
    private String name;
    private String surname;
    //zlecamy bazie aby zapisywała do bazy stringa a nie domyślnie integera EnumType.ORDINAL
    @Enumerated(EnumType.STRING)
    private Sex sex;
}
