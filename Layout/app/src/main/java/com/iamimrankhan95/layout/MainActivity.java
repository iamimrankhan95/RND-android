package com.iamimrankhan95.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static int fadeCount=0;
    protected void fade(View view){
        ImageView imageView = findViewById(R.id.imageView);
        ImageView imageView2 = findViewById(R.id.imageView2);
        fadeCount++;
        if(fadeCount%2==0){
            imageView2.animate().alpha(0f).setDuration(2000);
            imageView.animate().alpha(1f).setDuration(2000);
        }else{
            imageView.animate().alpha(0f).setDuration(2000);
            imageView2.animate().alpha(1f).setDuration(2000);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
