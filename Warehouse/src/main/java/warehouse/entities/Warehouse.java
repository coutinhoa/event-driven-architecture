package warehouse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "warehouse")
@NoArgsConstructor
public class Warehouse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name", nullable= false)
    @NonNull
    private String name;

    @Column(name= "price", nullable= false)
    private double price;

    @Column(name= "available_quantity", nullable= false)
    private int availableQuantity;
}
