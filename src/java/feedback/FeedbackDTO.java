/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback;

/**
 *
 * @author Admin
 */
public class FeedbackDTO {

    private String cusID;
    private String infoFeedback;
    private String rate;
    private String idFeedback;

    public FeedbackDTO(String cusID, String infoFeedback) {
        this.cusID = cusID;
        this.infoFeedback = infoFeedback;
       
    }
    public FeedbackDTO(String cusID, String infoFeedback, String rate) {
        this.cusID = cusID;
        this.infoFeedback = infoFeedback;
        this.rate = rate;
    }

    public FeedbackDTO(String idFeedback, String cusID, String infoFeedback, String rate) {
        this.cusID = cusID;
        this.infoFeedback = infoFeedback;
        this.rate = rate;
        this.idFeedback = idFeedback;
    }

    public String getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(String idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getInfoFeedback() {
        return infoFeedback;
    }

    public void setInfoFeedback(String infoFeedback) {
        this.infoFeedback = infoFeedback;
    }

    public FeedbackDTO() {
    }
}
