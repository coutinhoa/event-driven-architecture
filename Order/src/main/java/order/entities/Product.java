package order.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "products")
    @JsonIgnore
    private List<OrderDetails> orders_details;


}
