package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class VIdeo_List_Activity extends AppCompatActivity {

    TextView strGetTitleAzuman;
    ImageButton imgback,imghome;
    String getvideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__azuman__basic__list);

        AnhXa();

        Intent intent = getIntent(); // lấy ID từ Intent
        getvideo = intent.getStringExtra("Code1");
        strGetTitleAzuman.setText(getvideo);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent = new Intent(VIdeo_List_Activity.this,Second_Azuman_Basic.class);
                //startActivity(intent);
                finish();
            }
        });
        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VIdeo_List_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void AnhXa() {
        strGetTitleAzuman = (TextView)    findViewById(R.id.textView_AzumanTitleVideoList);
        imgback           = (ImageButton) findViewById(R.id.imageView_Azuman_List_Back);
        imghome           = (ImageButton) findViewById(R.id.imageView_Azuman_List_Home);
    }

}