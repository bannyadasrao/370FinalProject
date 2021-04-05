package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MyItems extends AppCompatActivity implements ItemListener {
    Button addButton;
    String listName;
    RecyclerView recycler_view;
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        addButton = findViewById(R.id.AddByCategory);
        super.onCreate(savedInstanceState);
        listName = getIntent().getStringExtra("ListViewClickValue");
        setContentView(R.layout.activity_my_items);

        recycler_view = findViewById(R.id.recyler_view);

        setRecyclerView();
    }

    private ArrayList<String> getItemData(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Item 1");
        arrayList.add("Item 2");
        arrayList.add("Item 3");
        arrayList.add("Item 4");
        return arrayList;
    }

    private void setRecyclerView() {
        recycler_view.setHasFixedSize(false);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        itemAdapter = new ItemAdapter(this,getItemData(),this);
        recycler_view.setAdapter(itemAdapter);
    }


    public void goSearchCategoryPage(View view){
        Intent i = new Intent(this,searchCategory.class);
        startActivity(i);
    }

    public void goSearchItemNamePage(View view){

        Intent i = new Intent(this,searchItemName.class);
        i.putExtra("Listname", listName);
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

    @Override
    public void onItemChange(ArrayList<String> arrayList) {

    }
}