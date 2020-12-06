package com.iboxtec.appacess.messagebox;

import android.app.Activity;
import android.app.AlertDialog;

public  class clsmessagebox
{
    public void messagebox(String Title, String textmessage, String textmessagebutton, Activity Windows)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Windows);

        builder.setTitle(Title);
        builder.setMessage(textmessage);
        builder.setNeutralButton(textmessagebutton,null);
        builder.show();
    }
}
