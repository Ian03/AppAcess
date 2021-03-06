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

import com.google.android.material.textfield.TextInputEditText;
import com.iboxtec.appacess.messagebox.clsmessagebox;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class registre extends AppCompatActivity {

    //Input
    TextInputEditText InputfullNameRegistre, InputEmailRegistre, InputuserNameRegistre, InputPasswordRegistre;
    //Buttons
    Button ButtonRegistre,ButtonloginRegistre;
    //ProgressBar
    ProgressBar ProgressBarRegistre;
    //String to input
    String fullname, username, password, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registre);

        //Cls Message
        clsmessagebox clsMessage = new clsmessagebox();

        //Input
        InputfullNameRegistre = findViewById(R.id.inputfullnameRegistre);
        InputEmailRegistre = findViewById(R.id.inputemailRegistre);
        InputuserNameRegistre = findViewById(R.id.inputusernameRegistre);
        InputPasswordRegistre = findViewById(R.id.inputpasswordRegistre);

        //Buttons
        ButtonRegistre = findViewById(R.id.buttonRegistre);
        ButtonloginRegistre = findViewById(R.id.buttonloginRegistre);
        //Progress bar
        ProgressBarRegistre = findViewById(R.id.progressbarRegistre);

        //Click event
        ButtonRegistre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fullname = String.valueOf(InputfullNameRegistre.getText());
                email = String.valueOf(InputEmailRegistre.getText());
                username = String.valueOf(InputuserNameRegistre.getText());
                password = String.valueOf(InputPasswordRegistre.getText());

                if (!fullname.equals("") && !email.equals("") && !username.equals("") && !password.equals("")) {

                    //Start ProgressBar first (Set visibility VISIBLE)
                    ProgressBarRegistre.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "fullname";
                            field[1] = "email";
                            field[2] = "username";
                            field[3] = "password";
                            //Creating array for data
                            String[] data = new String[4];
                            data[0] = fullname;
                            data[1] = email;
                            data[2] = username;
                            data[3] = password;
                            PutData putData = new PutData("http://appacess.iboxtec.com/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    ProgressBarRegistre.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    //End ProgressBar (Set visibility to GONE)
                                    if (result.equals("Sign Up Success"))
                                    {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent activityIntent = new Intent(getApplicationContext(), login.class);
                                        startActivity(activityIntent);
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                    Log.i("PutData", result);
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }
                else
                {
                    clsMessage.messagebox("Messagem Alerta", "Favor preencher todos os campos","Entendi", registre.this);
                }

            }
        });

        ButtonloginRegistre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(getApplicationContext(), login.class);
                startActivity(activityIntent);
            }
        });

    }
}