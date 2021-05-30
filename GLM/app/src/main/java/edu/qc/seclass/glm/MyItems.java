package edu.qc.seclass.glm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;

public class MyItems extends AppCompatActivity {
    RadioButton addButton;

    RecyclerView recyclerView;
    String name;
    SQLiteDatabase checkBoxDatabase;
    DBHelpeForCheckboxAndQuantity quantityChanged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        addButton = findViewById(R.id.AddByCategory);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_items);

        checkBoxDatabase = new DBHelpeForCheckboxAndQuantity(this).getWritableDatabase();
        quantityChanged = new DBHelpeForCheckboxAndQuantity(MyItems.this);

        Intent x = getIntent();
        name = x.getStringExtra("listClicked");

        recyclerView = findViewById(R.id.recyclerviewforitems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DBHelpeForCheckboxAndQuantity dbHelpeForCheckboxAndQuantity = new DBHelpeForCheckboxAndQuantity(this);

        List<ItemsModal> itemsModal = dbHelpeForCheckboxAndQuantity.getAllItemWithQuantity(name);

        if(itemsModal.size() > 0){
            AdapterForItems adapterForItems = new AdapterForItems(itemsModal,MyItems.this);
            recyclerView.setAdapter(adapterForItems);
        }else{
            Toast.makeText(this, "No data exists in database",Toast.LENGTH_SHORT).show();
        }
    }


    public void goSearchCategoryPage(View view){
        Intent i = new Intent(this,searchCategory.class);
        i.putExtra("listClicked", name);
        startActivity(i);
    }

    public void goSearchItemNamePage(View view){
        Intent i = new Intent(this,searchItemName.class);
        i.putExtra("listClicked", name);
        startActivity(i);
    }

    public void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.itemmenu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        switch (id){
            case (R.id.deleteAllItems):
                quantityChanged = new DBHelpeForCheckboxAndQuantity(MyItems.this);
                quantityChanged.DeleteAllListItems(name);
                Intent update = new Intent(this, UserLists.class);
                startActivity(update);
                break;

            case (R.id.goBack):
                Intent goback = new Intent(this,UserLists.class);
                startActivity(goback);
                break;
        }
        return false;
    }
}