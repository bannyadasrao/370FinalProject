package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class searchCategory extends AppCompatActivity implements View.OnClickListener {

    private ImageButton Fruit, Meat, Dairy, Vegetable, Bakery, Snack, Liquor, Beverage, Cleaning, Hygiene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_category);

        Fruit = findViewById(R.id.Fruits);
        Meat = findViewById(R.id.Meat);
        Dairy = findViewById(R.id.Dairy);
        Vegetable = findViewById(R.id.Vegetable);
        Bakery = findViewById(R.id.Bakery);
        Snack = findViewById(R.id.Snack);
        Liquor = findViewById(R.id.Liquor);
        Beverage = findViewById(R.id.Beverage);
        Cleaning = findViewById(R.id.Cleaning);
        Hygiene = findViewById(R.id.Hygiene);

        Fruit.setOnClickListener((View.OnClickListener) this);
        Meat.setOnClickListener((View.OnClickListener) this);
        Dairy.setOnClickListener((View.OnClickListener) this);
        Vegetable.setOnClickListener((View.OnClickListener) this);
        Bakery.setOnClickListener((View.OnClickListener) this);
        Snack.setOnClickListener((View.OnClickListener) this);
        Liquor.setOnClickListener((View.OnClickListener) this);
        Beverage.setOnClickListener((View.OnClickListener) this);
        Cleaning.setOnClickListener((View.OnClickListener) this);
        Hygiene.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.Fruits) {
            Intent i = new Intent(this, searchCategoryFruitsResults.class);
            startActivity(i);
        } else if (view.getId() == R.id.Meat) {
            Intent i = new Intent(this, searchCategoryMeatResults.class);
            startActivity(i);
        } else if (view.getId() == R.id.Dairy) {
            Intent i = new Intent(this, searchCategoryDairyResults.class);
            startActivity(i);
        } else if (view.getId() == R.id.Vegetable) {
            Intent i = new Intent(this, searchCategoryVegetableResults.class);
            startActivity(i);
        } else if (view.getId() == R.id.Bakery) {
            Intent i = new Intent(this, searchCategoryBakeryResults.class);
            startActivity(i);
        } else if (view.getId() == R.id.Snack) {
            Intent i = new Intent(this, searchCategorySnackResults.class);
            startActivity(i);
        } else if (view.getId() == R.id.Liquor) {
            Intent i = new Intent(this, searchCategoryLiquorResults.class);
            startActivity(i);
        } else if (view.getId() == R.id.Beverage) {
            Intent i = new Intent(this, searchCategoryBeverageResults.class);
            startActivity(i);
        } else if (view.getId() == R.id.Cleaning) {
            Intent i = new Intent(this, searchCategoryCleaningResults.class);
            i.putExtra("categoryClicked", "Cleaning");
            startActivity(i);
        } else if (view.getId() == R.id.Hygiene) {
            Intent i = new Intent(this, searchCategoryHygieneResults.class);
            i.putExtra("categoryClicked", "Hygiene");
            startActivity(i);
        }
    }
}