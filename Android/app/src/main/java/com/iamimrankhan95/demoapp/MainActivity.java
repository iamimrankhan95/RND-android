package com.iamimrankhan95.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected void buttonClicked(View view){
        EditText myEditText= findViewById(R.id.myEditText);
        EditText myEditText2= findViewById(R.id.editText2);
        Toast.makeText(MainActivity.this,"Successfully Logged In",Toast.LENGTH_SHORT).show();
        Log.i("username",   myEditText.getText().toString());
        Log.i("password",   myEditText2.getText().toString());
    }
    protected void next(View view){
        ImageView myImage=findViewById(R.id.imageView);
        myImage.setImageResource(R.drawable.image);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
