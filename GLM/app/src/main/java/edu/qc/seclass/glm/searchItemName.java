package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuCompat;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class searchItemName extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    DBHelperForItems db;
    Button add_data;
    EditText add_name;

    ArrayList<String> listItem;
    ArrayAdapter adapter;
    ListView itemlist;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item_name);

        db = new DBHelperForItems(this);

        listItem = new ArrayList<>();

        add_data = findViewById(R.id.add_data);
        add_name = findViewById(R.id.add_name);
        itemlist = findViewById(R.id.itemlist);


        final Spinner[] spinner = {findViewById(R.id.add_category)};
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,R.array.categoriesList, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner[0].setAdapter(spinnerAdapter);
        spinner[0].setOnItemSelectedListener(this);

        viewData();

        itemlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
<<<<<<< HEAD:Category working/GLM/app/src/main/java/edu/qc/seclass/glm/searchItemName.java
                //  Position = position;
                String  text = itemlist.getItemAtPosition(position).toString();
                Toast.makeText(searchItemName.this,""+text,Toast.LENGTH_SHORT).show();


=======
              //  Position = position;
                 String  text = itemlist.getItemAtPosition(position).toString();
                 Toast.makeText(searchItemName.this,""+text,Toast.LENGTH_SHORT).show();
                 Intent i = new Intent(view.getContext(),AddItemWithQuantity.class);
                 startActivity(i);
>>>>>>> 598195e4d355d72ee377bf08d7c0d573f67e4dca:GLM/app/src/main/java/edu/qc/seclass/glm/searchItemName.java
            }
        });
        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = add_name.getText().toString();
<<<<<<< HEAD:Category working/GLM/app/src/main/java/edu/qc/seclass/glm/searchItemName.java
                // int position;
                // text = itemlist.getItemAtPosition(position).toString();
=======
               // int position;
               // text = itemlist.getItemAtPosition(position).toString();
>>>>>>> 598195e4d355d72ee377bf08d7c0d573f67e4dca:GLM/app/src/main/java/edu/qc/seclass/glm/searchItemName.java
                if(!name.equals("") && db.insertData(name, text)){
                    Toast.makeText(searchItemName.this, "Data added", Toast.LENGTH_SHORT).show();
                    add_name.setText("");
                    listItem.clear();
                    viewData();
                }else{
                    Toast.makeText(searchItemName.this,"Data not added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void viewData() {
        Cursor cursor = db.viewData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No data to show", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1)); //index1 is name, index0 is ID
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listItem);
            itemlist.setAdapter(adapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        MenuItem searchItem = menu.findItem(R.id.item_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> itemslist = new ArrayList<>();
                for(String items: listItem){
                    if(items.toLowerCase().contains((newText).toLowerCase())){
                        itemslist.add(items);
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(searchItemName.this, android.R.layout.simple_list_item_1,itemslist);
                itemlist.setAdapter(adapter);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text = parent.getItemAtPosition(position).toString();
<<<<<<< HEAD:Category working/GLM/app/src/main/java/edu/qc/seclass/glm/searchItemName.java
        // Toast.makeText(searchItemName.this,"if this is what i think it is"+text,Toast.LENGTH_SHORT).show();
=======
       // Toast.makeText(searchItemName.this,"if this is what i think it is"+text,Toast.LENGTH_SHORT).show();
>>>>>>> 598195e4d355d72ee377bf08d7c0d573f67e4dca:GLM/app/src/main/java/edu/qc/seclass/glm/searchItemName.java
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}