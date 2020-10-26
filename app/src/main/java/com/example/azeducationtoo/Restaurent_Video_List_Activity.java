package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Restaurent_Video_List_Activity extends AppCompatActivity {

    TextView strGetTitleKC;
    ImageButton imgback,imghome;
    String getvideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurent__video__list_);
        AnhXa();

        Intent intent = getIntent(); // lấy ID từ Intent
        getvideo = intent.getStringExtra("Code1");
        strGetTitleKC.setText(getvideo);

        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Restaurent_Video_List_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void AnhXa() {
        strGetTitleKC = (TextView)    findViewById(R.id.textView_KCTitleVideoList);
        imgback           = (ImageButton) findViewById(R.id.imageView_KC_List_Back);
        imghome           = (ImageButton) findViewById(R.id.imageView_KC_List_Home);
    }
}