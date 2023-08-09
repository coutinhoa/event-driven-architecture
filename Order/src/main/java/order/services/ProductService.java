package order.services;

import order.entities.Product;
import order.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final WarehouseRepository warehouseRepository;
    ProductService(ProductRepository repository, WarehouseRepository warehouseRepository) {
        this.repository = repository;
        this.warehouseRepository = warehouseRepository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public List<Product> getDetails(Long id) {
        return repository.findByOrderId(id);
    }

    public Product createOrder(Product order){
        System.out.println("saved order");
        return repository.save(order);
    }
}
