package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class searchCategoryFruitsResults extends AppCompatActivity {

    DBHelperForItems db;
    List<String> allItems;
    ListView itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_category_fruits_results);

        db = new DBHelperForItems(this);
        itemList = findViewById(R.id.itemList);
    }

    public void onStart() {
        super.onStart();
        allItems = db.getItemsForFruit();

        ArrayAdapter itemListArrayAdapter = new ArrayAdapter <String> (searchCategoryFruitsResults.this, android.R.layout.simple_list_item_1, allItems);
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