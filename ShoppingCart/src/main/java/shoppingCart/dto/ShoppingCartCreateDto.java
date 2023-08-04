package shoppingCart.dto;

import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class ShoppingCartCreateDto implements Serializable {

    @NonNull
    private String name;

    private int quantity;
}
