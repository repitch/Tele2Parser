
package com.repitch.tele2parser.api.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NumberItem {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Number")
    @Expose
    private String number;
    @SerializedName("FullNumber")
    @Expose
    private long fullNumber;
    @SerializedName("CategoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("CategoryName")
    @Expose
    private String categoryName;
    @SerializedName("TypeId")
    @Expose
    private Integer typeId;
    @SerializedName("TypeName")
    @Expose
    private String typeName;
    @SerializedName("Price")
    @Expose
    private Double price;
    @SerializedName("SpecialPrice")
    @Expose
    private Double specialPrice;
    @SerializedName("BasicPrice")
    @Expose
    private Double basicPrice;
    @SerializedName("HasSpecialPrice")
    @Expose
    private Boolean hasSpecialPrice;
    @SerializedName("IsAuction")
    @Expose
    private Boolean isAuction;
    @SerializedName("AuctionUrl")
    @Expose
    private Object auctionUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber(Integer fullNumber) {
        this.fullNumber = fullNumber;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public Double getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(Double basicPrice) {
        this.basicPrice = basicPrice;
    }

    public Boolean getHasSpecialPrice() {
        return hasSpecialPrice;
    }

    public void setHasSpecialPrice(Boolean hasSpecialPrice) {
        this.hasSpecialPrice = hasSpecialPrice;
    }

    public Boolean getIsAuction() {
        return isAuction;
    }

    public void setIsAuction(Boolean isAuction) {
        this.isAuction = isAuction;
    }

    public Object getAuctionUrl() {
        return auctionUrl;
    }

    public void setAuctionUrl(Object auctionUrl) {
        this.auctionUrl = auctionUrl;
    }

}
