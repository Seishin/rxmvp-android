package com.apsoft.rxmvp.sample.features.events.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.apsoft.rxbus.annotations.Event;
import com.apsoft.rxmvp.library.views.RxActivity;
import com.apsoft.rxmvp.sample.R;
import com.apsoft.rxmvp.sample.eventbus.events.SaySomethingEvent;
import com.apsoft.rxmvp.sample.features.events.presenters.EventsPresenter;

public class EventsActivity extends RxActivity<EventsPresenter> {

    private EditText messageField;
    private Button sayItButton;
    private TextView messageTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        setPresenter(new EventsPresenter(this));

        initUI();
    }

    @SuppressWarnings("ConstantConditions")
    private void initUI() {
        getSupportActionBar().setTitle("Events Sample");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        messageField = (EditText) findViewById(R.id.message);
        messageTextView = (TextView) findViewById(R.id.received_message);

        sayItButton = (Button) findViewById(R.id.say_it);
        sayItButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEventBus().send(new SaySomethingEvent(messageField.getText().toString()));
            }
        });
    }

    @Event(SaySomethingEvent.class)
    public void onSaySomethingEventReceived(SaySomethingEvent event) {
        messageTextView.setText(event.getMessage());
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
