package com.example.darkmode;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //check condition
        if (AppCompatDelegate.getDefaultNightMode()== AppCompatDelegate.MODE_NIGHT_YES){
            //when night mode is equal to yes
            //set dark mode
            setTheme(R.style.Theme_Dark);
        }else{
            //when night mode is equl to no
            //set light theme
            setTheme(R.style.Theme_Light);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchCompat =findViewById(R.id.bt_Switch);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //check condition
                if (isChecked){
                    //when switch button is checked
                    //set night mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else {
                    //when switch button is unchecked
                    //set light mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

    }

    //Exit Dialog Box
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to Exit?")
                // if you don't click yes or no in that dialog box but you click another area so it will prevent that
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                       MainActivity.super.onBackPressed();
                    }
                })
        .setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }
}