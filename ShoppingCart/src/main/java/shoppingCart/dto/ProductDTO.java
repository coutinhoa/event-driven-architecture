package shoppingCart.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDTO implements Serializable {
    private Long id;
    private int quantity;
    private Long shoppingCartId;
}
