package com.apsoft.rxmvp.sample.features.main.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.apsoft.rxmvp.sample.R;
import com.apsoft.rxmvp.sample.features.events.views.EventsActivity;
import com.apsoft.rxmvp.sample.features.loading_data.views.LoadingDataActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] options = new String[] {"Events", "Loading Data"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView optionsList = (ListView) findViewById(R.id.options);
        optionsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options));
        optionsList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                startActivity(new Intent(MainActivity.this, EventsActivity.class));
                break;

            case 1:
                startActivity(new Intent(MainActivity.this, LoadingDataActivity.class));
                break;
        }
    }
}
