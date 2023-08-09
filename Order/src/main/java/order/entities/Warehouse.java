package order.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "products")
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

    @Column(name= "warehouse_quantity", nullable= false)
    private int warehouseQuantity;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> product;


}
