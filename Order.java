/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class Order {

    private String orderID;
    private Date orderDateTime;
    private String orderCategory;
    private String orderStatus;
    private String outlet;
    private ArrayList<OrderDetail> orderDetail;

    public Order(String orderID, Date orderDateTime, String orderCategory, String orderStatus, String outlet) {
        this.orderID = orderID;
        this.orderDateTime = orderDateTime;
        this.orderCategory = orderCategory;
        this.orderStatus = orderStatus;
        this.outlet = outlet;
    }
    
    public String getOrderID() {
        return orderID;
    }

    public Date getOrderDateTime() {
        return orderDateTime;
    }

    public String getOrderCategory() {
        return orderCategory;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getOutlet() {
        return outlet;
    }
    
    public ArrayList<OrderDetail> getOrderDetail() {
        return orderDetail;
    }
    
    public void setOrderDetail(ArrayList<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
