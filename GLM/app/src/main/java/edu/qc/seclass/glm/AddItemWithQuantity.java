package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddItemWithQuantity extends AppCompatActivity {

   // EditText inputItemName;
    TextView  inputQuantity, inputItemName;
    Button buttonIncrease, buttonDecrease, buttonCancel, buttonConfirm;
    private int amount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_with_quantity);
        Intent i= getIntent();
        String name = i.getStringExtra("itemClicked");
        inputItemName = (TextView)findViewById(R.id.inputItemName);
        inputItemName.setText(name);
        inputQuantity = findViewById(R.id.inputQuantity);
        buttonIncrease = findViewById(R.id.button_increase);
        buttonDecrease = findViewById(R.id.button_decrease);
        buttonCancel = findViewById(R.id.cancel);
        buttonConfirm = findViewById(R.id.confirm);
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName =  name;
                String quantity = inputQuantity.getText().toString();

                if (stringName.length() <= 0 || quantity.length() <= 0) {
                    Toast.makeText(AddItemWithQuantity.this, "Enter name and quantity", Toast.LENGTH_SHORT).show();
                } else {
                    DBHelpeForCheckboxAndQuantity dbHelpeForCheckboxAndQuantity = new DBHelpeForCheckboxAndQuantity(AddItemWithQuantity.this);
                    ItemsModal itemsModal = new ItemsModal(stringName, quantity);
                    dbHelpeForCheckboxAndQuantity.addNameAndQuantity(itemsModal);
                    Toast.makeText(AddItemWithQuantity.this, "Add Successfully", Toast.LENGTH_SHORT).show();

                    finish();
                    startActivity(getIntent());

                    Intent intent = new Intent(AddItemWithQuantity.this, MyItems.class);
                    startActivity(intent);
                }
            }
        });


        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }
        });

        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelStatus();
            }
        });
    }

    private void increase() {
        amount++;
        inputQuantity.setText(String.valueOf(amount));  //turn integer to string
    }

    private void decrease() {
        if(amount > 0) {
            amount--;
            inputQuantity.setText(String.valueOf(amount));
        }
    }

    private void cancelStatus() {
        Intent i = new Intent(this,MyItems.class);
        startActivity(i);
    }
}