/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author User
 */
public class Vendor {
    private String vendorID;
    private String vendorName;
    private String vendorAddress;
    private String vendorPhoneNumber;
    private String contactPersonName;
    private String contactPersonEmail;
    
    public Vendor(String vID, String vName, String vAddress, String vPhoneNumber, String CPName) {
        this.vendorID = vID;
        this.vendorName = vName;
        this.vendorAddress = vAddress;
        this.vendorPhoneNumber = vPhoneNumber;
        this.contactPersonName = CPName;
    }
    
    public String getVendorID() {
        return vendorID;
    }
    
    
    public String getVendorName() {
        return vendorName;
    }
    
    public String getVendorAddress() {
        return vendorAddress;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }
}
