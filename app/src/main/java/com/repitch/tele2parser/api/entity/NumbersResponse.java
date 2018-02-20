
package com.repitch.tele2parser.api.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NumbersResponse {

    @SerializedName("Lines")
    @Expose
    private List<Line> lines = null;
    @SerializedName("CanShowMore")
    @Expose
    private Boolean canShowMore;
    @SerializedName("IsRefresh")
    @Expose
    private Boolean isRefresh;

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public Boolean getCanShowMore() {
        return canShowMore;
    }

    public void setCanShowMore(Boolean canShowMore) {
        this.canShowMore = canShowMore;
    }

    public Boolean getIsRefresh() {
        return isRefresh;
    }

    public void setIsRefresh(Boolean isRefresh) {
        this.isRefresh = isRefresh;
    }

}
