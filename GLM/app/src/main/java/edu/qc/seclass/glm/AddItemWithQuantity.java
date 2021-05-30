package edu.qc.seclass.glm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AddItemWithQuantity extends AppCompatActivity {

    TextView  inputItemName;
    EditText inputQuantity;
    Button buttonCancel, buttonConfirm;
    String listName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_with_quantity);
        Intent x = getIntent();

        name = x.getStringExtra("itemClicked");
        listName = x.getStringExtra("listClicked");

        inputItemName = (TextView)findViewById(R.id.inputItemName);
        inputItemName.setText(name);
        inputQuantity = findViewById(R.id.inputQuantity);
        buttonCancel = findViewById(R.id.cancel);
        buttonConfirm = findViewById(R.id.confirm);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelpeForCheckboxAndQuantity dbHelpeForCheckboxAndQuantity = new DBHelpeForCheckboxAndQuantity(AddItemWithQuantity.this);
                String quantity = inputQuantity.getText().toString();
                ItemsModal itemsModal = new ItemsModal(name, quantity, listName);
                if (name.length() <= 0 || quantity.length() <= 0) {
                    Toast.makeText(AddItemWithQuantity.this, "Enter name and quantity", Toast.LENGTH_SHORT).show();
                } else if (dbHelpeForCheckboxAndQuantity.isItemAlreadyInTheList(itemsModal) == false){
                    dbHelpeForCheckboxAndQuantity.addNameAndQuantity(itemsModal);
                    backToMyItemsPage();
                }
                else{
                    Toast.makeText(AddItemWithQuantity.this, "Item already exists in the list", Toast.LENGTH_SHORT).show();
                    backToMyItemsPage();
                }
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelStatus();
            }
        });
    }

    private void backToMyItemsPage() {
        Intent backitempage = new Intent(this, MyItems.class);
        backitempage.putExtra("listClicked", listName);
        startActivity(backitempage);
    }

    private void cancelStatus() {
        Intent intent = new Intent(this,MyItems.class);
        intent.putExtra("listClicked", listName);
        startActivity(intent);
    }
}