package com.repitch.tele2parser.api.entity.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by repitch on 21.02.2018.
 */
public class NumbersRequest {

    @SerializedName("filter")
    @Expose
    private Tele2Filter filter;

    public Tele2Filter getFilter() {
        return filter;
    }

    public void setFilter(Tele2Filter filter) {
        this.filter = filter;
    }

}
