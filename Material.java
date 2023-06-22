/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author User
 */
public class Material {

    private String materialName;
    private int materialPrice;
    private double materialStock;
    private Vendor vendor;
    
    public Material(String materialName, int materialPrice, double materialStock, Vendor vendor) {
        this.materialName = materialName;
        this.materialPrice = materialPrice;
        this.materialStock = materialStock;
        this.vendor = vendor;
    }
    
    public String getMaterialName() {
        return materialName;
    }

    public int getMaterialPrice() {
        return materialPrice;
    }

    public double getMaterialStock() {
        return materialStock;
    }

    public Vendor getVendor() {
        return vendor;
    }
    
}
