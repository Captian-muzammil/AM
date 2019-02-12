package com.muzammil.teamtnt.am;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class DashboardActivity extends AppCompatActivity{


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ConnectionDetector connectionDetector;

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




        mRecyclerView = (RecyclerView) findViewById(R.id.rcv_dashboard);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        String[] myDataset = {"Total Order : 805","Total Outlets : 20","Total Sale Amount : 500,000"};
        mAdapter = new DashboardRcvAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
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