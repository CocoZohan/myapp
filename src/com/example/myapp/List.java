package com.example.myapp;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by practicant1.orpo_krg on 10.06.2014.
 */
public class List extends ListFragment {

    final String ATTR_NAME_TEXT = "main_text";
    final String ATTR_NAME_SUBTEXT = "subtext";
    final String ATTR_NAME_IMG = "img";

    AnotherActivity aa;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aa = new AnotherActivity();
        intent = new Intent(getActivity(), aa.getClass());

        ArrayList<Map<String, Object>> data = new ArrayList<Map<String,
                Object>>(getResources().getStringArray(R.array.buttons).length);
        Map<String, Object> m;

        for(int i = 0; i<getResources().getStringArray(R.array.buttons).length; i++){
            m = new HashMap<String, Object>();
            m.put(ATTR_NAME_IMG, R.drawable.ic_launcher);
            m.put(ATTR_NAME_TEXT, getResources().getStringArray(R.array.buttons)[i].toString());
            m.put(ATTR_NAME_SUBTEXT, getResources().getStringArray(R.array.descr)[i].toString());
            data.add(m);
        }

        String [] from = {ATTR_NAME_IMG, ATTR_NAME_TEXT, ATTR_NAME_SUBTEXT};
        int[] to = {R.id.icon, R.id.text, R.id.subtext};

        SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), data, R.layout.my_item_list, from, to);
        setListAdapter(adapter);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch(position){
            case 0:
                if(aa.getUrl(1) != null) {
                    Toast.makeText(this.getActivity(), "Url address is not empty", Toast.LENGTH_SHORT).show();//new MyAsync(this.getActivity()).execute();
                } else {
                    Toast.makeText(this.getActivity(), "Url address is empty", Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:
                startActivity(intent);
                break;
        }
    }

}
