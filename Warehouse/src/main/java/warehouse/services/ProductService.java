package warehouse.services;

import warehouse.entities.Product;
import warehouse.repositories.ProductRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Page<Product> getAll(String name, int page, int size) {
        Pageable paging = PageRequest.of(page-1, size);
        return repository.findProducts(paging);
    }

    public List<Product> getAvailableProducts() {
        return repository.findAvailableProducts();
    }
}
