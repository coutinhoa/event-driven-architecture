package order.services;

import order.dto.ProductDTO;
import order.entities.Product;
import order.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> new ProductDTO(product.getId(),
                        product.getQuantity(),
                        product.getOrder().getId()))
                .collect(Collectors.toList());
    }

    public List<Product> getDetails(Long id) {
        return productRepository.findByOrderId(id);
    }

    /*public Product createOrder(Product product) {
        System.out.println("saved product");
        if(repository.findById(product.getId()).isPresent()){
            throw new Exception ("Product already exists");
        }
        return productRepository.save(product);
    }*/

    /*public Product createProduct(Product product) {
        return productRepository.save(product);
    }*/

    public List<ProductDTO> getProductsByOrderId(Long orderId) {
        List<Product> products = productRepository.findByOrderId(orderId);
        return products.stream()
                .map(product -> new ProductDTO(product.getId(), product.getQuantity(), product.getOrder().getId()))
                .collect(Collectors.toList());
    }

    public void deleteProductById(Long productId) throws Exception{
        if(productRepository.findById(productId).isEmpty()){
            throw new Exception ("Products doesn't exist");
        }
        productRepository.deleteById(productId);
    }
}
