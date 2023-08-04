package order.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderDto implements Serializable {

    private Long id;

    private Long userId;

    private double totalPrice;

}
