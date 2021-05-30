package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class createLists extends AppCompatActivity implements View.OnClickListener{

    EditText namefornewlist;
    Button savecreatedlist;
    SQLiteDatabase listDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_lists);

        namefornewlist = findViewById(R.id.namefornewlist);
        savecreatedlist = findViewById(R.id.savecreatedlist);
        savecreatedlist.setOnClickListener((View.OnClickListener) this);
        listDatabase = new DBHelperForList(this).getWritableDatabase();

    }

    @Override
    public void onClick(View view) {
        DBHelperForList userListdatabase = new DBHelperForList(createLists.this);
        if (view.getId() == R.id.savecreatedlist) {
            if(namefornewlist.getText().toString().length() == 0){
                Toast.makeText(getApplicationContext(), "Enter the list name. ", Toast.LENGTH_LONG).show();
            }else if (userListdatabase.isTheListAlreadyExist(namefornewlist.getText().toString()) == false){
                String listName = namefornewlist.getText().toString();
                userListdatabase.insertUserList(listName);
                openActivityUserLists();
            }else{
                Toast.makeText(createLists.this, "This List already exists. ", Toast.LENGTH_SHORT).show();
                openActivityUserLists();
            }

        }
    }

    private void openActivityUserLists() {
            Intent i = new Intent(this, UserLists.class);
            startActivity(i);
    }
}
