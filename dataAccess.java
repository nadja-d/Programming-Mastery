/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import javax.swing.JTextField;

public class dataAccess {

    public String getLoginDetails() {
        return "SELECT * FROM userdb WHERE Email=? AND Password=?";
    }
    
    public String getProductData(String productName) {
        return "SELECT * FROM product WHERE productName='"+productName+"'";
    }
    
    public String getProductData2(String productID) {
        return "SELECT * FROM product WHERE productID ='"+productID+"'";
    }
    
    public String updateProductionStep(String firstPS, String secondPS, String thirdPS, String fourthPS, String fifthPS, String sixthPS, String seventhPS, String eighthPS) {
            return "UPDATE productionStep " +
             "SET stepName = CASE " +
             "    WHEN stepID = 1 THEN '" + firstPS + "' " +
             "    WHEN stepID = 2 THEN '" + secondPS + "' " +
             "    WHEN stepID = 3 THEN '" + thirdPS + "' " +
             "    WHEN stepID = 4 THEN '" + fourthPS + "' " +
             "    WHEN stepID = 5 THEN '" + fifthPS + "' " +
             "    WHEN stepID = 6 THEN '" + sixthPS + "' " +
             "    WHEN stepID = 7 THEN '" + seventhPS + "' " +
             "    WHEN stepID = 8 THEN '" + eighthPS + "' " +
             "END, " +
             "productCategory = CASE " +
             "    WHEN stepName = '" + firstPS + "' THEN productCategory " +
             "    WHEN stepName = '" + secondPS + "' THEN productCategory " +
             "    WHEN stepName = '" + thirdPS + "' THEN productCategory " +
             "    WHEN stepName = '" + fourthPS + "' THEN productCategory " +
             "    WHEN stepName = '" + fifthPS + "' THEN productCategory " +
             "    WHEN stepName = '" + sixthPS + "' THEN productCategory " +
             "    WHEN stepName = '" + seventhPS + "' THEN productCategory " +
             "    WHEN stepName = '" + eighthPS + "' THEN productCategory " +
             "END, " +
             "stepType = CASE " +
             "    WHEN stepName = '" + firstPS + "' THEN stepType " +
             "    WHEN stepName = '" + secondPS + "' THEN stepType " +
             "    WHEN stepName = '" + thirdPS + "' THEN stepType " +
             "    WHEN stepName = '" + fourthPS + "' THEN stepType " +
             "    WHEN stepName = '" + fifthPS + "' THEN stepType " +
             "    WHEN stepName = '" + sixthPS + "' THEN stepType " +
             "    WHEN stepName = '" + seventhPS + "' THEN stepType " +
             "    WHEN stepName = '" + eighthPS + "' THEN stepType " +
             "END";
    }
    
    public String getPurchaseOrderData() {
        return "SELECT * from purchaseorder";
    }
    
    public String getPurchaseRequestData() {
        return "SELECT * from purchaserequest";
    }
    
    public String getOrderData() {
        return "SELECT * from orders";
    }
    
    public String getOrderDetailData() {
        return "SELECT * from orderdetail";
    }
    
    public String getVendorData(PurchaseOrder PO) {
        return "SELECT * FROM vendor WHERE vendorID = '" + PO.getVendorID() + "'";
    }
    
    public String getPurchaseOrderDetailData(PurchaseOrder PO) {
        return "SELECT * FROM purchaseorderdetails WHERE poID = '" + PO.getPurchaseOrderID() + "'";
    }
    
    public String updateProductMTSQuantities(String productName, String mtsQtyWeekdays, String mtsQtyWeekends) {
        return "UPDATE product SET mtsQtyWeekdays = '" + mtsQtyWeekdays + "', mtsQtyWeekends = '" + mtsQtyWeekends + "' WHERE productName = '" + productName + "'";
    }
    
    public String updateDeliveryQuantities(String productName, JTextField mtsWeekdaysPKBW, JTextField mtsWeekdaysPIK, JTextField mtsWeekendPKBW, JTextField mtsWeekendPIK) {
        return "UPDATE product SET pkbwDeliveryQtyWky = '" + mtsWeekdaysPKBW.getText() + "', pikDeliveryQtyWky = '" + mtsWeekdaysPIK.getText() + "', pkbwDeliveryQtyWkd = '" + mtsWeekendPKBW.getText() + "', pikDeliveryQtyWkd = '" + mtsWeekendPIK.getText() + "' WHERE productName = '" + productName + "'";
    }
    
    public String updatePIKPreparationDetails(String productName, JTextField MPWdy, JTextField RPWdy, JTextField MPWkd, JTextField RPWkd) {
        return "UPDATE product SET pikMorningPrepWky = '" + MPWdy.getText() + "', pikReBakingPointWkky = '" + RPWdy.getText() + "', pikMorningPrepWkd = '" + MPWkd.getText() + "', pikReBakingPointWkd = '" + RPWkd.getText() + "' WHERE productName = '" + productName + "'";
    }
    
    public String updatePKBWPreparationDetails(String productName, JTextField MPWdy, JTextField RPWdy, JTextField MPWkd, JTextField RPWkd) {
        return "UPDATE product SET pkbwMorningPrepWky = '" + MPWdy.getText() + "', pkbwReBakingPointWkky = '" + RPWdy.getText() + "', pkbwMorningPrepWkd = '" + MPWkd.getText() + "', pkbwReBakingPointWkd = '" + RPWkd.getText() + "' WHERE productName = '" + productName + "'";
    }
}
