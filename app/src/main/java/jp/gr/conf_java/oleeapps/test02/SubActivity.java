package jp.gr.conf_java.oleeapps.test02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {
    String maxDate;
    String minDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // get Intent
        Intent i = SubActivity.this.getIntent();
        // get extras from Intent
        maxDate = i.getStringExtra("maxDate");
        minDate = i.getStringExtra("minDate");

        // set ArrayList
        final ArrayList<String> data = new ArrayList<>();
        data.add(maxDate);
        data.add(minDate);

        // set ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SubActivity.this, android.R.layout.simple_list_item_1, data);
        ListView subList = (ListView)findViewById(R.id.subList);
        subList.setAdapter(adapter);

    }
}
