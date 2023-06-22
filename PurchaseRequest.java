/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author User
 */
public class PurchaseRequest {

    private String PRID;
    private String requestedBy;
    private String requestDate;
    private String deadlineDate;
    private String status;
    
    public PurchaseRequest(String PRID, String reqBy, String reqDate, String deadlineDate, String status) {
        this.PRID = PRID;
        this.requestedBy = reqBy;
        this.requestDate = reqDate;
        this.deadlineDate = deadlineDate;
        this.status = status;
    }
    
    public String getPRID() {
        return PRID;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public String getStatus() {
        return status;
    }
}
