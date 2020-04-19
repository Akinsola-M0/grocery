package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class list extends AppCompatActivity {

     List<String> shopList;
     ArrayAdapter<String> arrayAdapter;
     ListView listView;
     Bundle bundle;
    String items;
    String price;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        shopList= new ArrayList<>();
        listView = findViewById(R.id.mylist);

        textView = findViewById(R.id.shareButton);

         bundle = getIntent().getExtras();

         items = bundle.getString("ITEMS");

         price = bundle.getString("PRICE");

        String addlist = items + "         " + "# " + price;
        shopList.add("thermacool" + "         " + "# " + "30000");
        shopList.add("fish" + "         " + "# " +"500");
        shopList.add("oranges" + "         " + "# " + "400");
        shopList.add("apples" + "         " + "# " + "750");
        shopList.add("ayo-ola" + "         " + "# " + "2000");
        shopList.add("wheat" + "         " + "# " + "1500");
        shopList.add("garri" + "         " + "# " + "600");
        shopList.add(addlist);



        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,shopList);
        listView.setAdapter(arrayAdapter);

        arrayAdapter.notifyDataSetChanged();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = findViewById(R.id.editText);
                String arr = Arrays.toString(shopList.toArray());
                String recipients = editText.getText().toString();

                String subject = " Groceries List";

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, recipients);
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, arr);
                email.setType("text/plain");
                startActivity(Intent.createChooser(email, "Choose an email client from..."));
            }
        });
    }


}
