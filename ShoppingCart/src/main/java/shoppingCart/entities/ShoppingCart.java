package shoppingCart.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name = "shoppingCart")
@NoArgsConstructor
public class ShoppingCart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name", nullable= false)
    @NonNull
    private String name;

    @Column(name= "quantity", nullable= false)
    private int quantity;


}
