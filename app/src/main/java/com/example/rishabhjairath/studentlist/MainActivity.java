package com.example.rishabhjairath.studentlist;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class    MainActivity extends AppCompatActivity {

    final ArrayList<String>dataList=new ArrayList<>();
    ListView mBatchListView;
    ArrayAdapter<String> adapter;
    Button mButtonAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_main);
        mBatchListView=(ListView)findViewById(R.id.batchListView);
        mButtonAdd=(Button)findViewById(R.id.buttonAdd);
        dataList.add("java1");
        dataList.add("java2");
        dataList.add("java3");
        dataList.add("android");
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataList);
        mBatchListView.setAdapter(adapter);
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.add("blah");
                adapter.notifyDataSetChanged();
            }
        });
        mBatchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,dataList.get(position),Toast.LENGTH_LONG).show();
                        //(string)parent.getAdapter.getItem(position)
            }
        });
        mBatchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(" Item Clicked");
                //custom layout created for display on alertDialog
                //since items on alertDialog are not present on the screen, we use v.findViewById
                View v=getLayoutInflater().inflate(R.layout.dialog_view,null);
                TextView tv1=(TextView) v.findViewById(R.id.textView1);
                tv1.setText((String)parent.getAdapter().getItem(position));
               // TextView tv2=(TextView) v.findViewById(R.id.textView2);
                builder.setView(v);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //what to do after OK is pressed
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

    }
}
