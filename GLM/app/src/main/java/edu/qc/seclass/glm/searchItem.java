package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class searchItem extends AppCompatActivity implements View.OnClickListener{
    ImageButton fruits, meat, dairy, vegetables, bakery, snack, liquor, beverages, cleaning, hygiene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);

        fruits = findViewById(R.id.fruits);
        meat = findViewById(R.id.meat);
        dairy = findViewById(R.id.dairy);
        vegetables = findViewById(R.id.vegetables);
        bakery = findViewById(R.id.bakery);
        snack = findViewById(R.id.snack);
        liquor = findViewById(R.id.liquor);
        beverages = findViewById(R.id.beverages);
        cleaning = findViewById(R.id.cleaning);
        hygiene = findViewById(R.id.hygiene);

        fruits.setOnClickListener(this);
        meat.setOnClickListener(this);
        dairy.setOnClickListener(this);
        vegetables.setOnClickListener(this);
        bakery.setOnClickListener(this);
        snack.setOnClickListener(this);
        liquor.setOnClickListener(this);
        beverages.setOnClickListener(this);
        cleaning.setOnClickListener(this);
        hygiene.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.fruits:
                i = new Intent(this,categoryFruit.class);
                startActivity(i);
                break;

            case R.id.meat:
                i = new Intent(this,categoryMeat.class);
                startActivity(i);
                break;

            case R.id.dairy:
                i = new Intent(this,categoryDairy.class);
                startActivity(i);
                break;

            case R.id.vegetables:
                i = new Intent(this,categoryVegetables.class);
                startActivity(i);
                break;

            case R.id.bakery:
                i = new Intent(this,categoryBakery.class);
                startActivity(i);
                break;

            case R.id.snack:
                i = new Intent(this,categorySnack.class);
                startActivity(i);
                break;

            case R.id.liquor:
                i = new Intent(this,categoryLiquor.class);
                startActivity(i);
                break;

            case R.id.beverages:
                i = new Intent(this,categoryBeverages.class);
                startActivity(i);
                break;

            case R.id.cleaning:
                i = new Intent(this,categoryCleaning.class);
                startActivity(i);
                break;

            case R.id.hygiene:
                i = new Intent(this,categoryHygiene.class);
                startActivity(i);
                break;
        }
    }
}