package warehouse.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import warehouse.dto.WarehouseProductDTO;
import warehouse.entities.WarehouseProduct;
import warehouse.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Page<WarehouseProduct> getAll(String name, int page, int size) {
        Pageable paging = PageRequest.of(page - 1, size);
        return repository.findProducts(paging);
    }

    public List<WarehouseProduct> getAvailableProducts() {
        return repository.findAvailableProducts();
    }

    public void reduceAvailableProducts(WarehouseProductDTO productInShoppingCart) {
        int inventory = repository.findQuantityById(Math.toIntExact(productInShoppingCart.getId()));
        var newQuantity = inventory - productInShoppingCart.getAvailableQuantity();
        //productInShoppingCart.setAvailableQuantity(newQuantity);
        //price needs to be bigdecimal cause it's money
        repository.saveNewProductQuantity(productInShoppingCart.getId(), newQuantity);
    }
}
