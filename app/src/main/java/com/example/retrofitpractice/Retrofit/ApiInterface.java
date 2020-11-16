package com.example.retrofitpractice.Retrofit;

import com.example.retrofitpractice.model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("photos")
    Call<List<Products>> getAllProducts();
}
