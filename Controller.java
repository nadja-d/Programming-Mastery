/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Controller {
    private Connection connection; private PreparedStatement preparedStatement;
    private ResultSet resultSet; private dataAccess DA; private Statement statement;
    private ResultSet resultSet2; private Statement statement2;
    
    public Controller() {
        DA = new dataAccess();
        this.connection = databaseConnector.getConnection();
    }
    
    public User verifyLogin(String username, String password) {
        try {
                preparedStatement = connection.prepareStatement(DA.getLoginDetails());

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String userID = resultSet.getString("userID");
                    String email = resultSet.getString("Email");
                    String psw = resultSet.getString("Password");
                    String name = resultSet.getString("Name");
                    String position = resultSet.getString("Position");
                    User HOO = new User(userID, email, psw, name, position);
                    return HOO;
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
            return null;
    }
    
    public void viewOrderDetailTable(JTable table, Order order) {
        String[] columnName = {"Product", "Quantity", "Price"};
        DefaultTableModel tableModel = new DefaultTableModel(columnName, 0);   
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(DA.getProductData2(order.getOrderDetail().toString()));
            
            while (resultSet.next()) {
                String productName = resultSet.getString("productName");
                Double productPrice = resultSet.getDouble("productPrice");
                
                Product product = new Product("ID", productName, productPrice);
                Object[] rowData = {"60", productName, productPrice};
                tableModel.addRow(rowData);
            }

            table.setModel(tableModel);

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e);
        }
    }
    
    public void viewPOTable(JTable table) {
            String[] columnName = {"PO ID", "Vendor", "Total", "Deadline", "Status"};
            DefaultTableModel tableModel = new DefaultTableModel(columnName, 0);      
            
            try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(DA.getPurchaseOrderData());

            while (resultSet.next()) {
                String purchaseOrderID = resultSet.getString("purchaseOrderID");
                String poDate = resultSet.getString("PODate");
                String vendorID = resultSet.getString("vendorID");
                String shippingMethod = resultSet.getString("shippingMethod");
                String paymentTerms = resultSet.getString("paymentTerms");
                String requestBy = resultSet.getString("requestBy");
                String requestStatus = resultSet.getString("requestStatus");
                String plannedDeliveryDate = resultSet.getString("plannedDeliveryDate");

                PurchaseOrder PO = new PurchaseOrder(purchaseOrderID, poDate, vendorID, shippingMethod,
                        paymentTerms, requestBy, requestStatus, plannedDeliveryDate);
                ArrayList<PurchaseOrderDetail> PODList = new ArrayList<>();

                try {
                    Statement innerStatement = connection.createStatement();
                    ResultSet innerResultSet = innerStatement.executeQuery(DA.getPurchaseOrderDetailData(PO));

                    while (innerResultSet.next()) {
                        String poDetailID = innerResultSet.getString("poDetailID");
                        String materialID = innerResultSet.getString("materialID");
                        int quantity = innerResultSet.getInt("quantity");

                        PurchaseOrderDetail POD = new PurchaseOrderDetail(poDetailID, PO.getPurchaseOrderID(), materialID, quantity);
                        PODList.add(POD);
                        PO.setPurchaseOrderDetails(PODList);
                    }

                    innerResultSet.close();
                    innerStatement.close();
                } catch (SQLException e) {
                    System.out.println("Error executing inner SQL query: " + e);
                }

                try {
                    Statement vendorStatement = connection.createStatement();
                    ResultSet vendorResultSet = vendorStatement.executeQuery(DA.getVendorData(PO));

                    if (vendorResultSet.next()) {
                        String vID = vendorResultSet.getString("vendorID");
                        String vName = vendorResultSet.getString("vendorName");
                        String vAddress = vendorResultSet.getString("vendorAddress");
                        String vPhoneNumber = vendorResultSet.getString("vendorPhone");
                        String CPName = vendorResultSet.getString("vendorContactPerson");

                        Vendor vendor = new Vendor(vID, vName, vAddress, vPhoneNumber, CPName);
                        PO.setVendor(vendor);
                    }

                    vendorResultSet.close();
                    vendorStatement.close();
                } catch (SQLException e) {
                    System.out.println("Error executing vendor SQL query: " + e);
                }

                Object[] rowData = {PO.getPurchaseOrderID(), PO.getVendor().getVendorName(), getTotalQuantity(PODList), PO.getPoDate(), PO.getRequestStatus()};
                tableModel.addRow(rowData);
            }

            table.setModel(tableModel);

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error executing outer SQL query: " + e);
        }
    }

private int getTotalQuantity(ArrayList<PurchaseOrderDetail> PODList) {
    int totalQuantity = 0;
    for (PurchaseOrderDetail POD : PODList) {
        totalQuantity += POD.getQuantity();
    }
    return totalQuantity;
}

    
    public void viewPRTable(JTable table) {

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(DA.getPurchaseRequestData());
    
            String[] columnName = {"PR ID", "Req. By", "Deadline", "Status"};
            DefaultTableModel tableModel = new DefaultTableModel(columnName, 0);

            while (resultSet.next()) {
                String prID = resultSet.getString("prID");
                String requestedBy = resultSet.getString("requestedBy");
                String userID = resultSet.getString("userID");
                String reason = resultSet.getString("reason");
                String requestDate = resultSet.getString("requestDate");
                String deadline = resultSet.getString("deadline");
                String requestStatus = resultSet.getString("requestStatus");
                
                PurchaseRequest PR = new PurchaseRequest(prID, requestedBy, requestDate, deadline, requestStatus);
                Object[] rowData = {PR.getPRID(), PR.getRequestedBy(), PR.getDeadlineDate(), PR.getStatus()};
                tableModel.addRow(rowData);
            }

            table.setModel(tableModel);

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e);
        }
    }
    
    public void viewOrderHistoryTable(JTable table) {
            String[] columnName = {"ID", "Date", "Category", "Total Amount", "Outlet"};
            DefaultTableModel tableModel = new DefaultTableModel(columnName, 0);
            
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(DA.getOrderData());

            while (resultSet.next()) {
                String orderID = resultSet.getString("OrderID");
                Date orderDate = resultSet.getDate("OrderDateTime");
                String category = resultSet.getString("OrderCategory");
                String status = resultSet.getString("OrderStatus");
                String outlet = resultSet.getString("Outlet");
                
                Order order = new Order(orderID, orderDate, category, status, outlet);
                ArrayList<OrderDetail> orderDetailsArrayList = new ArrayList<>();

                try {
                    Statement innerStatement = connection.createStatement();
                    ResultSet innerResultSet = innerStatement.executeQuery(DA.getOrderDetailData() + " WHERE OrderID = '" + order.getOrderID() + "'");

                    while (innerResultSet.next()) {
                        String orderDetailID = innerResultSet.getString("orderDetailID");
                        String productID = innerResultSet.getString("productID");
                        int itemQuantity = innerResultSet.getInt("itemQuantity");

                        OrderDetail orderDetail = new OrderDetail(orderDetailID, order.getOrderID(), productID, itemQuantity);
                        orderDetailsArrayList.add(orderDetail);
                        order.setOrderDetail(orderDetailsArrayList);
                    }

                    innerResultSet.close();
                    innerStatement.close();
                } catch (SQLException e) {
                    System.out.println("Error executing inner SQL query: " + e);
                }
                
                Object[] rowData = {order.getOrderID(), order.getOrderDateTime(), order.getOrderCategory(), "50", order.getOutlet()};
                tableModel.addRow(rowData);
            }
            table.setModel(tableModel);

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e);
        }
    }
    
    public void updateProductionSequence(JComboBox CB1, JComboBox CB2, JComboBox CB3, JComboBox CB4, JComboBox CB5, JComboBox CB6, JComboBox CB7, JComboBox CB8) {
        String firstProductionSequence = (String)CB1.getSelectedItem();
        String secondProductionSequence = (String)CB2.getSelectedItem();
        String thirdProductionSequence = (String)CB3.getSelectedItem();
        String fourthProductionSequence = (String)CB4.getSelectedItem();
        String fifthProductionSequence = (String)CB5.getSelectedItem();
        String sixthProductionSequence = (String)CB6.getSelectedItem();
        String seventhProductionSequence = (String)CB7.getSelectedItem();
        String eighthProductionSequence = (String)CB8.getSelectedItem();
        
        try {
            statement = databaseConnector.getConnection().createStatement();
            statement.executeUpdate(DA.updateProductionStep(firstProductionSequence, secondProductionSequence, thirdProductionSequence, fourthProductionSequence, fifthProductionSequence, sixthProductionSequence, seventhProductionSequence, eighthProductionSequence));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
   
    public static String currencyFormat(double number) {
        return "Rp. " + new DecimalFormat("#,###.00").format(number);
    }
    
    public void setMTSQuantities(Cookie cookie, JTextField WeekdaysTextField, JTextField WeekendTextField) {
        WeekdaysTextField.setText(Integer.toString(cookie.getMtsQtyWeekday()));
        WeekendTextField.setText(Integer.toString(cookie.getMtsQtyWeekends()));
    }
    
    public void setMTSQuantities(Cookie cookie, JLabel WeekdaysTextField, JLabel WeekendTextField) {
        WeekdaysTextField.setText(Integer.toString(cookie.getMtsQtyWeekday()));
        WeekendTextField.setText(Integer.toString(cookie.getMtsQtyWeekends()));
    }
    
    public void setPreparationDetails(Cookie cookie, JComboBox CB, JTextField MPWdy, JTextField RPWdy, JTextField MPWkd, JTextField RPWkd) {
        String outletName = (String)CB.getSelectedItem();
        
        if(outletName.equals("Pakubuwono")) {
            MPWdy.setText(Integer.toString(cookie.getPkbwMorningPrepWky()));
            RPWdy.setText(Integer.toString(cookie.getPkbwReBakingPointWky()));
            MPWkd.setText(Integer.toString(cookie.getPkbwReBakingPointWkd()));
            RPWkd.setText(Integer.toString(cookie.getPkbwReBakingPointWkd()));
        }
        else if(outletName.equals("Pantai Indah Kapuk")) {
            MPWdy.setText(Integer.toString(cookie.getPikMorningPrepWky()));
            RPWdy.setText(Integer.toString(cookie.getPikReBakingPointWky()));
            MPWkd.setText(Integer.toString(cookie.getPikReBakingPointWkd()));
            RPWkd.setText(Integer.toString(cookie.getPikReBakingPointWkd()));
        }
    }
    
    public void setDeliveryQuantities(Cookie cookie, JLabel MTSWeekdays, JTextField MTSWeekdaysPKBW, JTextField MTSWeekdaysPIK, JLabel MTSWeekend, JTextField MTSWeekendPKBW, JTextField MTSWeekendPIK) {
        MTSWeekdays.setText(Integer.toString(cookie.getMtsQtyWeekday()));
        MTSWeekend.setText(Integer.toString(cookie.getMtsQtyWeekends()));
        MTSWeekdaysPKBW.setText(Integer.toString(cookie.getPkbwDeliveryQtyWeekday()));
        MTSWeekdaysPIK.setText(Integer.toString(cookie.getPikDeliveryQtyWeekday()));
        MTSWeekendPKBW.setText(Integer.toString(cookie.getPkbwDeliveryQtyWeekend()));
    }
    
    public void updateMTSQuantities(Cookie cookie, String mtsQtyWeekdays, String mtsQtyWeekends) {
        try {
            statement = databaseConnector.getConnection().createStatement();
            statement.executeUpdate(DA.updateProductMTSQuantities(cookie.getProductName(), mtsQtyWeekdays, mtsQtyWeekends));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void updateDeliveryQuantities(Cookie cookie, JTextField mtsWeekdaysPKBW, JTextField mtsWeekdaysPIK, JTextField mtsWeekendPKBW, JTextField mtsWeekendPIK) {
            try {
                statement = databaseConnector.getConnection().createStatement();
                statement.executeUpdate(DA.updateDeliveryQuantities(cookie.getProductName(), mtsWeekdaysPKBW, mtsWeekdaysPIK, mtsWeekendPKBW, mtsWeekendPIK));
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    
    public void updatePreparationDetails(Cookie cookie, JComboBox CB, JTextField MPWdy, JTextField RPWdy, JTextField MPWkd, JTextField RPWkd) {
            try {
                statement = databaseConnector.getConnection().createStatement();
                String outletName = (String)CB.getSelectedItem();

                if(outletName.equals("Pakubuwono")) {
                    statement.executeUpdate(DA.updatePKBWPreparationDetails(cookie.getProductName(), MPWdy, RPWdy, MPWkd, RPWkd));
                }
                else if(outletName.equals("PIK")) {
                    statement.executeUpdate(DA.updatePIKPreparationDetails(cookie.getProductName(), MPWdy, RPWdy, MPWkd, RPWkd));
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
   
    public void navigateToNextFrame (JFrame currentFrame, JFrame nextFrame) {
        currentFrame.setVisible(false);
        nextFrame.setVisible(true);
    }
    
    public PurchaseOrderDetail getPurchaseOrderDetail(PurchaseOrder PO) {
        ArrayList<PurchaseOrderDetail> PODList = new ArrayList<>();

        try {
            Statement innerStatement = connection.createStatement();
            ResultSet innerResultSet = innerStatement.executeQuery(DA.getPurchaseOrderDetailData(PO));

            while (innerResultSet.next()) {
                String poDetailID = innerResultSet.getString("poDetailID");
                String materialID = innerResultSet.getString("materialID");
                int quantity = innerResultSet.getInt("quantity");

                PurchaseOrderDetail POD = new PurchaseOrderDetail(poDetailID, PO.getPurchaseOrderID(), materialID, quantity);
                PODList.add(POD);
                PO.setPurchaseOrderDetails(PODList);
                return POD;
            }

            innerResultSet.close();
            innerStatement.close();
        } catch (SQLException e) {
            System.out.println("Error executing inner SQL query: " + e);
        }
        return null;
    }
    
    public void getVendor(PurchaseOrder PO) {
        try {
            Statement vendorStatement = connection.createStatement();
            ResultSet vendorResultSet = vendorStatement.executeQuery(DA.getVendorData(PO));

            if (vendorResultSet.next()) {
                String vID = vendorResultSet.getString("vendorID");
                String vName = vendorResultSet.getString("vendorName");
                String vAddress = vendorResultSet.getString("vendorAddress");
                String vPhoneNumber = vendorResultSet.getString("vendorPhone");
                String CPName = vendorResultSet.getString("vendorContactPerson");

                Vendor vendor = new Vendor(vID, vName, vAddress, vPhoneNumber, CPName);
                PO.setVendor(vendor);
            }

            vendorResultSet.close();
            vendorStatement.close();
        } catch (SQLException e) {
            System.out.println("Error executing vendor SQL query: " + e);
        }
    }
    
    public PurchaseOrder getPurchaseOrder(String POID) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(DA.getPurchaseOrderData() + " WHERE purchaseOrderID = '" + POID + "'");

            while (resultSet.next()) {
                String purchaseOrderID = resultSet.getString("purchaseOrderID");
                String poDate = resultSet.getString("PODate");
                String vendorID = resultSet.getString("vendorID");
                String shippingMethod = resultSet.getString("shippingMethod");
                String paymentTerms = resultSet.getString("paymentTerms");
                String requestBy = resultSet.getString("requestBy");
                String requestStatus = resultSet.getString("requestStatus");
                String plannedDeliveryDate = resultSet.getString("plannedDeliveryDate");
                PurchaseOrder PO = new PurchaseOrder(purchaseOrderID, poDate, vendorID, shippingMethod,
                        paymentTerms, requestBy, requestStatus, plannedDeliveryDate);
                return PO;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }
    
    public Order getOrder(String orderID) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(DA.getOrderData()+ " WHERE OrderID = '" + orderID + "'");

            while (resultSet.next()) {
                Date orderDate = resultSet.getDate("OrderDateTime");
                String category = resultSet.getString("OrderCategory");
                String status = resultSet.getString("OrderStatus");
                String outlet = resultSet.getString("Outlet");
                
                Order order = new Order(orderID, orderDate, category, status, outlet);
                return order;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }
    
    public void getOrderDetail(Order order) {
    ArrayList<OrderDetail> orderDetailsArrayList = new ArrayList<>();
        
        System.out.println("ORDER ID CUY: " + order.getOrderID());
        try {
            Statement innerStatement = connection.createStatement();
            ResultSet innerResultSet = innerStatement.executeQuery(DA.getOrderDetailData() + " WHERE OrderID = '" + order.getOrderID() + "'");

            while (innerResultSet.next()) {
                String orderDetailID = innerResultSet.getString("orderDetailID");
                String productID = innerResultSet.getString("productID");
                int itemQuantity = innerResultSet.getInt("itemQuantity");

                OrderDetail orderDetail = new OrderDetail(orderDetailID, order.getOrderID(), productID, itemQuantity);
                orderDetailsArrayList.add(orderDetail);
                order.setOrderDetail(orderDetailsArrayList);
            }

            innerResultSet.close();
            innerStatement.close();
        } catch (SQLException e) {
            System.out.println("Error executing inner SQL query: " + e);
        }
    }

    public Cookie getCookieData(String cookieName) {
    try {
            preparedStatement = connection.prepareStatement(DA.getProductData(cookieName));

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String pID = resultSet.getString("productID");
                String pName = resultSet.getString("productName");
                String pCategory = resultSet.getString("productCategory");
                double pPrice = resultSet.getDouble("productPrice");
                String mID = "materialID";
                double materialC = 0;
                int pStock = resultSet.getInt("productStock");
                int mtsQtyWeekdays = resultSet.getInt("mtsQtyWeekdays");
                int mtsQuantityWeekends = resultSet.getInt("mtsQtyWeekends");
                
                int pkbwDeliveryQtyWky = resultSet.getInt("pkbwDeliveryQtyWky");
                int pikDeliveryQtyWky = resultSet.getInt("pikDeliveryQtyWky");
                int pkbwDeliveryQtyWkd = resultSet.getInt("pkbwDeliveryQtyWkd");
                int pikDeliveryQtyWkd = resultSet.getInt("pikDeliveryQtyWkd");
                
                int cookieBakedStock = resultSet.getInt("cookieBakedStock");
                int cookieDoughStock = resultSet.getInt("cookieDoughStock");
                int pikMorningPrepWky = resultSet.getInt("pikMorningPrepWky");
                int pikReBakingPointWky = resultSet.getInt("pikReBakingPointWkky");
                int pikMorningPrepWkd = resultSet.getInt("pikMorningPrepWkd");
                int pikReBakingPointWkd = resultSet.getInt("pikReBakingPointWkd");
                int pkbwMorningPrepWky = resultSet.getInt("pkbwMorningPrepWky");
                int pkbwReBakingPointWky = resultSet.getInt("pkbwReBakingPointWky");
                int pkbwMorningPrepWkd = resultSet.getInt("pkbwMorningPrepWkd");
                int pkbwReBakingPointWkd = resultSet.getInt("pkbwReBakingPointWkd");
                
//                Product product = new Product(pID, pName, pCategory, pPrice, mID, materialC, pStock, mtsQtyWeekdays, mtsQuantityWeekends, pikDeliveryqtyWky, pikDeliveryqtyWkd);
                Cookie cookieClass = new Cookie(pID, pName, pCategory, pPrice,mID, materialC, pStock, mtsQtyWeekdays, mtsQuantityWeekends, pkbwDeliveryQtyWky, pikDeliveryQtyWky, pkbwDeliveryQtyWkd, pikDeliveryQtyWkd, cookieBakedStock, cookieDoughStock, pikMorningPrepWky, pikReBakingPointWky, pikMorningPrepWkd, pikReBakingPointWkd, pkbwMorningPrepWky, pkbwReBakingPointWky, pkbwMorningPrepWkd, pkbwReBakingPointWkd);
                return cookieClass;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }
}
