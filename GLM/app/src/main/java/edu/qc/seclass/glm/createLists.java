package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createLists extends AppCompatActivity {

    EditText namefornewlist;
    Button savecreatedlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_lists);

        namefornewlist = findViewById(R.id.namefornewlist);
        savecreatedlist = findViewById(R.id.savecreatedlist);

        savecreatedlist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Save new created list by clicking "SAVE" button

            }
        });
    }
}