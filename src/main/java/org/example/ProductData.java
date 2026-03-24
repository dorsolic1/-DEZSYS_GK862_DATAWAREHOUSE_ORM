package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class ProductData {

    @Id
    private String productID;
    private String productName;
    private String productCategory;
    private int productQuantity;
    private String productUnit;

    public ProductData() {
    }

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private WarehouseData warehouseData;

    // Getter & Setter
    public String getProductID() { return productID; }
    public void setProductID(String productID) { this.productID = productID; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getProductCategory() { return productCategory; }
    public void setProductCategory(String productCategory) { this.productCategory = productCategory; }
    public int getProductQuantity() { return productQuantity; }
    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }
    public String getProductUnit() { return productUnit; }
    public void setProductUnit(String productUnit) { this.productUnit = productUnit; }
    public WarehouseData getWarehouseData() { return warehouseData; }
    public void setWarehouseData(WarehouseData warehouseData) { this.warehouseData = warehouseData; }
}
