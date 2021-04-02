package edu.qc.seclass.glm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
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




      /*  DBHelperForList userListdatabase = new DBHelperForList(UserLists.this);
        allList = userListdatabase.getAllList();
        ArrayAdapter userListArrayAdapter = new ArrayAdapter <String> (UserLists.this, android.R.layout.simple_list_item_1, allList);

        userList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        userList.setAdapter(userListArrayAdapter);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView)view).getText().toString();
                if (allList.contains(selectedItem)){
                    allList.remove(selectedItem); //uncheck item
                }else {
                    allList.add(selectedItem);
                }
            }
        });*/


    }
    public void onStart() {
        super.onStart();
        DBHelperForList userListdatabase = new DBHelperForList(UserLists.this);
         allList = userListdatabase.getAllList();
        ArrayAdapter userListArrayAdapter = new ArrayAdapter <String> (UserLists.this, android.R.layout.simple_list_item_1, allList);
      //  userList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        userList.setAdapter(userListArrayAdapter);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // String selectedItem = ((TextView)view).getText().toString();
               // if (allList.contains(selectedItem)){
                 //   allList.remove(selectedItem); //uncheck item
                //}else {
                  //  allList.add(selectedItem);
                //}

                openActivityUserLists();
            }
        });


        }

    private void openActivityUserLists() {
        Intent i = new Intent(this, MyItems.class);
        startActivity(i);
    }

            /* public void onClick(View view) {
            if (view.getId() == R.id.savecreatedlist) {
                if(namefornewlist.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "Enter the list name", Toast.LENGTH_LONG).show();
                }else{
                    String listName = namefornewlist.getText().toString();
                    DBHelperForList userListdatabase = new DBHelperForList(createLists.this);
                    userListdatabase.insertUserList(listName);
                    openActivityUserLists();

                }
            }
        }
        private void openActivityUserLists() {
            Intent i = new Intent(this, UserLists.class);
            startActivity(i);
        }
        */

  /*  public void showSelectedItems (View view){
        String items = "";
        for (String item: allList){
            items+="-"+item+"\n";
        }
        Toast.makeText(this, "You have selected \n" + items, Toast.LENGTH_LONG).show();
    }*/
       // userList.setAdapter((RecyclerView.Adapter) allList);



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.listmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        if(id == R.id.renameselectedlists){
            createNewContactDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    public void createNewContactDialog(){
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
    }
    public void goMyItemsPage(View view){
        Intent i = new Intent(this,MyItems.class);
        startActivity(i);
    }
}