package edu.qc.seclass.glm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MyItems extends AppCompatActivity implements OnDialogCloseListener {
    Button addButton;

    private RecyclerView mRecyclerview;
    private DBHelperForItems myDB;
    private List<ToDoModel> mList;
    private AdapterForItems adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        addButton = findViewById(R.id.AddItem);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_items);

        mRecyclerview = findViewById(R.id.recyclerview);
        myDB = new DBHelperForItems(MyItems.this);
        mList = new ArrayList<>();
        adapter = new AdapterForItems(myDB , MyItems.this);

        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setAdapter(adapter);

        mList = myDB.getAllTasks();
        Collections.reverse(mList);
        adapter.setTasks(mList);
    }

    public void goSearchItemPage(View view){
        Intent i = new Intent(this,searchItem.class);
        startActivity(i);
    }


    public void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.itemmenu,menu);
        return true;
    }

    @Override
    public void onDialogClose(DialogInterface dialogInterface) {
        mList = myDB.getAllTasks();
        Collections.reverse(mList);
        adapter.setTasks(mList);
        adapter.notifyDataSetChanged();
    }
}