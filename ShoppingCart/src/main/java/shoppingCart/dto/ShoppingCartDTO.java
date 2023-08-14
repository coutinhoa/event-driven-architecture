package shoppingCart.dto;
import lombok.*;

import java.io.Serializable;
import java.util.Map;


@Data
@Setter
@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class ShoppingCartDTO implements Serializable {

    private Long id;

    private Long userId;

    private double totalPrice;

    private Map<Long, Integer> productQuantities;
}
