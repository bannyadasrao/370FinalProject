package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class searchCategoryDairyResults extends AppCompatActivity {
    DBHelperForItems db;
    List<String> allItems;
    ListView itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_category_dairy_results);
        db = new DBHelperForItems(this);
        itemList = findViewById(R.id.itemList);
    }
    public void onStart() {
        super.onStart();
        allItems = db.getItemsForDairy();
        ArrayAdapter itemListArrayAdapter = new ArrayAdapter <String> (searchCategoryDairyResults.this, android.R.layout.simple_list_item_1, allItems);
        itemList.setAdapter(itemListArrayAdapter);
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = itemList.getItemAtPosition(position).toString();
                Intent i = new Intent(view.getContext(),AddItemWithQuantity.class);

                // String strName = null;
                i.putExtra("itemClicked", text);

                startActivity(i);

                // Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
            }
        });
    }
}