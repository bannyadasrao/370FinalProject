package edu.qc.seclass.glm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class UserLists extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText listName;
    private Button cancel, save;
    SQLiteDatabase listDatabase;
    ListView userList;
    RecyclerView mylistsRecycle;
    Button createList;
    List<String> allList;
    DBHelperForList userListdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_lists);
        //mylistsRecycle = findViewById(R.id.myitemsRecycle);
        createList = findViewById(R.id.createList);
        listDatabase = new DBHelperForList(this).getWritableDatabase();
        userList = findViewById(R.id.customerList);
      //  userList = findViewById(R.id.myitemsRecycle);
       createList.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
               Intent i = new Intent(UserLists.this,createLists.class);
               startActivity(i);
            }
        });

    }
    public void onStart() {
        super.onStart();
         userListdatabase = new DBHelperForList(UserLists.this);
         allList = userListdatabase.getAllList();
        ArrayAdapter userListArrayAdapter = new ArrayAdapter <String> (UserLists.this, android.R.layout.simple_list_item_1, allList);
      //  userList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        userList.setAdapter(userListArrayAdapter);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = userList.getItemAtPosition(position).toString();
                openActivityUserLists(text);

            }
        });
        }

    private void openActivityUserLists(String list) {
        Intent i = new Intent(this, MyItems.class);
        //String text = userList.getItemAtPosition(Position).toString();
       // Intent i = new Intent(view.getContext(),AddItemWithQuantity.class);
        i.putExtra("listClicked", list);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.listmenu, menu);
        return true;
    }

   public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        if(id == R.id.deletealllists){
            userListdatabase.DeleteAllList();
            onStart();
        }
       if(id == R.id.renameselectedlists){
           Intent i = new Intent(this, renamelist.class);
           startActivity(i);
       }
       if(id == R.id.deletesinglelists){
          Intent i = new Intent(this, deleteSingleList.class);
           startActivity(i);
       }

       //deleteselectedlists

       return false;
   }



   /* public void createNewContactDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.activity_renamelist,null);

        listName = (EditText) contactPopupView.findViewById(R.id.namefornewlist);
        cancel = (Button) contactPopupView.findViewById(R.id.cancellist);
        save = (Button) contactPopupView.findViewById(R.id.savecreatedlist);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //define save button
            }
        });
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //define cancel button
                dialog.dismiss();
            }
        });
    }*/
    public void goMyItemsPage(View view){
        Intent i = new Intent(this,MyItems.class);
        startActivity(i);
    }


}