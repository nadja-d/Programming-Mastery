/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.Date;

/**
 *
 * @author User
 */
public class ProductionStep {
   String stepID;
   Date productionDate;
   String stepName;
   String stepType;
   String productCategory;
   String stepStatus;
   
    public ProductionStep(String stepID, Date productionDate, String stepName, String stepType, String productCategory, String stepStatus) {
        this.stepID = stepID;
        this.productionDate = productionDate;
        this.stepName = stepName;
        this.stepType = stepType;
        this.productCategory = productCategory;
        this.stepStatus = stepStatus;
    }
}
