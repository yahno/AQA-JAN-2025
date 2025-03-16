package org.prog.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PriceDto {
    public String Currency;
    public String DisplayAmount;
}
