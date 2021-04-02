package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class searchItem extends AppCompatActivity{
    RecyclerView categories;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);
        categories = findViewById(R.id.categories);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("Fruits");
        titles.add("Meat");
        titles.add("Dairy");
        titles.add("Vegetable");
        titles.add("Bakery");
        titles.add("Snack");
        titles.add("Liquor");
        titles.add("Beverage");
        titles.add("Cleaning");
        titles.add("Hygiene");

        images.add(R.drawable.fruits);
        images.add(R.drawable.meat);
        images.add(R.drawable.dairy);
        images.add(R.drawable.vegetables);
        images.add(R.drawable.bakery);
        images.add(R.drawable.snack);
        images.add(R.drawable.liquor);
        images.add(R.drawable.beverages);
        images.add(R.drawable.cleaning);
        images.add(R.drawable.hygiene);

        adapter = new Adapter(this,titles,images);
        GridLayoutManager glManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        categories.setLayoutManager(glManager);
        categories.setAdapter(adapter);
    }
}