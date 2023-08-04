package order.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderDetailsDto implements Serializable {

    private Long id;

    private int quantity;

    private Long order_id;
    private Long product_id;

}
