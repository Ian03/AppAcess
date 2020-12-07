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

public class login extends AppCompatActivity {

    //Input
    TextInputEditText InputfullNameRegistre, InputPasswordRegistre;
    //Buttons
    Button ButtonLogin,ButtonregistreLogin;
    //ProgressBar
    ProgressBar ProgressbarLogin;
    //String to input
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        //Cls Message
        clsmessagebox clsMessage = new clsmessagebox();

        //Input
        InputfullNameRegistre = findViewById(R.id.inputusernameLogin);
        InputPasswordRegistre = findViewById(R.id.inputpasswordLogin);

        //Buttons
        ButtonLogin = findViewById(R.id.buttonLogin);
        ButtonregistreLogin = findViewById(R.id.buttonregistreLogin);
        //Progress bar
        ProgressbarLogin = findViewById(R.id.progressbarLogin);

        //Click event
        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = String.valueOf(InputfullNameRegistre.getText());
                password = String.valueOf(InputPasswordRegistre.getText());

                if (!username.equals("") && !password.equals("")) {

                    //Start ProgressBar first (Set visibility VISIBLE)
                    ProgressbarLogin.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";
                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;
                            PutData putData = new PutData("http://appacess.iboxtec.com/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    ProgressbarLogin.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    //End ProgressBar (Set visibility to GONE)
                                    if (result.equals("Login Success"))
                                    {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent activity2Intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(activity2Intent);
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        //clsMain.TxtWellcomeMain.setText("");
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
                    clsMessage.messagebox("Messagem Alerta", "Favor preencher todos os campos","Entendi", login.this);
                }

            }
        });

        ButtonregistreLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(getApplicationContext(), registre.class);
                startActivity(activityIntent);
            }
        });
    }
}
