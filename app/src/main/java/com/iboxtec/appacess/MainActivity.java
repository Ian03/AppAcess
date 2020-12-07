package com.iboxtec.appacess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iboxtec.appacess.messagebox.clsmessagebox;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class MainActivity extends AppCompatActivity
{
    //Buttons
    Button buttonAlert, buttonConfig;
    //Float button
    FloatingActionButton buttonRefresh;
    //
   public TextView TxtWellcomeMain;
    //ProgressBar
    ProgressBar ProgressbarMain;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cls Message
        clsmessagebox clsMessage = new clsmessagebox();

        //Buttons
        buttonAlert = findViewById(R.id.buttonalertMain);
        buttonConfig = findViewById(R.id.buttonconfigMain);
        //Float button
        buttonRefresh = findViewById(R.id.buttonFloatingMain);
        //Progress bar
        ProgressbarMain = findViewById(R.id.progressbarMain);

        //Click event
        buttonAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clsMessage.messagebox("Messagem Alerta", "Messagem de boas vindas","Entendi", MainActivity.this);
            }
        });

        buttonConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent activityIntent = new Intent(getApplicationContext(), config.class);
                startActivity(activityIntent);
            }
        });
        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Start ProgressBar first (Set visibility VISIBLE)
               // ProgressbarMain.setVisibility(View.VISIBLE);
            }
        });

    }
}