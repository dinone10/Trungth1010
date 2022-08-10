/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news;

/**
 *
 * @author User
 */
public class NewsDTO {
    private String idNews;
    private String infoNews;
    private String image;
    private String dateSubmited;
    private String officeEmpID;
    private String title;

    public NewsDTO(String idNews, String infoNews, String image, String dateSubmited, String officeEmpID, String title) {
        this.idNews = idNews;
        this.infoNews = infoNews;
        this.image = image;
        this.dateSubmited = dateSubmited;
        this.officeEmpID = officeEmpID;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public NewsDTO() {
    }

    public String getIdNews() {
        return idNews;
    }

    public void setIdNew(String idNews) {
        this.idNews = idNews;
    }

    public String getInfoNews() {
        return infoNews;
    }

    public void setInfoNew(String infoNews) {
        this.infoNews = infoNews;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDateSubmited() {
        return dateSubmited;
    }

    public void setDateSubmited(String dateSubmited) {
        this.dateSubmited = dateSubmited;
    }

    public String getOfficeEmpID() {
        return officeEmpID;
    }

    public void setOfficeEmpID(String officeEmpID) {
        this.officeEmpID = officeEmpID;
    }
    
    
}
