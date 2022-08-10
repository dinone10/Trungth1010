/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnover;

/**
 *
 * @author Admin
 */
public class TurnoverError {
     private String detailIDError;
    private double priceError;
    private String timeStartError;
    private String timeEndError;
    private String orderIDError;
    private String slotIDError;

    public TurnoverError(String detailIDError, double priceError, String timeStartError, String timeEndError, String orderIDError, String slotIDError) {
        this.detailIDError = detailIDError;
        this.priceError = priceError;
        this.timeStartError = timeStartError;
        this.timeEndError = timeEndError;
        this.orderIDError = orderIDError;
        this.slotIDError = slotIDError;
    }

    public TurnoverError() {
    }

    public String getDetailIDError() {
        return detailIDError;
    }

    public void setDetailIDError(String detailIDError) {
        this.detailIDError = detailIDError;
    }

    public double getPriceError() {
        return priceError;
    }

    public void setPriceError(double priceError) {
        this.priceError = priceError;
    }

    public String getTimeStartError() {
        return timeStartError;
    }

    public void setTimeStartError(String timeStartError) {
        this.timeStartError = timeStartError;
    }

    public String getTimeEndError() {
        return timeEndError;
    }

    public void setTimeEndError(String timeEndError) {
        this.timeEndError = timeEndError;
    }

    public String getOrderIDError() {
        return orderIDError;
    }

    public void setOrderIDError(String orderIDError) {
        this.orderIDError = orderIDError;
    }

    public String getSlotIDError() {
        return slotIDError;
    }

    public void setSlotIDError(String slotIDError) {
        this.slotIDError = slotIDError;
    }

}
