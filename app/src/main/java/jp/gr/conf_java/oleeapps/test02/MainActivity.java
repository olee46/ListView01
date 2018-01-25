package jp.gr.conf_java.oleeapps.test02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set list items to ArrayList
        final ArrayList<String> data = new ArrayList<>();
        data.add("2018/01/31");
        data.add("2018/01/20");
        data.add("2018/01/15");
        data.add("2018/01/10");
        data.add("2018/01/01");

        // create ArrayAdapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        // set ArrayAdapter to ListView
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        // set onclick listener
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView nextItem = (TextView)parent.getChildAt(++position);
                String nextDate = nextItem.getText().toString();
                String thisDate = ((TextView)view).getText().toString();

                // create Intent
                Intent i = new Intent(MainActivity.this, SubActivity.class);
                i.putExtra("maxDate", thisDate);
                i.putExtra("minDate", nextDate);
                // start activity
                startActivity(i);

            }
        });
    }
}
