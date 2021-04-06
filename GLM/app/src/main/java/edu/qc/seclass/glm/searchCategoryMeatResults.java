package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class searchCategoryMeatResults extends AppCompatActivity {
    DBHelperForItems db;
    List<String> allItems;
    ListView itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_category_meat_results);
        db = new DBHelperForItems(this);
        itemList = findViewById(R.id.itemList);
    }

    public void onStart() {
        super.onStart();
        allItems = db.getItemsForMeat();
        ArrayAdapter itemListArrayAdapter = new ArrayAdapter <String> (searchCategoryMeatResults.this, android.R.layout.simple_list_item_1, allItems);
        itemList.setAdapter(itemListArrayAdapter);
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
            }
        });
    }

}