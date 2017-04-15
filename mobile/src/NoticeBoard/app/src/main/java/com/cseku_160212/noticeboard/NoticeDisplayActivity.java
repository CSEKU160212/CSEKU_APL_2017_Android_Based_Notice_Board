package com.cseku_160212.noticeboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NoticeDisplayActivity extends AppCompatActivity {

    TextView t_display;
    String title,description,firstName,date,batch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_display);

        t_display = (TextView) findViewById(R.id.Description);

        final Intent in = getIntent();
        Bundle b = in.getExtras();
        title = b.getString("Title");
        description = b.getString("Description");
        firstName=b.getString("FirstName");
        date=b.getString("Date");
        batch=b.getString("Batch");


        t_display.setText("Title:  "+title+"\n\nDescription:  "+description+"\n\n Posted by :  "+firstName+"  Batch: "+batch+"\n\nPublished at : "+date);


    }
}
