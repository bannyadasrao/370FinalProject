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

public class searchCategoryBeverageResults extends AppCompatActivity {
    DBHelperForItems db;
    List<String> allItems;
    ListView itemList;
    String listName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_category_beverage_results);
        db = new DBHelperForItems(this);
        itemList = findViewById(R.id.itemList);
        Intent x= getIntent();
        listName = x.getStringExtra("listClicked");
    }
    public void onStart() {
        super.onStart();
        allItems = db.getItemsForBeverage();

        ArrayAdapter itemListArrayAdapter = new ArrayAdapter <String> (searchCategoryBeverageResults.this, android.R.layout.simple_list_item_1, allItems);
        itemList.setAdapter(itemListArrayAdapter);
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = itemList.getItemAtPosition(position).toString();
                Intent i = new Intent(view.getContext(),AddItemWithQuantity.class);
                i.putExtra("itemClicked", text);
                i.putExtra("listClicked", listName);
                startActivity(i);
            }
        });
    }
}