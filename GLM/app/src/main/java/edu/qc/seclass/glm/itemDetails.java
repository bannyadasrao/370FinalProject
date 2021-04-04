package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class itemDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    DBHelper mDBHelper;
    Button enterButton;
    EditText itemName;
    EditText itemCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SQLiteDatabase db = new DBHelper(this).getWritableDatabase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        itemName = (EditText) findViewById(R.id.itemName);
        itemCategory = findViewById(R.id.itemCategory);
        enterButton = (Button) findViewById(R.id.enterButton);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories,
                android.R.layout.simple_spinner_item);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper mDBHelper = new DBHelper(itemDetails.this);
                String nameInput = itemName.getText().toString();
                String categoryInput = itemCategory.getText().toString();
                if (nameInput.length() != 0 && categoryInput.length()!=0) {
                    mDBHelper.insertGroceryItem(nameInput,categoryInput);
                }
                else {
                    Toast.makeText(itemDetails.this,"Empty Input!",Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getItemAtPosition(position).equals("Select Item Category")){
            //do nothing
        }
        else {
            //on selecting a spinner item
            String text = parent.getItemAtPosition(position).toString();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}