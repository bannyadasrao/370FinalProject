package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddItemWithQuantity extends AppCompatActivity {
    private SQLiteDatabase mDB;
    public  AdapterForItems mAdapter;
    private EditText mEditTextName;
    private TextView mTextViewAmount;
    private int mAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_with_quantity);

        DBHelpeForCheckboxAndQuantity dbHelper = new DBHelpeForCheckboxAndQuantity(this);
        mDB = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = findViewById(R.id.recyclerviewforitems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AdapterForItems(this,getAllItems());
        recyclerView.setAdapter(mAdapter);

        mEditTextName = findViewById(R.id.inputItemName);
        mTextViewAmount = findViewById(R.id.inputQuantity);

        Button buttonIncrease = findViewById(R.id.button_increase);
        Button buttonDecrease = findViewById(R.id.button_decrease);
        Button buttonCancel = findViewById(R.id.cancel);
        Button buttonConfirm = findViewById(R.id.confirm);

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

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm();
            }
        });
    }

    private void increase() {
        mAmount++;
        mTextViewAmount.setText(String.valueOf(mAmount));  //turn integer to string
    }

    private void decrease() {
        if(mAmount > 0) {
            mAmount--;
            mTextViewAmount.setText(String.valueOf(mAmount));
        }
    }

    private void cancelStatus() {
    }

    private void confirm() {
        if(mEditTextName.getText().toString().trim().length() == 0 || mAmount == 0){
            return ;
        }

        String name = mEditTextName.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GroceryContract.GroceryEntry.COLUMN_NAME,name);
        contentValues.put(GroceryContract.GroceryEntry.COLUMN_AMOUNT,mAmount);

        mDB.insert(GroceryContract.GroceryEntry.TABLE_NAME,null,contentValues);
        mAdapter.swapCursor(getAllItems());
        mEditTextName.getText().clear();
    }

    private Cursor getAllItems(){
        return mDB.query(
                GroceryContract.GroceryEntry.TABLE_NAME, null,null,null,null,null,
                GroceryContract.GroceryEntry.COLUMN_TIMESTAMP + " DESC"
        );
    }
}