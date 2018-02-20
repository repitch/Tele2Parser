package com.repitch.tele2parser.api;

import com.repitch.tele2parser.api.entity.NumbersResponse;
import com.repitch.tele2parser.api.entity.request.NumbersRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by repitch on 08.11.2017.
 */
public interface ApiService {

    @POST("/sim/getmorenumbers")
    Observable<NumbersResponse> getMoreNumbers(@Body NumbersRequest numbersRequest);

}
