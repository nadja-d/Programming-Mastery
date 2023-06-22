/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

public class PurchaseOrderDetail {
    
    private String poDetailID;
    private String poID;
    private String materialID;
    private int quantity;
    
    public PurchaseOrderDetail(String poDetailID, String poID, String materialID, int quantity) {
        this.poDetailID = poDetailID;
        this.poID = poID;
        this.materialID = materialID;
        this.quantity = quantity;
    }
    
    public String getPoDetailID() {
        return poDetailID;
    }

    public String getPoID() {
        return poID;
    }

    public String getMaterialID() {
        return materialID;
    }
    
    public int getQuantity() {
        return quantity;
    }
}
