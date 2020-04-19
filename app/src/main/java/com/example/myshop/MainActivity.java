package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   TextView textView;
   EditText priceEdit,itemsEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.nextActivity);
        priceEdit = findViewById(R.id.priceedit);
        itemsEdit= findViewById(R.id.itemedit);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = itemsEdit.getText().toString();
                String price = priceEdit.getText().toString();

                Intent intent = new Intent(MainActivity.this,list.class);
                Bundle bundle = new Bundle();

                bundle.putString("ITEMS",item);
                bundle.putString("PRICE",price);

                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
