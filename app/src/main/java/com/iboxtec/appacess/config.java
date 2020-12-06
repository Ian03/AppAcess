package com.iboxtec.appacess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.iboxtec.appacess.messagebox.clsmessagebox;

public class config extends AppCompatActivity {

    //Buttons
    Button buttonmain, buttonAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        //Cls Message
        clsmessagebox clsMessage = new clsmessagebox();

        //Buttons
        buttonmain = findViewById(R.id.buttonConfig);
        buttonAbout = findViewById(R.id.buttonaboutConfig);

        //Click event
        buttonmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent activityIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activityIntent);
            }
        });

        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clsMessage.messagebox("Messagem Alerta", "Aplicativo em desenvolvimento por Ian","Entendi", config.this);
            }
        });


    }


}