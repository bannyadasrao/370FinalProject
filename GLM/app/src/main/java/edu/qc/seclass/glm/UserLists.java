package edu.qc.seclass.glm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.List;

public class UserLists extends AppCompatActivity {

    private static final String TAG = "UserLists";
    SQLiteDatabase listDatabase;
    SwipeMenuListView userList;
    Button createList;
    List<String> allList;
    DBHelperForList userListdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_lists);

        createList = findViewById(R.id.createList);
        listDatabase = new DBHelperForList(this).getWritableDatabase();
        userList = (SwipeMenuListView) findViewById(R.id.customerList);

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
        userList.setAdapter(userListArrayAdapter);

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem deleteItem = new SwipeMenuItem(getApplicationContext());
                deleteItem.setWidth(170);
                deleteItem.setIcon(R.drawable.trash_bin);
                menu.addMenuItem(deleteItem);
            }
        };

        // set creator
        userList.setMenuCreator(creator);

        userList.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {

                 // complete the delete function here
               String text = userList.getItemAtPosition(position).toString();
               userListdatabase.DeleteList (text);

               stateAtCurrent();

               return false;
            }
        });


        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = userList.getItemAtPosition(position).toString();
                openActivityUserLists(text);
            }
        });
    }

    private void stateAtCurrent() {
        Intent current = new Intent(this,UserLists.class);
        startActivity(current);
    }

    private void openActivityUserLists(String list) {
        Intent i = new Intent(this, MyItems.class);
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

       //deleteselectedlists
       return false;
   }

    public void goMyItemsPage(View view){
        Intent i = new Intent(this,MyItems.class);
        startActivity(i);
    }
}
