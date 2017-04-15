package com.cseku_160212.noticeboard;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateNoticeActivity extends AppCompatActivity {


    private static EditText et_title, et_description;
    private static Button post,update;
    private static Spinner spinner;

    ListView listView;

    String title, description, type;
    String dicipline,batch,university,noticeId;
    int userId;

    ArrayList<String> list;

    String[] Notice_Type = {"Only my batch","For all","Only for Subscriber"};
    AlertDialog.Builder builder;
    //to publish notice
    String post_url = "http://192.168.43.148/Notice/Publish.php";
    //the post _writer
    String writer_url = "http://192.168.43.148/Notice/writer.php";
    //edit the post;
    String update_url = "http://192.168.43.148/Notice/edit.php";
    //delete the post
    String delete_url = "http://192.168.43.148/Notice/delete.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_notice_activity);

        et_title = (EditText) findViewById(R.id.Title);
        et_description = (EditText) findViewById(R.id.Description);
        post = (Button) findViewById(R.id.Post);
        update = (Button) findViewById(R.id.update);
        listView=(ListView)findViewById(R.id.write);

        builder = new AlertDialog.Builder(CreateNoticeActivity.this);
        //for the drop dwon text suggestion
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Notice_Type);
        spinner.setAdapter(adapter);

        final Intent i=getIntent();
        Bundle b=i.getExtras();
        userId=b.getInt("UserId");
        dicipline=b.getString("Dicipline");
        batch=b.getString("Batch");
        university=b.getString("University");
        //work of post button
        post.setOnClickListener(new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v) {
                                        title = et_title.getText().toString();
                                        description = et_description.getText().toString();
                                        type = spinner.getSelectedItem().toString();

                                        if (title.equals("") || description.equals("") || type.equals(""))
                                        {
                                            builder.setTitle("Please fill up all again");
                                            displayAlert("Fill title ,description, notice type");
                                        } else {
                                            //notice post request
                                            StringRequest stringRequest = new StringRequest(Request.Method.POST, post_url, new Response.Listener<String>()
                                            {
                                                @Override
                                                public void onResponse(String response)
                                                {
                                                    try
                                                    {
                                                        //getting data from json array
                                                        JSONArray jsonArray = new JSONArray(response);
                                                        JSONObject jsonObject = jsonArray.getJSONObject(0);
                                                        String code = jsonObject.getString("code");
                                                        if (code.equals("Success"))
                                                        {
                                                            addNotification(description);
                                                            builder.setTitle(code);
                                                            displayAlert(jsonObject.getString("message"));
                                                            Intent i=getIntent();
                                                            CreateNoticeActivity.this.finish();
                                                            CreateNoticeActivity.this.startActivity(i);
                                                        }
                                                        else
                                                        {
                                                            Log.d("post", "else");
                                                            builder.setTitle("Post failed");
                                                            displayAlert(jsonObject.getString("message"));
                                                        }
                                                    } catch (JSONException e)
                                                    {
                                                        e.printStackTrace();
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }, new Response.ErrorListener() {
                                                @Override
                                                public void onErrorResponse(VolleyError error) {
                                                    Log.d("post", "in Error");
                                                    Toast.makeText(CreateNoticeActivity.this, "Error", Toast.LENGTH_LONG).show();
                                                    error.printStackTrace();
                                                }
                                            }) {
                                                @Override
                                                //pushing data in php
                                                protected Map<String, String> getParams() throws AuthFailureError {
                                                    Map<String, String> params = new HashMap<String, String>();
                                                    params.put("Title", title);
                                                    params.put("Description", description);
                                                    params.put("NoticeType", type);
                                                    params.put("UserId", String.valueOf(userId));
                                                    return params;
                                                }
                                            };
                                            Mysingleton.getInstance(CreateNoticeActivity.this).addToRequestque(stringRequest);
                                        }
                                    }
                                }
        );
        //work of edit button
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                title = et_title.getText().toString();
                description = et_description.getText().toString();
                type = spinner.getSelectedItem().toString();

                //edit request
                StringRequest stringReques = new StringRequest(Request.Method.POST, update_url, new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            //getting data from json array
                            JSONArray jsonArray = new JSONArray(response);
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            String code = jsonObject.getString("code");
                            if (code.equals("Success"))
                            {
                                addNotification(description);
                                builder.setTitle(code);
                                displayAlert(jsonObject.getString("message"));
                                Intent i=getIntent();
                                CreateNoticeActivity.this.finish();
                                CreateNoticeActivity.this.startActivity(i);
                            }
                            else
                            {
                                Log.d("post", "else");
                                builder.setTitle("Post failed");
                                displayAlert(jsonObject.getString("message"));
                            }
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }) {
                    @Override
                    //pushing data in php
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("Title", title);
                        params.put("Description", description);
                        params.put("NoticeType", type);
                        params.put("NoticeId",noticeId);
                        return params;
                    }
                };
                Mysingleton.getInstance(CreateNoticeActivity.this).addToRequestque(stringReques);


            }
        });
        //request for seen own notice
        StringRequest imnport=new StringRequest(Request.Method.POST,writer_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try {
                    list=new ArrayList<String>();
                    final JSONArray jsonArray=new JSONArray(response);
                    int length=jsonArray.length();
                    String code;
                    for(int i=0;i<length;i++)
                    {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        code = jsonObject.getString("Title");
                        String co=jsonObject.getString("NoticeType");
                        code=code+"      "+co;
                        list.add(code);
                    }
                    ListAdapter listAdapter=new ArrayAdapter<String>(CreateNoticeActivity.this,android.R.layout.simple_list_item_1,list);
                    listView.setAdapter(listAdapter);
                    registerForContextMenu(listView);
                    listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                        @Override
                        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                            try {
                                JSONObject jsonObjec = jsonArray.getJSONObject(position);
                                String des=jsonObjec.getString("Description");
                                String tit=jsonObjec.getString("Title");
                                String type=jsonObjec.getString("NoticeType");
                                noticeId=jsonObjec.getString("NoticeId");

                                et_title.setText(tit);
                                et_description.setText(des);
                                if(type.equals("Only my batch"))
                                    spinner.setSelection(0);
                                else if(type.equals("For all"))
                                    spinner.setSelection(1);
                                else if(type.equals("Only for Subscriber"))
                                    spinner.setSelection(2);
                                else
                                    spinner.setSelection(0);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            return false;
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        })
        {
            protected Map<String,String>getParams()throws AuthFailureError
            {
                Map<String,String>params=new HashMap<String, String>();
                params.put("UserId", String.valueOf(userId));
                return params;
            }
        };
        Mysingleton.getInstance(CreateNoticeActivity.this).addToRequestque(imnport);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v,menuInfo);
        menu.setHeaderTitle("Select the Action");
        menu.add(0,v.getId(),0,"Edit");
        menu.add(0,v.getId(),0,"Delete");
    }
    public boolean onContextItemSelected(MenuItem item)
    {
        if(item.getTitle()=="Edit")
        {
            post.setVisibility(View.GONE);
            update.setVisibility(View.VISIBLE);

        }
        if(item.getTitle()=="Delete")
        {
            StringRequest stringReques = new StringRequest(Request.Method.POST, delete_url, new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response)
                {
                    try
                    {
                        //getting data from json array
                        JSONArray jsonArray = new JSONArray(response);
                        JSONObject jsonObject = jsonArray.getJSONObject(0);
                        String code = jsonObject.getString("code");
                        if (code.equals("Success"))
                        {
                            Intent i=getIntent();
                            CreateNoticeActivity.this.finish();
                            CreateNoticeActivity.this.startActivity(i);
                        }
                        else
                        {
                            builder.setTitle("Post failed");
                            displayAlert(jsonObject.getString("message"));
                        }
                    } catch (JSONException e)
                    {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            }) {
                @Override
                //pushing data in php
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("NoticeId",noticeId);
                    return params;
                }
            };
            Mysingleton.getInstance(CreateNoticeActivity.this).addToRequestque(stringReques);
        }
        return true;
    }
    public void displayAlert(String message) {
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                et_title.setText("");
                et_description.setText("");
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void addNotification(String des) {
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.al)
                        .setContentTitle("A new notice Published!!!")
                        .setContentText(des);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

}
