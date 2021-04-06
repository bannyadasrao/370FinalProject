package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class renamelist extends AppCompatActivity implements View.OnClickListener {
    EditText oldnameOfList;
    EditText newnametext;
    Button cancellistdeletion;
    Button saveDeleteList;
    SQLiteDatabase listDatabase;
    DBHelperForList userListdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renamelist);
        oldnameOfList = findViewById(R.id.oldlistname);
        cancellistdeletion = findViewById(R.id.cancellist);
        saveDeleteList = findViewById(R.id.savedeletelist);
        newnametext = findViewById(R.id.newnametext);
        cancellistdeletion.setOnClickListener((View.OnClickListener) this);
        saveDeleteList.setOnClickListener((View.OnClickListener) this);
        listDatabase = new DBHelperForList(this).getWritableDatabase();
    }

    @Override
    public void onClick(View view) {

        ////
        if (view.getId() == R.id.cancellist) {
            Intent i = new Intent(this, UserLists.class);
            startActivity(i);
        }
        else if (view.getId() == R.id.savedeletelist){
            if(newnametext.getText().toString().length() == 0){
                Toast.makeText(getApplicationContext(), "Please enter the new name of the list", Toast.LENGTH_LONG).show();
            }else if(oldnameOfList.getText().toString().length() == 0){
                Toast.makeText(getApplicationContext(), "Please enter the old name of the list", Toast.LENGTH_LONG).show();
            } else if (newnametext.getText().toString().length() != 0 && oldnameOfList.getText().toString().length() != 0){
                userListdatabase = new DBHelperForList(this);
                userListdatabase.UpdateListName(oldnameOfList.getText().toString(), newnametext.getText().toString());
                Intent i = new Intent(this, UserLists.class);
                startActivity(i);
            }
        }
    }
}
