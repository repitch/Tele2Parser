
package com.repitch.tele2parser.api.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Left {

    @SerializedName("Collection")
    @Expose
    private List<NumberItem> numberItems = null;
    @SerializedName("Price")
    @Expose
    private Double price;
    @SerializedName("SpecialPrice")
    @Expose
    private Double specialPrice;
    @SerializedName("HasSpecialPrice")
    @Expose
    private Boolean hasSpecialPrice;
    @SerializedName("Mask")
    @Expose
    private String mask;
    @SerializedName("Digit")
    @Expose
    private Integer digit;
    @SerializedName("Position")
    @Expose
    private Integer position;

    public List<NumberItem> getNumberItems() {
        return numberItems;
    }

    public void setNumberItems(List<NumberItem> numberItems) {
        this.numberItems = numberItems;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Boolean getHasSpecialPrice() {
        return hasSpecialPrice;
    }

    public void setHasSpecialPrice(Boolean hasSpecialPrice) {
        this.hasSpecialPrice = hasSpecialPrice;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public Integer getDigit() {
        return digit;
    }

    public void setDigit(Integer digit) {
        this.digit = digit;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

}
