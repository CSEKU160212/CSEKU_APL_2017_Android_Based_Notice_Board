package com.cseku_160212.noticeboard;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class

Spinner extends AppCompatActivity {

    private static int splash_time_Out=1500;  // splash run time

    String dicipline,batch,university,noticeId;
    int userId;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        final Intent i=getIntent();
        Bundle b=i.getExtras();
        userId=b.getInt("UserId");
        dicipline=b.getString("Dicipline");
        batch=b.getString("Batch");
        university=b.getString("University");

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run()
                {
                    Intent newintent=new Intent(Spinner.this,AfterSignInActivity.class); //intent for going to After sign in Activity...
                    Bundle bundle=new Bundle();
                    bundle.putInt("UserId",userId);
                    bundle.putString("Dicipline",dicipline);
                    bundle.putString("Batch",batch);
                    bundle.putString("University",university);
                    newintent.putExtras(bundle);
                    Spinner.this.finish();
                    Toast.makeText(getApplicationContext(), "Log in Successfully", Toast.LENGTH_SHORT).show();
                    Spinner.this.startActivity(newintent); //start After sign in activiyt....
                }
            },splash_time_Out);
    }
}
