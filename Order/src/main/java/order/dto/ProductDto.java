package order.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class ProductDto implements Serializable {

    private Long id;

    private int quantity;

    private Long orderId;

}
