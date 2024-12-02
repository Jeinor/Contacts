package com.example.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    static ArrayList<ContactData> contactData = new ArrayList<ContactData>();
    static ListView contactList;

    static ListViewAdapter listViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        contactList = findViewById(R.id.contactList);
        listViewAdapter = new ListViewAdapter(this, R.layout.list_item, contactData);
        contactList.setAdapter(listViewAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null)
        {
           String firstName = arguments.getString("firstName");
           String secondName = arguments.getString("secondName");
           String surname = arguments.getString("surname");
           String phone = arguments.getString("phone");
           String email = arguments.getString("email");

            contactData.add(new ContactData(firstName, secondName, surname, phone, email));
        }
    }


    public static void removeItem(int position)
    {
        contactData.remove(position);
        contactList.setAdapter(listViewAdapter);
    }

    public void startNewActivity(View v)
    {
        Intent intent = new Intent(this, CreatingNewContactActivity.class);
        startActivity(intent);
    }
}