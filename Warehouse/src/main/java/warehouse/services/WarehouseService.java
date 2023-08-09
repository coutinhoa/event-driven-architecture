package warehouse.services;

import warehouse.entities.Warehouse;
import warehouse.repositories.WarehouseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {
    private final WarehouseRepository repository;
    WarehouseService(WarehouseRepository repository) {
        this.repository = repository;
    }

    public Page<Warehouse> getAll(String name, int page, int size) {
        Pageable paging = PageRequest.of(page-1, size);
        return repository.findProducts(paging);
    }

    public List<Warehouse> getAvailableProducts() {
        return repository.findAvailableProducts();
    }
}
