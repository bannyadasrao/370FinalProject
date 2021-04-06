package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;


public class MyItems extends AppCompatActivity  {
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        addButton = findViewById(R.id.AddByCategory);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_items);
    }

    public void goSearchByCategoryPage(View view){
        Intent i = new Intent(this,searchCategory.class);
        startActivity(i);
    }

    public void goSearchItemNamePage(View view){
        Intent i = new Intent(this,searchItemName.class);
        startActivity(i);
    }

    public void onStart() {
        super.onStart();
    }
}