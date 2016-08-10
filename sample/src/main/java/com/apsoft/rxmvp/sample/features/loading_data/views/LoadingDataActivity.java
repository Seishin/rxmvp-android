package com.apsoft.rxmvp.sample.features.loading_data.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.apsoft.rxmvp.library.views.RxActivity;
import com.apsoft.rxmvp.sample.R;
import com.apsoft.rxmvp.sample.features.loading_data.presenters.LoadingDataPresenter;

import java.util.ArrayList;

public class LoadingDataActivity extends RxActivity<LoadingDataPresenter> {

    private String TAG = LoadingDataActivity.class.getCanonicalName();

    private ListView colorsList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_data);
        setPresenter(new LoadingDataPresenter(this));

        initUI();
    }

    @SuppressWarnings("ConstantConditions")
    private void initUI() {
        getSupportActionBar().setTitle("Events Sample");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        Button loadColors = (Button) findViewById(R.id.load_colors);
        loadColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().loadColors();
            }
        });

        colorsList = (ListView) findViewById(R.id.list_colors);
    }

    public void onColorsListReceived(ArrayList<String> colors) {
        colorsList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, colors));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
