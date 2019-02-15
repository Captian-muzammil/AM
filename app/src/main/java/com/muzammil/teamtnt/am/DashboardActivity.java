package com.muzammil.teamtnt.am;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardActivity extends AppCompatActivity{

    private ConnectionDetector connectionDetector;
    private TextView mTextViewValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        connectionDetector =new ConnectionDetector(this);
        if(connectionDetector.isConnectingToInternet()) {
            findViewById(R.id.no_internet_cv).setVisibility(View.GONE);
            findViewById(R.id.dashboard_cv).setVisibility(View.VISIBLE);
        }else{
            findViewById(R.id.dashboard_cv).setVisibility(View.GONE);
            findViewById(R.id.no_internet_cv).setVisibility(View.VISIBLE);
        }
        mTextViewValue = findViewById(R.id.textViewValue);


            getDashboardData();


    }

    private void getDashboardData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.101:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AMService service = retrofit.create(AMService.class);

        Call<TotalOrderResponse> totalOrder = service.totalOrder();

        totalOrder.enqueue(new Callback<TotalOrderResponse>() {
            @Override
            public void onResponse(Call<TotalOrderResponse> call, Response<TotalOrderResponse> response) {


                    mTextViewValue.setText( response.body() != null ? response.body().data+ "" : "0");

            }

            @Override
            public void onFailure(Call<TotalOrderResponse> call, Throwable t) {

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.date_icon:
                showDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void showDialog() {
        DialogFragment dialog = new DateRangeDialogFragment();
        dialog.show(getSupportFragmentManager(), "DateRangeDialogFragment");
        }
    }