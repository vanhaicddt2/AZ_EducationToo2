package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class Second_Restaurent_Cooking extends AppCompatActivity {

    ImageButton imgbtn_Tamago,imgbtn_Miso,imgbtn_Salat,imgbtn_Other,imgbtn_back,imgbtn_home;
    TextView txtimg1,txtimg2,txtimg3,txtimg4,txttitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__restaurent__cooking);

        Anhxa();

        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgbtn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Restaurent_Cooking.this,MainActivity.class);
                startActivity(intent);
            }
        });

        imgbtn_Tamago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Restaurent_Cooking.this, Restaurent_Video_List_Activity.class);
                intent.putExtra("Code1","RESTAURENT/COOKING");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Restaurant").child("Cooking").child("Tamago");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Restaurant").child("Cooking").child("Tamago");  // link để vào
                }
            }
        });

        imgbtn_Miso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Restaurent_Cooking.this, Restaurent_Video_List_Activity.class);
                intent.putExtra("Code1","RESTAURENT/COOKING");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Restaurant").child("Cooking").child("Miso");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Restaurant").child("Cooking").child("Miso");  // link để vào
                }
            }
        });

        imgbtn_Salat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Restaurent_Cooking.this, Restaurent_Video_List_Activity.class);
                intent.putExtra("Code1","RESTAURENT/COOKING");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Restaurant").child("Cooking").child("Salat");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Restaurant").child("Cooking").child("Salat");  // link để vào
                }
            }
        });

        imgbtn_Other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Restaurent_Cooking.this, Restaurent_Video_List_Activity.class);
                intent.putExtra("Code1","RESTAURENT/COOKING");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Restaurant").child("Cooking").child("Other");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Restaurant").child("Cooking").child("Other");  // link để vào
                }
            }
        });

        if (MainActivity.league =="vni"){
            txtimg1.setText("CÁC MÓN TRỨNG");
            txtimg2.setText("MISO/ĐỒ KHO");
            txtimg3.setText("SALAT");
            txtimg4.setText("MÓN KHÁC");

            txttitle.setText("NHÀ HÀNG/CHẾ BIẾN");
        }else{
            txtimg1.setText("EGG COOKING");
            txtimg2.setText("MISO/NIMONO");
            txtimg3.setText("SALAT");
            txtimg4.setText("OTHER COOKING");

            txttitle.setText("RESTAURENT/COOKING");
        }
    }

    private void Anhxa() {
        imgbtn_Tamago = (ImageButton) findViewById(R.id.imgbnt_KC_Cooking_Tamago);
        imgbtn_Miso = (ImageButton) findViewById(R.id.imgbnt_KC_Cooking_Miso);
        imgbtn_Salat = (ImageButton) findViewById(R.id.imgbnt_KC_Cooking_Salat);
        imgbtn_Other = (ImageButton) findViewById(R.id.imgbnt_KC_Cooking_Other);

        imgbtn_back = (ImageButton) findViewById(R.id.imagebtn_KC_Cooking_Back);
        imgbtn_home = (ImageButton) findViewById(R.id.imagebtn_KC_Cooking_Home);

        txtimg1 = (TextView) findViewById(R.id.textView_KC_Cooking_Tamago);
        txtimg2 = (TextView) findViewById(R.id.textView_KC_Cooking_Miso);
        txtimg3 = (TextView) findViewById(R.id.textView_KC_Cooking_Salat);
        txtimg4 = (TextView) findViewById(R.id.textView_KC_Cooking_Other);

        txttitle = (TextView) findViewById(R.id.textView_KC_Cooking_Title);

    }
}