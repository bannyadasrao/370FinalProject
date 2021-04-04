package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class searchItem extends AppCompatActivity {
    private AutoCompleteTextView autosearchbyname;
    private ArrayList<String> allName;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);

        autosearchbyname = findViewById(R.id.autosearchbyname);
        db = new DBHelper(searchItem.this);
        allName = db.getItemName();
        ArrayAdapter<String> autoComplete = new ArrayAdapter<>(searchItem.this, android.R.layout.simple_list_item_1,allName);
        autosearchbyname.setAdapter(autoComplete);
    }
}