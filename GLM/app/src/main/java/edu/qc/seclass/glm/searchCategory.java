package edu.qc.seclass.glm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class searchCategory extends AppCompatActivity implements View.OnClickListener {

    private ImageButton Fruit, Meat, Dairy, Vegetable, Bakery, Snack, Beverage, Cleaning, Hygiene, Others;
    String listName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_category);

        Intent x= getIntent();
        listName = x.getStringExtra("listClicked");

        Fruit = findViewById(R.id.Fruits);
        Meat = findViewById(R.id.Meat);
        Dairy = findViewById(R.id.Dairy);
        Vegetable = findViewById(R.id.Vegetable);
        Bakery = findViewById(R.id.Bakery);
        Snack = findViewById(R.id.Snack);
        Beverage = findViewById(R.id.Beverage);
        Cleaning = findViewById(R.id.Cleaning);
        Hygiene = findViewById(R.id.Hygiene);
        Others = findViewById(R.id.Others);

        Fruit.setOnClickListener((View.OnClickListener) this);
        Meat.setOnClickListener((View.OnClickListener) this);
        Dairy.setOnClickListener((View.OnClickListener) this);
        Vegetable.setOnClickListener((View.OnClickListener) this);
        Bakery.setOnClickListener((View.OnClickListener) this);
        Snack.setOnClickListener((View.OnClickListener) this);
        Beverage.setOnClickListener((View.OnClickListener) this);
        Cleaning.setOnClickListener((View.OnClickListener) this);
        Hygiene.setOnClickListener((View.OnClickListener) this);
        Others.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.Fruits) {
            Intent i = new Intent(this, searchCategoryFruitsResults.class);
            i.putExtra("listClicked", listName);
            startActivity(i);
        } else if (view.getId() == R.id.Meat) {
            Intent j = new Intent(this, searchCategoryMeatResults.class);
            j.putExtra("listClicked", listName);
            startActivity(j);
        } else if (view.getId() == R.id.Dairy) {
            Intent k = new Intent(this, searchCategoryDairyResults.class);
            k.putExtra("listClicked", listName);
            startActivity(k);
        } else if (view.getId() == R.id.Vegetable) {
            Intent l = new Intent(this, searchCategoryVegetableResults.class);
            l.putExtra("listClicked", listName);
            startActivity(l);
        } else if (view.getId() == R.id.Bakery) {
            Intent m = new Intent(this, searchCategoryBakeryResults.class);
            m.putExtra("listClicked", listName);
            startActivity(m);
        } else if (view.getId() == R.id.Snack) {
            Intent n = new Intent(this, searchCategorySnackResults.class);
            n.putExtra("listClicked", listName);
            startActivity(n);
        } else if (view.getId() == R.id.Beverage) {
            Intent p = new Intent(this, searchCategoryBeverageResults.class);
            p.putExtra("listClicked", listName);
            startActivity(p);
        } else if (view.getId() == R.id.Cleaning) {
            Intent q = new Intent(this, searchCategoryCleaningResults.class);
            q.putExtra("listClicked", listName);
            q.putExtra("categoryClicked", "Cleaning");
            startActivity(q);
        } else if (view.getId() == R.id.Hygiene) {
            Intent r = new Intent(this, searchCategoryHygieneResults.class);
            r.putExtra("listClicked", listName);
            r.putExtra("categoryClicked", "Hygiene");
            startActivity(r);
        } else if (view.getId() == R.id.Others) {
            Intent o = new Intent(this, searchCategoryOthersResults.class);
            o.putExtra("listClicked", listName);
            startActivity(o);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.categorymenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        if(id == R.id.goBack){
            Intent i = new Intent(this,MyItems.class);
            i.putExtra("listClicked", listName);
            startActivity(i);
        }
        return false;
    }
}



