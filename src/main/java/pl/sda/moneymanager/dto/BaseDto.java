package pl.sda.moneymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto {
    private Long id;
    private LocalDateTime creationTimestamp;
    private LocalDateTime updateTimestamp;

}
