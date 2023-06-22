/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author User
 */
public class OrderDetail {
    private String orderDetailID;
    private String orderID;
    private String productID;
    private int itemQuantity;

    public OrderDetail(String orderDetailID, String orderID, String productID, int itemQuantity) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.productID = productID;
        this.itemQuantity = itemQuantity;
    }
   
    public String getOrderDetailID() {
        return orderDetailID;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getProductID() {
        return productID;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }
}
