package com.cseku_160212.noticeboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AfterSignInActivity extends AppCompatActivity {
    String dicipline,batch,university,noticeId;
    int userId;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sign_in);

            //getting data from previous activity
            final Intent i=getIntent();
            Bundle b=i.getExtras();
            userId=b.getInt("UserId");
            dicipline=b.getString("Dicipline");
            batch=b.getString("Batch");
            university=b.getString("University");

        }
        //work of create button
    public void crtNBOnClick(View view){

        Intent intent=new Intent(this, CreateNoticeActivity.class);  //intent for create new notice
        //data passing.....
        Bundle bundle=new Bundle();
        bundle.putInt("UserId",userId);
        bundle.putString("Dicipline",dicipline);
        bundle.putString("Batch",batch);
        bundle.putString("University",university);
        intent.putExtras(bundle);
        AfterSignInActivity.this.startActivity(intent); //start create notice activity
    }
    //new notice button onclick listener
    public void NewsFBOnClick(View view)
    {
        Intent intent=new Intent(this, NewNoticeActivity.class); //intent for New notice activity...
        //bundle use for passing data....
        Bundle bundle=new Bundle();
        bundle.putInt("UserId",userId);
        bundle.putString("Dicipline",dicipline);
        bundle.putString("Batch",batch);
        bundle.putString("University",university);
        intent.putExtras(bundle);
        AfterSignInActivity.this.startActivity(intent);  //strt new notice activity
    }

    //old notice button onclick listener
    public void OldBOnclick(View view)
    {
        Intent intent=new Intent(this,OldNoticeActivity.class); //intent for going to Old notice Activity...
        Bundle bundle=new Bundle();
        bundle.putInt("UserId",userId);
        bundle.putString("Dicipline",dicipline);
        bundle.putString("Batch",batch);
        bundle.putString("University",university);
        intent.putExtras(bundle);
        AfterSignInActivity.this.startActivity(intent); // start Old Notice Activity....
    }
    //subscribtion button onclick listener
    public void subOnClick(View view)
    {
        Intent intent=new Intent(this,SubscriptionActivity.class); //intent for going to Subscription Activity....
        Bundle bundle=new Bundle();
        bundle.putInt("UserId",userId);
        intent.putExtras(bundle);
        AfterSignInActivity.this.startActivity(intent);  //start subscription Activity
    }
}
