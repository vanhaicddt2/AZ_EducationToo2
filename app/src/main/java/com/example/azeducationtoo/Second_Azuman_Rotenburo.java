package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class Second_Azuman_Rotenburo extends AppCompatActivity {

    ImageButton imgbtnRotenClear,imgbtnRotenCase,imgbtn_back,imgbtn_home;
    TextView txtimg1,txtimg2,txtimg3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__azuman__rotenburo);

        AnhXa();

        imgbtnRotenClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman_Rotenburo.this, VIdeo_List_Activity.class);
                intent.putExtra("Code1","AZUMAN/CLEAR & SETUP");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni"){
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Azuman").child("Rotenburo").child("Clear");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Azuman").child("Rotenburo").child("Clear"); // link để vào
                }
            }
        });

        imgbtnRotenCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman_Rotenburo.this, VIdeo_List_Activity.class);
                intent.putExtra("Code1","AZUMAN/CASE");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni"){
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Azuman").child("Rotenburo").child("Case");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Azuman").child("Rotenburo").child("Case"); // link để vào
                }
            }
        });


        if (MainActivity.league =="vni"){
            txtimg1.setText("VÊ SINH / SẮP XẾP");
            txtimg2.setText("TÌNH HUỐNG");
            //txtimg3.setText("TÁC PHONG");
        }else{
            txtimg1.setText("CLEAR / SETUP  ");
            txtimg2.setText("      CASES");
            // txtimg3.setText("MANNERS");
        }

        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman_Rotenburo.this,Second_Azuman.class);
                startActivity(intent);
            }
        });

        imgbtn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman_Rotenburo.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {

        imgbtnRotenClear  = (ImageButton) findViewById(R.id.imgbnt_azuman_roten_rotenclear);
        imgbtnRotenCase  =  (ImageButton) findViewById(R.id.imgbnt_Azuman_Roten_Case);

        imgbtn_back     =  (ImageButton) findViewById(R.id.imageView_AzumanRotenBack);
        imgbtn_home     =  (ImageButton) findViewById(R.id.imageView_AzumanRotenHome);

        txtimg1         =  (TextView) findViewById(R.id.textView_Azuman_Roten_Rotenclear);
        txtimg2         =  (TextView) findViewById(R.id.textView_Azuman_Roten_Case);
    }
}