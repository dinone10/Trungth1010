/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

/**
 *
 * @author Admin
 */
public class SpaceError {

    private String slotIDError;
    private String priceError;
    private String floorIDError;
    private String statusError;

    public SpaceError(String slotIDError, String priceError, String floorIDError, String statusError) {
        this.slotIDError = slotIDError;
        this.priceError = priceError;
        this.floorIDError = floorIDError;
        this.statusError = statusError;
    }

    public SpaceError() {
        this.slotIDError = "";
        this.priceError = "";
        this.floorIDError = "";
        this.statusError = "";
    }

    public String getSlotIDError() {
        return slotIDError;
    }

    public void setSlotIDError(String slotIDError) {
        this.slotIDError = slotIDError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getFloorIDError() {
        return floorIDError;
    }

    public void setFloorIDError(String floorIDError) {
        this.floorIDError = floorIDError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

}
