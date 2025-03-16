package org.prog.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductsDto {
    public TitleDto title;
    public ListingDto cost;

}
