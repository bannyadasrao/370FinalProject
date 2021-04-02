package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class gridLayout extends AppCompatActivity {

    TextView fruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        fruit = findViewById(R.id.textView3);

        Intent i = getIntent();
        String title = i.getStringExtra("title");
        fruit.setText(title);

    }
}