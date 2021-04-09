package edu.qc.seclass.glm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class UpdateQuantity extends AppCompatActivity {

    TextView textview_name_item;
    EditText textview_amount_item;
    ImageButton editQuantity;
    int id;
    String itemName, listName, numberOfQuantity;
  //  ItemsModal itemModal;
    ImageButton deleteSingleItem;
    SQLiteDatabase checkBoxDatabase;
    DBHelpeForCheckboxAndQuantity quantityChanged;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_quantity);
        checkBoxDatabase = new DBHelpeForCheckboxAndQuantity(this).getWritableDatabase();
        quantityChanged = new DBHelpeForCheckboxAndQuantity(UpdateQuantity.this);

        //Intent x= getIntent();
       // itemModal = (ItemsModal) x.getItemsModalExtra("QUANTITY");
       // itemModal = (ItemsModal) x.get
        //ItemsModal itemModal = (ItemsModal) getIntent().getSerializableExtra("Editing");
        ItemsModal quantity = (ItemsModal) getIntent().getExtras().getSerializable("QUANTITY");
        itemName = quantity.getItemName();
        listName = quantity.getList();
        numberOfQuantity = quantity.getAmountOfQuantity();
       // quantity = quantity.getAmountOfQuantity();
        id = quantity.getId();
//        checkbox_item = findViewById(R.id.checkbox_item);
        textview_name_item = findViewById(R.id.textview_name_item);
        textview_amount_item = findViewById(R.id.textview_amount_item);
        editQuantity = findViewById(R.id.editQuantity);
//        editQuantity = findViewById(R.id.editQuantity);
        deleteSingleItem = findViewById(R.id.deleteSingleItem);
        textview_name_item.setText(quantity.getItemName());
       textview_amount_item.setText(quantity.getAmountOfQuantity());

        deleteSingleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm();
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

    public void confirm(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete?");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DBHelpeForCheckboxAndQuantity db = new DBHelpeForCheckboxAndQuantity(UpdateQuantity.this);
                db.deleteOneRow(id);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    public void update(View view){
        String stringName =  textview_name_item.getText().toString();
        String quantity = textview_amount_item.getText().toString();
    }
}