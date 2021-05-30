package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class UpdateQuantity extends AppCompatActivity {

    int id;
    TextView textview_name_item;
    EditText textview_amount_item;
    ImageButton editQuantity;

    String itemName, listName, numberOfQuantity;
    ImageButton deleteSingleItem;
    SQLiteDatabase checkBoxDatabase;
    DBHelpeForCheckboxAndQuantity quantityChanged;
    Context context;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_quantity);

        checkBoxDatabase = new DBHelpeForCheckboxAndQuantity(this).getWritableDatabase();
        quantityChanged = new DBHelpeForCheckboxAndQuantity(UpdateQuantity.this);
        context = this;

        Intent x = getIntent();
        listName = x.getStringExtra("listClicked");
        ItemsModal quantity = (ItemsModal) getIntent().getExtras().getSerializable("QUANTITY");
        itemName = quantity.getItemName();

        numberOfQuantity = quantity.getAmountOfQuantity();
        id = quantity.getId();
        textview_name_item = findViewById(R.id.textview_name_item);
        textview_amount_item = findViewById(R.id.textview_amount_item);
        editQuantity = findViewById(R.id.editQuantity);
        deleteSingleItem = findViewById(R.id.deleteSingleItem);
        textview_name_item.setText(quantity.getItemName());
        textview_amount_item.setText(quantity.getAmountOfQuantity());

        deleteSingleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelpeForCheckboxAndQuantity db = new DBHelpeForCheckboxAndQuantity(UpdateQuantity.this);
                db.deleteOneRow(id);
                Intent delete = new Intent(context, MyItems.class);
                delete.putExtra("listClicked",listName );
                context.startActivity(delete);
            }
        });

        editQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String changeAmount = textview_amount_item.getText().toString();
                quantityChanged.updateQuantity(id, changeAmount);
                Intent update = new Intent(context, MyItems.class);
                update.putExtra("listClicked",listName );
                context.startActivity(update);
            }
        });
    }

    public void update(View view){
        String stringName =  textview_name_item.getText().toString();
        String quantity = textview_amount_item.getText().toString();
    }
}