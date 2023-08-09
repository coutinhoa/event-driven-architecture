package warehouse.repositories;

import warehouse.entities.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    @Query(
            """
            SELECT p FROM Warehouse p ORDER BY (
            case when p.name= 'Apple' THEN 1
            when p.name= 'Orange' THEN 2
            when p.name= 'Chocolate' THEN 3
            when p.name= 'White Chocolate' THEN 4
            when p.name= 'Juice' THEN 5
            when p.name= 'Milk' THEN 6
            when p.name= 'Meat' THEN 7
            when p.name= 'Fish' THEN 8
            when p.name= 'Cheese' THEN 9
            when p.name= 'Bread' THEN 10
            when p.name= 'Greek Yoghurt' THEN 11
            when p.name= 'Yoghurt' THEN 12
            when p.name= 'Shower Gel' THEN 13
            when p.name= 'Shampoo' THEN 14
            else 15 end) 
            """
    )
    Page<Warehouse> findProducts(Pageable pageable);

    @Query("SELECT p FROM Warehouse p WHERE p.availableQuantity>0 ORDER BY p.availableQuantity ASC")
    List<Warehouse> findAvailableProducts();
}
