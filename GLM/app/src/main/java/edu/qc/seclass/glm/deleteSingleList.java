package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deleteSingleList extends AppCompatActivity implements View.OnClickListener {

    EditText listName;
    Button cancellistdeletion;
    Button saveDeletionList;
    SQLiteDatabase listDatabase;
    DBHelperForList userListdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_single_list);
        cancellistdeletion = findViewById(R.id.cancelDeletetinglist);
        saveDeletionList = findViewById(R.id.confirmDeleteList);
        listName = findViewById(R.id.listName);
        cancellistdeletion.setOnClickListener((View.OnClickListener) this);
        saveDeletionList.setOnClickListener((View.OnClickListener) this);
        listDatabase = new DBHelperForList(this).getWritableDatabase();
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.cancelDeletetinglist) {
            Intent i = new Intent(this, UserLists.class);
            startActivity(i);
        }
        else if (view.getId() == R.id.confirmDeleteList){
            if(listName.getText().toString().length() == 0){
                Toast.makeText(getApplicationContext(), "Please provide the name of the list you are trying to delete", Toast.LENGTH_LONG).show();
            } else if (listName.getText().toString().length() != 0){
                userListdatabase = new DBHelperForList(this);
                userListdatabase.DeleteList (listName.getText().toString());
                Intent i = new Intent(this, UserLists.class);
                startActivity(i);
            }
        }
    }
}