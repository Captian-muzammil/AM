package com.muzammil.teamtnt.am;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AMService {

    @GET("total_order")
    Call<TotalOrderResponse> totalOrder();

    @GET("order")
    Call<OrderResponse> orderList();

    @GET("total_outlet")
    Call<TotalOutletResponse> totalOutlet();

}
