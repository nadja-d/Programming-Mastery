/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author User
 */
public class Product {
    private String productID;
    private String productName;
    private String productCategory;
    private double productPrice;
    private String materialsUsedID;
    private double materialCost;
    private int productStock;
    private int mtsQtyWeekday;
    private int mtsQtyWeekends;
    private int pkbwDeliveryQtyWeekday;
    private int pikDeliveryQtyWeekday;
    private int pkbwDeliveryQtyWeekend;
    private int pikDeliveryQtyWeekend;

    public Product(String pID, String pName, String pCategory, double pPrice, String mID, double materialC, int pStock, int mtsQtyWky, int mtsQuantityWkd, int pkbwDeliveryQtyWky, int pikDeliveryQtyWky, int pkbwDeliveryQtyWkd, int pikDeliveryQtyWkd) {
        this.productID = pID;
        this.productName = pName;
        this.productCategory = pCategory;
        this.productPrice = pPrice;
        this.materialsUsedID = mID;
        this.materialCost = materialC;
        this.productStock = pStock;
        this.mtsQtyWeekday = mtsQtyWky;
        this.mtsQtyWeekends = mtsQuantityWkd;
        this.pkbwDeliveryQtyWeekday = pkbwDeliveryQtyWky;
        this.pikDeliveryQtyWeekday = pikDeliveryQtyWky;
        this.pkbwDeliveryQtyWeekend = pkbwDeliveryQtyWkd;
        this.pikDeliveryQtyWeekend = pikDeliveryQtyWkd;
    }
    
    public Product(String pID, String pName, double pPrice){
        this.productID = pID;
        this.productName = pName;
        this.productPrice = pPrice;  
    }

    public String getProductName() {
        return productName;
    }
    
    public int getMtsQtyWeekday() {
        return mtsQtyWeekday;
    }

    public int getMtsQtyWeekends() {
        return mtsQtyWeekends;
    }
    
    public int getPkbwDeliveryQtyWeekday() {
        return pkbwDeliveryQtyWeekday;
    }

    public int getPikDeliveryQtyWeekday() {
        return pikDeliveryQtyWeekday;
    }

    public int getPkbwDeliveryQtyWeekend() {
        return pkbwDeliveryQtyWeekend;
    }

    public int getPikDeliveryQtyWeekend() {
        return pikDeliveryQtyWeekend;
    }
    
    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", productCategory=" + productCategory + ", productPrice=" + productPrice + ", productStock=" + productStock + ", mtsQtyWeekday=" + mtsQtyWeekday + ", mtsQtyWeekends=" + mtsQtyWeekends + ", pkbwDeliveryQtyWeekday=" + pkbwDeliveryQtyWeekday + ", pikDeliveryQtyWeekday=" + pikDeliveryQtyWeekday + ", pkbwDeliveryQtyWeekend=" + pkbwDeliveryQtyWeekend + ", pikDeliveryQtyWeekend=" + pikDeliveryQtyWeekend + '}';
    }
}
