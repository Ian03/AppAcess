package com.iboxtec.appacess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.iboxtec.appacess.messagebox.clsmessagebox;

public class MainActivity extends AppCompatActivity
{
    //Buttons
    Button buttonAlert, buttonConfig;
    //
    TextView TxtWellcomeMain;

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
        //Text
        TxtWellcomeMain = findViewById(R.id.txtWellcomeMain);

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

    }

}