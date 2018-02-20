package com.repitch.tele2parser.api.entity.request;

import java.util.Arrays;

/**
 * Created by repitch on 21.02.2018.
 */
public class NumbersRequestFactory {

    public NumbersRequest getRequest(int page, String query) {
        NumbersRequest request = new NumbersRequest();
        Tele2Filter filter = new Tele2Filter();

        filter.setCategories(Arrays.asList("federal"));
        filter.setPackages(Arrays.asList(1L));
        filter.setPage(page);
        filter.setPriceFrom(0L);
        filter.setPriceTo(75000L);
        filter.setQuery(query);
        filter.setShowAction(false);
        filter.setTypes(Arrays.asList("gold", "simple", "platina", "silver"));

        request.setFilter(filter);
        return request;
    }

    /*
    * {"filter":{"Categories":["federal"],"Query":"","Packages":[1],"Types":["gold","simple","platina","silver"],"PriceFrom":0,"PriceTo":75000,"ShowAction":false,"Page":5}}
    * */

}
