/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author User
 */
public class Cookie extends Product {

    private int cookieBakedStock;
    private int cookieDoughStock;
    private int pikMorningPrepWky;
    private int pikReBakingPointWky;
    private int pikMorningPrepWkd; 
    private int pikReBakingPointWkd;
    private int pkbwMorningPrepWky;
    private int pkbwReBakingPointWky;  
    private int pkbwMorningPrepWkd;
    private int pkbwReBakingPointWkd;
    
    public Cookie(String pID, String pName, String pCategory, double pPrice, String mID, double materialC, int pStock,
                  int mtsQtyWeekdays, int mtsQtyWeekends, int pkbwDeliveryQtyWky,
                  int pikDeliveryQtyWky, int pkbwDeliveryQtyWkd, int pikDeliveryQtyWkd,
                  int cookieBakedStock, int cookieDoughStock, int pikMorningPrepWky, int pikReBakingPointWky,
                  int pikMorningPrepWkd, int pikReBakingPointWkd, int pkbwMorningPrepWky, int pkbwReBakingPointWky,
                  int pkbwMorningPrepWkd, int pkbwReBakingPointWkd) {
        super(pID, pName, pCategory, pPrice, mID, materialC, pStock, mtsQtyWeekdays, mtsQtyWeekends, pkbwDeliveryQtyWky, pikDeliveryQtyWky, pkbwDeliveryQtyWkd, pikDeliveryQtyWkd);
        this.cookieBakedStock = cookieBakedStock;
        this.cookieDoughStock = cookieDoughStock;
        this.pikMorningPrepWky = pikMorningPrepWky;
        this.pikReBakingPointWky = pikReBakingPointWky;
        this.pikMorningPrepWkd = pikMorningPrepWkd;
        this.pikReBakingPointWkd = pikReBakingPointWkd;
        this.pkbwMorningPrepWky = pkbwMorningPrepWky;
        this.pkbwReBakingPointWky = pkbwReBakingPointWky;
        this.pkbwMorningPrepWkd = pkbwMorningPrepWkd;
        this.pkbwReBakingPointWkd = pkbwReBakingPointWkd;
    }
    
    public int getCookieBakedStock() {
        return cookieBakedStock;
    }

    public int getCookieDoughStock() {
        return cookieDoughStock;
    }

    public int getPikMorningPrepWky() {
        return pikMorningPrepWky;
    }

    public int getPikReBakingPointWky() {
        return pikReBakingPointWky;
    }

    public int getPikMorningPrepWkd() {
        return pikMorningPrepWkd;
    }

    public int getPikReBakingPointWkd() {
        return pikReBakingPointWkd;
    }

    public int getPkbwMorningPrepWky() {
        return pkbwMorningPrepWky;
    }

    public int getPkbwReBakingPointWky() {
        return pkbwReBakingPointWky;
    }

    public int getPkbwMorningPrepWkd() {
        return pkbwMorningPrepWkd;
    }

    public int getPkbwReBakingPointWkd() {
        return pkbwReBakingPointWkd;
    }
    
    @Override
    public String getProductName() {
        return super.getProductName();
    }
}
