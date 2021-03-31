package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   DBHelper database = new DBHelper(this);
   //Button test = findViewById(R.id.createList);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        try{
            this.getSupportActionBar().hide();
        }catch(NullPointerException e){}

        setContentView(R.layout.activity_main);

       // test.setOnClickListener((v) -> {
         //  List<String> results =  database.getEveryone();
           // Toast.makeText(MainActivity.this, results.toString(), Toast.LENGTH_SHORT).show();

        //});



    }


    public void nextActivity(View view){
        Intent i = new Intent(this,UserLists.class);
        startActivity(i);
    }
}