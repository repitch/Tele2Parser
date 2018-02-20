package com.repitch.tele2parser.api.entity.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by repitch on 21.02.2018.
 */
public class Tele2Filter {
    @SerializedName("Categories")
    @Expose
    private List<String> categories = null;
    @SerializedName("Query")
    @Expose
    private String query;
    @SerializedName("Packages")
    @Expose
    private List<Long> packages = null;
    @SerializedName("Types")
    @Expose
    private List<String> types = null;
    @SerializedName("PriceFrom")
    @Expose
    private long priceFrom;
    @SerializedName("PriceTo")
    @Expose
    private long priceTo;
    @SerializedName("ShowAction")
    @Expose
    private boolean showAction;
    @SerializedName("Page")
    @Expose
    private int page;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Long> getPackages() {
        return packages;
    }

    public void setPackages(List<Long> packages) {
        this.packages = packages;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public long getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(long priceFrom) {
        this.priceFrom = priceFrom;
    }

    public long getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(long priceTo) {
        this.priceTo = priceTo;
    }

    public boolean isShowAction() {
        return showAction;
    }

    public void setShowAction(boolean showAction) {
        this.showAction = showAction;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
