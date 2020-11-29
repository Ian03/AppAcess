package com.iboxtec.appacess.domain.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iboxtec.appacess.domain.entities.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository
{

    private SQLiteDatabase connection;

    public ClientRepository(SQLiteDatabase connection)
    {
            this.connection = connection;
    }

    public void insert(Client client)
    {
        ContentValues  contentValues = new ContentValues();
        contentValues.put("NOME", client.name);
        contentValues.put("ADDRESS", client.address);
        contentValues.put("EMAIL", client.Email);
        contentValues.put("PHONE", client.phone);

        connection.insertOrThrow("CLIENT", null,contentValues);

    }

    public void Dell(int code)
    {
        String [] parameters = new String[1];
        //convert parameters to string
        parameters[0] = String.valueOf(code);

        connection.delete("CLIENT","CODE = ?",parameters);
    }

    public void Change(Client client)
    {
        ContentValues  contentValues = new ContentValues();
        contentValues.put("NOME", client.name);
        contentValues.put("ADDRESS", client.address);
        contentValues.put("EMAIL", client.Email);
        contentValues.put("PHONE", client.phone);

        String [] parameters = new String[1];
        //convert parameters to string
        parameters[0] = String.valueOf(client.code);

        connection.update("CLIENT",contentValues,"CODE = ?",parameters);
    }

    public List<Client> buscarTodos()
    {
       List<Client> clients = new ArrayList<Client>();

       StringBuilder sql = new StringBuilder();

       sql.append(" SELECT CODE, NAME, ADDRESS, EMAIL, PHONE");
       sql.append("   FROM  CLIENT");

       Cursor result = connection.rawQuery(sql.toString(),null);

       if(result.getCount() > 0)
       {
           result.moveToFirst();


           do{

               Client  cli = new Client();

               cli.code = result.getInt(result.getColumnIndexOrThrow("CODE"));
               cli.name = result.getString(result.getColumnIndexOrThrow("NAME"));
               cli.address = result.getString(result.getColumnIndexOrThrow("ADDRESS"));
               cli.Email = result.getString(result.getColumnIndexOrThrow("EMAIL"));
               cli.phone = result.getString(result.getColumnIndexOrThrow("PHONE"));

               clients.add(cli);

           }while (result.moveToNext());

       }

       return clients;
    }

    public Client SearchClient (int code)
    {
        Client client = new Client();

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT CODE, NAME, ADDRESS, EMAIL, PHONE");
        sql.append("   FROM  CLIENT");
        sql.append(" WHERE CODE = ?");

        String [] parameters = new String[1];
        //convert parameters to string
        parameters[0] = String.valueOf(code);

        Cursor result = connection.rawQuery(sql.toString(),parameters);


        if(result.getCount() > 0)
        {
            result.moveToFirst();

            client.code = result.getInt(result.getColumnIndexOrThrow("CODE"));
            client.name = result.getString(result.getColumnIndexOrThrow("NAME"));
            client.address = result.getString(result.getColumnIndexOrThrow("ADDRESS"));
            client.Email = result.getString(result.getColumnIndexOrThrow("EMAIL"));
            client.phone = result.getString(result.getColumnIndexOrThrow("PHONE"));

            return client;

        }

        return null;
    }
}
