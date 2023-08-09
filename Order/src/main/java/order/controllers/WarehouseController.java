package order.controllers;

import jakarta.transaction.Transactional;
import order.entities.Warehouse;
import order.services.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Transactional
@RequestMapping("/warehouse")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class WarehouseController {

    private final WarehouseService warehouseService;
    WarehouseController(WarehouseService productService) {
        this.warehouseService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<Warehouse>> getProducts(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam (defaultValue="1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        Page<Warehouse> products = warehouseService.getAll(name, page, pageSize);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/availability")
    public ResponseEntity<List<Warehouse>> getAvailableProductsInWarehouse() {
        List<Warehouse> products = warehouseService.getAvailableProducts();
        return ResponseEntity.ok(products);
    }

}
