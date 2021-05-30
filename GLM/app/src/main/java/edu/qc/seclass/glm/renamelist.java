package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class renamelist extends AppCompatActivity implements View.OnClickListener {

    TextView oldnameOfList;
    EditText newnametext;
    Button cancellistdeletion;
    Button saveDeleteList;
    String listName;
    SQLiteDatabase listDatabase;
    DBHelperForList userListdatabase;
    SQLiteDatabase checkBoxDatabase;
    DBHelpeForCheckboxAndQuantity cbDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent x= getIntent();
        listName = x.getStringExtra("listClicked");
        setContentView(R.layout.activity_renamelist);
        checkBoxDatabase = new DBHelpeForCheckboxAndQuantity(this).getWritableDatabase();
        oldnameOfList = findViewById(R.id.oldlistname);
        oldnameOfList.setText(listName);
        cancellistdeletion = findViewById(R.id.cancellist);
        saveDeleteList = findViewById(R.id.savedeletelist);
        newnametext = findViewById(R.id.newnametext);
        cancellistdeletion.setOnClickListener((View.OnClickListener) this);
        saveDeleteList.setOnClickListener((View.OnClickListener) this);
        listDatabase = new DBHelperForList(this).getWritableDatabase();
    }

    @Override
    public void onClick(View view) {
        userListdatabase = new DBHelperForList(this);
        if (view.getId() == R.id.cancellist) {
            Intent i = new Intent(this, UserLists.class);
            startActivity(i);
        }
        else if (view.getId() == R.id.savedeletelist){
            if(newnametext.getText().toString().length() == 0){
                Toast.makeText(getApplicationContext(), "Please enter the new name of the list.", Toast.LENGTH_LONG).show();
            }else if (userListdatabase.isTheListAlreadyExist(newnametext.getText().toString()) == true){
                Toast.makeText(renamelist.this, " Can't rename. Another list with the same name may exist. ", Toast.LENGTH_LONG).show();
                Intent i = new Intent(this, UserLists.class);
                startActivity(i);
            }
            else if ( userListdatabase.isTheListAlreadyExist(newnametext.getText().toString()) == false ){
                userListdatabase.UpdateListName(oldnameOfList.getText().toString(), newnametext.getText().toString());
                cbDatabase = new DBHelpeForCheckboxAndQuantity(this);
                cbDatabase.UpdateListNameAfterRename(oldnameOfList.getText().toString(),newnametext.getText().toString() );
                Intent i = new Intent(this, UserLists.class);
                startActivity(i);

            }
        }
    }
}
