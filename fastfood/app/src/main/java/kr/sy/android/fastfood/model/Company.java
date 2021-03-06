package kr.sy.android.fastfood.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Company {

    public Company(int company_index, String company_name, String description, String image, int category_index, String detail_image, Date begin, Date end, String event_title, int label_index) {
        this.company_index = company_index;
        this.company_name = company_name;
        this.description = description;
        this.image = image;
        this.category_index = category_index;
        this.detail_image = detail_image;
        this.begin = begin;
        this.end = end;
        this.event_title = event_title;
        this.label_index = label_index;
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

    @SerializedName("detail_image")
    private String detail_image;

    @SerializedName("begin")
    private Date begin;

    @SerializedName("end")
    private Date end;

    @SerializedName("event_title")
    private String event_title;

    @SerializedName("label_index")
    private int label_index;

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

    public String getDetail_image() {
        return detail_image;
    }

    public void setDetail_image(String detail_image) {
        this.detail_image = detail_image;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public int getLabel_index() {
        return label_index;
    }

    public void setLabel_index(int label_index) {
        this.label_index = label_index;
    }

    @Override
    public String toString() {
        return "Company{" +
                "company_index=" + company_index +
                ", company_name='" + company_name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", category_index=" + category_index +
                ", detail_image='" + detail_image + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                ", event_title='" + event_title + '\'' +
                ", label_index=" + label_index +
                '}';
    }
}
