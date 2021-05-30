package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SQLiteDatabase UserListDatabase = new DBHelperForList(this).getWritableDatabase();
        SQLiteDatabase itemDatabase = new DBHelperForItems(this).getWritableDatabase();
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