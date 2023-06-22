/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

//public class PurchaseOrder {
//      private String purchaseOrderID;
//      private String vendor;
//      private String requestedBy; 
//      private String requestedDate;
//      private String requestStatus;
//      private PurchaseOrderDetail[] purchaseOrderDetails;
//      private String shippingMethods;
//      private String paymentTerms;
//      
//      public PurchaseOrder(String poID, String vendor, String by, String date, String status, String shippingMethod, String payTerms, PurchaseOrderDetail[] poDetails) {
//          this.purchaseOrderID = poID;
//          this.vendor = vendor;          
//          this.requestedBy = by;
//          this.requestedDate = date;
//          this.requestStatus = status;
//          this.purchaseOrderDetails = poDetails;
//          this.shippingMethods = shippingMethod;
//          this.paymentTerms = payTerms;
//      }
//      
//      public PurchaseOrder(String poID, String vendor, String by, String date, String status, String shippingMethod, String payTerms) {
//          this.purchaseOrderID = poID;
//          this.vendor = vendor;          
//          this.requestedBy = by;
//          this.requestedDate = date;
//          this.requestStatus = status;
//          this.shippingMethods = shippingMethod;
//          this.paymentTerms = payTerms;
//      }
// 
//    public String getPurchaseOrderID() {
//        return purchaseOrderID;
//    }
//
//    public String getVendor() {
//        return vendor;
//    }
//
//    public String getShippingMethods() {
//        return shippingMethods;
//    }
//
//    public String getPaymentTerms() {
//        return paymentTerms;
//    }      
//     
//    public String getRequestedBy() {
//        return requestedBy;
//    }
//
//    public String getRequestedDate() {
//        return requestedDate;
//    }
//
//    public String getRequestStatus() {
//        return requestStatus;
//    }
    
//    public double calcSubTotal(){
//       double subTotal = 0;
//        for(int i = 1; i <= purchaseOrderDetails.length; i++){
//            subTotal += purchaseOrderDetails[i-1].calcSubTotal();
//        }
//        return subTotal;
//    }
    
//    public double calcTax(){
//        return calcSubTotal()*0.10;
//    }
//    
//    public double calcTotal(){
//        return calcSubTotal() + calcTax();
//    }

import java.util.ArrayList;

public class PurchaseOrder {
    private String purchaseOrderID;
    private String poDate;
    private String vendorID;
    private String shippingMethod;
    private String paymentTerms;
    private String requestBy;
    private String requestStatus;
    private String plannedDeliveryDate;
    private ArrayList<PurchaseOrderDetail> purchaseOrderDetails;
    private Vendor vendor;

    public PurchaseOrder(String purchaseOrderID, String poDate, String vendorID, String shippingMethod,
                         String paymentTerms, String requestBy, String requestStatus, String plannedDeliveryDate) {
        this.purchaseOrderID = purchaseOrderID;
        this.poDate = poDate;
        this.vendorID = vendorID;
        this.shippingMethod = shippingMethod;
        this.paymentTerms = paymentTerms;
        this.requestBy = requestBy;
        this.requestStatus = requestStatus;
        this.plannedDeliveryDate = plannedDeliveryDate;
    }

    public String getPurchaseOrderID() {
        return purchaseOrderID;
    }

    public String getPoDate() {
        return poDate;
    }

    public String getVendorID() {
        return vendorID;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public String getPlannedDeliveryDate() {
        return plannedDeliveryDate;
    }
    
    public void setVendor(Vendor vendor){
        this.vendor = vendor;
    }
    
    public Vendor getVendor() {
        return vendor;
    }

    public ArrayList<PurchaseOrderDetail> getPurchaseOrderDetails() {
        return purchaseOrderDetails;
    }
    
    public void setPurchaseOrderDetails(ArrayList<PurchaseOrderDetail> poDetails) {
        this.purchaseOrderDetails = poDetails;
    }
}

