package edu.qc.seclass.glm;

import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SQLiteDatabase ItemDatabase = new DBHelper(this).getWritableDatabase();
        SQLiteDatabase UserListDatabase = new DBHelperForList(this).getWritableDatabase();
        super.onCreate(savedInstanceState);
        try{
            this.getSupportActionBar().hide();
        }catch(NullPointerException e){}

        setContentView(R.layout.activity_main);
    }

    public void goMyListsPage(View view){
        Intent i = new Intent(this,UserLists.class);
        startActivity(i);
    }





}