package order.dto;
import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class WarehouseDto implements Serializable {

    private Long id;

    @NonNull
    private String name;

    private double price;
    private int warehouseQuantity;

}
