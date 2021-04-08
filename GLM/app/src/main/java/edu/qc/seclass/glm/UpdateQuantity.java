package edu.qc.seclass.glm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class UpdateQuantity extends AppCompatActivity {

    TextView textview_name_item;
    EditText textview_amount_item;
    int id;

    ImageButton deleteSingleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_quantity);

        ItemsModal quantity = (ItemsModal) getIntent().getExtras().getSerializable("QUANTITY");

        id = quantity.getId();
//        checkbox_item = findViewById(R.id.checkbox_item);
        textview_name_item = findViewById(R.id.textview_name_item);
        textview_amount_item = findViewById(R.id.textview_amount_item);
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