package order.dto;

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
    private Long orderId;

    /*public ProductDTO() {
    }
    public ProductDTO(int quantity, Long orderId) {
        this.quantity = quantity;
        this.orderId = orderId;
    }*/

}
