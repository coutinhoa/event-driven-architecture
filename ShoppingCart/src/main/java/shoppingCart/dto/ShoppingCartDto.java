package shoppingCart.dto;
import lombok.*;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ShoppingCartDto extends shoppingCart.dto.ShoppingCartCreateDto {

    private Long id;

}
