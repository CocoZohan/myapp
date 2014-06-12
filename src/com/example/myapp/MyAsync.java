package com.example.myapp;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Practicant1.ORPO_KRG on 11.06.2014.
 */
public class MyAsync  extends AsyncTask<String, Void, String> {

    Connection conn;
    Context ctx;

    MyAsync (Context ctx){
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(ctx, "onPreExecute", Toast.LENGTH_SHORT).show();
        MyActivity.pb.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(String... strings) {
        String result = "";
        for(String url: strings){
            conn = new Connection();
            result = conn.getFrom(url);
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Toast.makeText(ctx, "onPostExecute", Toast.LENGTH_SHORT).show();
        MyActivity.pb.setVisibility(View.GONE);
        MyActivity.tv.setText(result);
    }
}
