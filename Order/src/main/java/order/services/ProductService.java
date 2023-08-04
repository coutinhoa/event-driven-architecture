package order.services;

import order.entities.Product;
import order.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll(String name) {
        return repository.findAll();
    }
}
