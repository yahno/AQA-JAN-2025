package org.prog.dto_fs;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ігноруємо непотрібні поля
public class GoodsDto {
    public String title;
    public Float price;
    public String category;
}
