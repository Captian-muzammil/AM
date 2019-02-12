package com.muzammil.teamtnt.am;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

            TextView textView = findViewById(R.id.hello);


           textView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   showDialog();
               }
           });
        }



    public void showDialog() {
        DialogFragment dialog = new DateRangeDialogFragment();
        dialog.show(getSupportFragmentManager(), "DateRangeDialogFragment");
        }
    }