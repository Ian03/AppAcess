package com.iboxtec.appacess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.common.base.Strings;
import com.iboxtec.appacess.database.DatabaseOpenHelper;
import com.iboxtec.appacess.domain.repository.ClientRepository;

import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

public class MainActivity extends AppCompatActivity
{
    //Variables

    // Call Database information
    Databasememory objectDatabase;
    EditText txtname,txtaddress,txtcity;

    SQLiteDatabase Database = null;
    Cursor cursor;

    private SQLiteDatabase conexao;
    private DatabaseOpenHelper databaseOpenHelper;
    private ConstraintLayout layoutMain;

    //Database
    private ClientRepository clientRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutMain = (ConstraintLayout)findViewById(R.id.layoutMainid);

        criarconexao();

    }

    private void criarconexao()
    {
        try
        {
            databaseOpenHelper = new DatabaseOpenHelper(this);
            conexao = databaseOpenHelper.getWritableDatabase();
            Snackbar.make(layoutMain, "Conexão criada com sucesso!", Snackbar.LENGTH_LONG )
                    .setAction("OK",null).show();
        }
        catch (SQLException ex)
        {
            Messagebox("lol","Deu erro sa porra!");
        }
    }

    public void OpenDatabase(View view)
    {
        try
        {

            Database = SQLiteDatabase.openOrCreateDatabase("Databaseapp",null,null);
            String sql = "CREATE TABLE IF NOT EXISTS cliente"
                    + "(id INTEGER PRIMARY KEY, nome TEXT, endereço TEXT,"
                    + "telefone TEXT)";
            Database.execSQL(sql);
            Messagebox("lol","Abriu sa porra!");
        }
        catch(Exception erro)
        {
            Messagebox("Erro","Ao tentar acessar o banco de dados");
        }


    }

    public void SendButton(View view)
    {
        Messagebox("Messagem de boas vindas", "Hello world");
    }

    public void SendConfig(View view)
    {
        setContentView(R.layout.config);

    }

    public void AboutButton(View view)
    {
        Messagebox("Messagem Alert", "Aplicativo em desenvolvimento por Ian");
    }

    public void SendMain(View view)
    {
        setContentView(R.layout.activity_main);
    }

    public void SendRegistre(View view)
    {
        try {

            objectDatabase = new Databasememory();
            // Name Adress City \\
            txtname = (EditText) findViewById(R.id.editNameid);
            txtaddress = (EditText) findViewById(R.id.editaddresid);
            txtcity = (EditText) findViewById(R.id.editcityid);

            objectDatabase.name = txtname.getText().toString();
            objectDatabase.address = txtaddress.getText().toString();
            objectDatabase.city = txtcity.getText().toString();
        }
        catch (Exception erro)
        {
           Messagebox("Erro", "Ao tentar salvar");
        }
        finally
        {
            if (!Strings.isNullOrEmpty(txtname.getText().toString()))
            {

                setContentView(R.layout.activity_main);

            }
            else
            {
                Messagebox("Erro", "por favor preencher dados essenciais");

            }


        }

    }

    public void Messagebox(String Title, String textmessage)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle(Title);
        builder.setMessage(textmessage);
        builder.setNeutralButton("Entendi",null);
        builder.show();
    }

    public void SendShow(View view)
    {
        try {
            TextView txtwelcome = (TextView)  findViewById(R.id.texvwelcomeid);

            txtwelcome.setText("Olá " + objectDatabase.name);
        }
        catch (Exception erro)
        {
            Messagebox("Erro", "Ao tentar acessa banco de dados");
        }

    }
}