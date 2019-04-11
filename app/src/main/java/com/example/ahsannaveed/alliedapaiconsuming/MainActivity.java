package com.example.ahsannaveed.alliedapaiconsuming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ApiAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //retrofit instance
        final Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiConsuming.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //creating handler for retrofit
        ApiConsuming service=retrofit.create(ApiConsuming.class);
        Call<List<ApiModel>> call=service.getData();
        call.enqueue(new Callback<List<ApiModel>>() {
            @Override
            public void onResponse(Call<List<ApiModel>> call, Response<List<ApiModel>> response) {
                loadDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<ApiModel>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Unable to load the data,find the problem by debugging the program", Toast.LENGTH_SHORT).show();

            }
        });


    }

    //
    private void loadDataList(List<ApiModel> dataList) {
        recyclerView=findViewById(R.id.recycler);
        adapter=new ApiAdapter(dataList);
        //setting layout manager on adapter
        recyclerView.setLayoutManager(new GridLayoutManager(this,4 ));
        recyclerView.setAdapter(adapter);

    }
}
