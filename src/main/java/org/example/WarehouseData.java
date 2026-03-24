package org.example;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class WarehouseData {

    @Id
    private String warehouseID;
    private String warehouseName;
    private String warehouseAddress;
    private String warehousePostalCode;
    private String warehouseCity;

    public WarehouseData() {
    }

    @OneToMany(mappedBy = "warehouseData", cascade = CascadeType.ALL)
    private List<ProductData> products;

    // Getter & Setter
    public String getWarehouseID() { return warehouseID; }
    public void setWarehouseID(String warehouseID) { this.warehouseID = warehouseID; }
    public String getWarehouseName() { return warehouseName; }
    public void setWarehouseName(String warehouseName) { this.warehouseName = warehouseName; }
    public String getWarehouseAddress() { return warehouseAddress; }
    public void setWarehouseAddress(String warehouseAddress) { this.warehouseAddress = warehouseAddress; }
    public String getWarehousePostalCode() { return warehousePostalCode; }
    public void setWarehousePostalCode(String warehousePostalCode) { this.warehousePostalCode = warehousePostalCode; }
    public String getWarehouseCity() { return warehouseCity; }
    public void setWarehouseCity(String warehouseCity) { this.warehouseCity = warehouseCity; }
    public List<ProductData> getProducts() { return products; }
    public void setProducts(List<ProductData> products) { this.products = products; }

}
