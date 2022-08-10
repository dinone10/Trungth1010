/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news;

/**
 *
 * @author Admin
 */
public class NewsError {
    private String idNewsError;
    private String infoNewsError;
    private String imageError;
    private String dateSubmitedError;
    private String officeEmpIDError; 
    private String titleError;
    private String messageError;

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public NewsError(String idNewsError, String infoNewsError, String imageError, String dateSubmitedError, String officeEmpIDError, String titleError, String messageError) {
        this.idNewsError = idNewsError;
        this.infoNewsError = infoNewsError;
        this.imageError = imageError;
        this.dateSubmitedError = dateSubmitedError;
        this.officeEmpIDError = officeEmpIDError;
        this.titleError = titleError;
        this.messageError = messageError;
    }

    public NewsError() {
        this.idNewsError = "";
        this.infoNewsError = "";
        this.imageError = "";
        this.dateSubmitedError = "";
        this.officeEmpIDError = "";
        this.titleError = "";
    }

    public NewsError(String idNewsError, String infoNewsError, String imageError, String dateSubmitedError, String officeEmpIDError, String titleError) {
        this.idNewsError = idNewsError;
        this.infoNewsError = infoNewsError;
        this.imageError = imageError;
        this.dateSubmitedError = dateSubmitedError;
        this.officeEmpIDError = officeEmpIDError;
        this.titleError = titleError;
    }

    public String getIdNewsError() {
        return idNewsError;
    }

    public void setIdNewsError(String idNewsError) {
        this.idNewsError = idNewsError;
    }

    public String getInfoNewsError() {
        return infoNewsError;
    }

    public void setInfoNewsError(String infoNewsError) {
        this.infoNewsError = infoNewsError;
    }

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    public String getDateSubmitedError() {
        return dateSubmitedError;
    }

    public void setDateSubmitedError(String dateSubmitedError) {
        this.dateSubmitedError = dateSubmitedError;
    }

    public String getOfficeEmpIDError() {
        return officeEmpIDError;
    }

    public void setOfficeEmpIDError(String officeEmpIDError) {
        this.officeEmpIDError = officeEmpIDError;
    }

    public String getTitleError() {
        return titleError;
    }

    public void setTitleError(String titleError) {
        this.titleError = titleError;
    }
    

    
}
