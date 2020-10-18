package pl.sda.moneymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class BaseDto {
//
    protected Long id;
    protected LocalDateTime creationTimestamp;
    protected LocalDateTime updateTimestamp;

}
