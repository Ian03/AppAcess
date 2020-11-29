package com.iboxtec.appacess.database;

public class ScriptDLL
{
    public static  String getCreateTableCliente()
    {

        StringBuilder sql = new StringBuilder();

        sql.append(" CREATE TABLE IF NOT EXISTS CLIENT (");
        sql.append(" CODE INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " );
        sql.append(" NOME VARCHAR (250) NOT NULL DEFAULT (''), " );
        sql.append(" ADDRESS VARCHAR (255) NOT NULL DEFAULT (''),");
        sql.append(" EMAIL VARCHAR (200) NOT NULL DEFAULT (''), ");
        sql.append(" PHONE VARCHAR (20) NOT NULL DEFAULT ('') ) ");

      return  sql.toString();

    }
}
