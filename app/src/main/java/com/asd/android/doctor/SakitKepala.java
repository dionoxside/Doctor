package com.asd.android.doctor;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SakitKepala extends ListActivity {
    private List<String> listValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sakit_kepala);
        listValue = new ArrayList<String>();
        listValue.add("test");
        listValue.add("dumy");
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, R.layout.list_item,R.id.textView2,listValue);

        setListAdapter(myAdapter);
        }
        @Override
    protected void onListItemClick(ListView list, View view, int position, long id){
            super.onListItemClick(list, view,position,id);

            String selectedItem = (String) getListView().getItemAtPosition(position);
            Toast.makeText(getApplicationContext(),"test List" +position, Toast.LENGTH_SHORT);
        }
}
