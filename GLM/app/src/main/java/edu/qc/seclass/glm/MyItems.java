package edu.qc.seclass.glm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class MyItems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_items);
    }

    public void goPreviousPage(View view){
        Intent i = new Intent(this,UserLists.class);
        startActivity(i);
    }
    public void goItemDeatilPage(View view){
        Intent i = new Intent(this,itemDetails.class);
        startActivity(i);
    }
    public void goSearchItemsPage(View view){
        Intent i = new Intent(this,searchItem.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.itemmenu,menu);
        return true;
    }
}