package com.example.myapp;

import android.app.Activity;
import android.content.SharedPreferences;
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
    SharedPreferences sPref;
    String url1, url2, url3;

    final public String PREF_FILE = "MyPref";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);

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
                loadUrls();
                finish();
                break;
            case R.id.btncancel:
                finish();
                break;
        }
    }

    private void saveUrls(){
        sPref = getSharedPreferences(PREF_FILE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString("url1", etUrl1.getText().toString());
        editor.commit();
        editor.clear();
        editor.putString("url2", etUrl2.getText().toString());
        editor.commit();
        editor.clear();
        editor.putString("url3", etUrl3.getText().toString());
        editor.commit();
        editor.clear();
        //Toast.makeText(this, "Urls are saved", Toast.LENGTH_SHORT).show();
    }

    private void loadUrls(){
        sPref = getSharedPreferences(PREF_FILE, MODE_PRIVATE);
        url1 = sPref.getString("url1", "");
        url1 = sPref.getString("url1", "");
        url1 = sPref.getString("url1", "");
        etUrl1.setText(url1);
        etUrl2.setText(url2);
        etUrl3.setText(url3);
        //Toast.makeText(this, "Urls are loaded", Toast.LENGTH_SHORT).show();
    }

    public String getUrl(int i){
        if(i == 1){
            return url1;
        }
        if(i == 2){
            return url1;
        }
        if(i == 3){
            return url1;
        }
        return null;
    }
}
