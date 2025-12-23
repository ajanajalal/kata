package ma.carrefour.kata.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private BigDecimal regularPrice;
    private BigDecimal groupPrice;
    private String imageUrl;
}