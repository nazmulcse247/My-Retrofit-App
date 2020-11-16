package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitpractice.Retrofit.ApiInterface;
import com.example.retrofitpractice.Retrofit.RetrofitClient;
import com.example.retrofitpractice.adapter.ProductAdapter;
import com.example.retrofitpractice.model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);

        Call<List<Products>> call = apiInterface.getAllProducts();

        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
               List<Products> productsList = response.body();

               Toast.makeText(MainActivity.this, ""+productsList.size(), Toast.LENGTH_SHORT).show();

               setRecyclerView(productsList);
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

            }
        });
    }

    public void setRecyclerView(List<Products> productsList){
        ProductAdapter adapter = new ProductAdapter(this, productsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        
    }
}