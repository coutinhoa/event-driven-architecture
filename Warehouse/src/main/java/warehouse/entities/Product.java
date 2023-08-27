package warehouse.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product implements Serializable {

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
