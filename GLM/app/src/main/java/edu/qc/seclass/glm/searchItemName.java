package edu.qc.seclass.glm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
    String listName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item_name);

        Intent x = getIntent();
        listName = x.getStringExtra("listClicked");
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
                String  text = itemlist.getItemAtPosition(position).toString();
                //  Toast.makeText(searchItemName.this,""+text,Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(),AddItemWithQuantity.class);
                i.putExtra("itemClicked", text);
                i.putExtra("listClicked", listName);

                startActivity(i);
            }
        });

        add_data.setOnClickListener(new View.OnClickListener() {
            DBHelperForItems dbHelpeForitems = new DBHelperForItems(searchItemName.this);
            @Override
            public void onClick(View v) {
                name = add_name.getText().toString();
                if (name.length() == 0 ){
                    Toast.makeText(searchItemName.this," Please Provide item name. ", Toast.LENGTH_SHORT).show();
                }
              else  if (dbHelpeForitems.isItemAleadyExists(name) == false){
                    db.insertData(name, text);
                    Toast.makeText(searchItemName.this, "Item added", Toast.LENGTH_SHORT).show();
                    add_name.setText("");
                    listItem.clear();
                    viewData();
                }else{
                    Toast.makeText(searchItemName.this," Item not added, it might already exist in the list", Toast.LENGTH_SHORT).show();
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

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        if(id == R.id.goBack){
            Intent i = new Intent(this,MyItems.class);
            i.putExtra("listClicked", listName);
            startActivity(i);
        }
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text = parent.getItemAtPosition(position).toString();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}