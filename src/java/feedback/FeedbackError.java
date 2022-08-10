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
public class FeedbackError {
    private String idFeedbackError;
    private String infoFeedbackError;
    private String messageError;
    private String cusIDError;

    public String getInfoFeedbackError() {
        return infoFeedbackError;
    }

    public String getIdFeedbackError() {
        return idFeedbackError;
    }

    public void setIdFeedbackError(String idFeedbackError) {
        this.idFeedbackError = idFeedbackError;
    }

    public void setInfoFeedbackError(String infoFeedbackError) {
        this.infoFeedbackError = infoFeedbackError;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public String getCusIDError() {
        return cusIDError;
    }

    public void setCusIDError(String cusIDError) {
        this.cusIDError = cusIDError;
    }

    public FeedbackError(String idFeedbackError, String infoFeedbackError, String messageError, String cusIDError) {
        this.idFeedbackError = idFeedbackError;
        this.infoFeedbackError = infoFeedbackError;
        this.messageError = messageError;
        this.cusIDError = cusIDError;
    }

    public FeedbackError() {
    }

}
