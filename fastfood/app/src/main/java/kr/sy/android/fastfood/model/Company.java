package kr.sy.android.fastfood.model;

import com.google.gson.annotations.SerializedName;

public class Company {


    public Company(int company_index, String company_name, String description, String image, int category_index) {
        this.company_index = company_index;
        this.company_name = company_name;
        this.description = description;
        this.image = image;
        this.category_index = category_index;
    }

    @SerializedName("company_index")
    private int company_index;

    @SerializedName("company_name")
    private String company_name;

    @SerializedName("description")
    private String description;

    @SerializedName("image")
    private String image;

    @SerializedName("category_index")
    private int category_index;
    /*
    //@SerializedName("detail_image")
    private String detail_image;
    //@SerializedName("begin_date")
    private Date begin_date;
    //@SerializedName("end_date")
    private Date end_date;
    //@SerializedName("event_title")
    private String event_title;

     */

    public int getCompany_index() {
        return company_index;
    }

    public void setCompany_index(int company_index) {
        this.company_index = company_index;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategory_index() {
        return category_index;
    }

    public void setCategory_index(int category_index) {
        this.category_index = category_index;
    }
    /*
    public String getDetail_image() {
        return detail_image;
    }

    public void setDetail_image(String detail_image) {
        this.detail_image = detail_image;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

     */

    @Override
    public String toString() {
        return "Company{" +
                "company_index=" + company_index +
                ", company_name='" + company_name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", category_index=" + category_index +
                '}';
    }
}
