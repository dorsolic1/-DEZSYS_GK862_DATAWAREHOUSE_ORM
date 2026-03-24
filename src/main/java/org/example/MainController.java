package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestBody User n) {
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping("/products/deleteAll")
    public @ResponseBody String deleteAllProducts() {
        productRepository.deleteAll();
        return "All products deleted";
    }

    @PostMapping("/warehouse")
    public @ResponseBody String addWarehouse(@RequestBody WarehouseData w) {
        warehouseRepository.save(w);
        return "Warehouse saved";
    }

    @GetMapping("/warehouses")
    public @ResponseBody Iterable<WarehouseData> getWarehouses() {
        return warehouseRepository.findAll();
    }

    @PostMapping("/product")
    public @ResponseBody String addProduct(@RequestBody ProductData p) {
        if (p.getWarehouseData() == null || p.getWarehouseData().getWarehouseID() == null) {
            return "Fehler: Kein Warehouse im Produkt angegeben!";
        }
        String wID = p.getWarehouseData().getWarehouseID();
        WarehouseData w = warehouseRepository.findById(wID).orElse(null);
        if (w == null) {
            return "Fehler: Warehouse mit ID " + wID + " existiert nicht in der Datenbank!";
        }
        p.setWarehouseData(w);
        productRepository.save(p);

        return "Produkt " + p.getProductID() + " erfolgreich zu Warehouse " + wID + " hinzugefügt!";
    }
}
