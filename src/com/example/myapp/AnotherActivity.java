package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Practicant1.ORPO_KRG on 12.06.2014.
 */
public class AnotherActivity extends Activity implements View.OnClickListener{

    TextView tvUrl1, tvUrl2, tvUrl3;
    EditText etUrl1, etUrl2, etUrl3;
    Button btnSave, btnCancel;
    public String url1;
    SharedPrefs sharedPrefs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);

        sharedPrefs = new SharedPrefs();

        tvUrl1 = (TextView)findViewById(R.id.tvurl1);
        tvUrl2 = (TextView)findViewById(R.id.tvurl2);
        tvUrl3 = (TextView)findViewById(R.id.tvurl3);

        etUrl1 = (EditText)findViewById(R.id.eturl1);
        etUrl2 = (EditText)findViewById(R.id.eturl2);
        etUrl3 = (EditText)findViewById(R.id.eturl3);

        btnSave = (Button)findViewById(R.id.btnsave);
        btnCancel = (Button)findViewById(R.id.btncancel);

        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        loadUrls();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnsave:
                saveUrls();
                Intent intent = new Intent();
                intent.putExtra("url1","value_here");
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.btncancel:
                onBackPressed();
                break;
        }
    }

    private void saveUrls(){
        sharedPrefs.setMyStringPref(this, "url1", etUrl1.getText().toString());
        sharedPrefs.setMyStringPref(this, "url2", etUrl2.getText().toString());
        sharedPrefs.setMyStringPref(this, "url3", etUrl3.getText().toString());
        //Toast.makeText(this, "Urls are saved", Toast.LENGTH_SHORT).show();
    }

    public void loadUrls(){
        etUrl1.setText(sharedPrefs.getMyStringPref(this, "url1"));
        etUrl2.setText(sharedPrefs.getMyStringPref(this, "url2"));
        etUrl3.setText(sharedPrefs.getMyStringPref(this, "url3"));
        //Toast.makeText(this, "Urls are loaded", Toast.LENGTH_SHORT).show();
    }

    public String getUrl(int i){
        String temp = "Sthing";
        if(i == 1){

        }
        if(i == 2){

        }
        if(i == 3){

        }
        return temp;
    }
}
