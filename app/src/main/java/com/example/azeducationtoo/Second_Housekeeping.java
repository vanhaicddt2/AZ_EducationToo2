package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class Second_Housekeeping extends AppCompatActivity {

    ImageButton imgbtn_back,imgbtn_home,imageViewHK_Basic,imageViewHK_Public,imageViewHK_Makeroom,imgbtn_quytrinh,imgbtn_quydinh,imgbtn_other;
    TextView txtimg1,txtimg2,txtimg3,txtimg4,txtimg5,txtimg6,txttitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__housekeeping);

        Anhxa();

        //-----------  nút hệ thống --------------
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgbtn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Housekeeping.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //-----------------------------------

        imageViewHK_Basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Housekeeping.this,Second_Housekeeping_Basic.class);
                startActivity(intent);
            }
        });

        imageViewHK_Public.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Housekeeping.this,Second_Housekeeping_Public.class);
                startActivity(intent);
            }
        });

        imageViewHK_Makeroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imageViewHK_Makeroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Housekeeping.this,Housekeeping_Video_List_Activity.class);
                intent.putExtra("Code1","HOUSEKEEPING/MAKE ROOM");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Housekeeping").child("MakeRoom");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Housekeeping").child("MakeRoom");  // link để vào
                }
            }
        });

        imgbtn_quydinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Housekeeping.this,Housekeeping_Video_List_Activity.class);
                intent.putExtra("Code1","HOUSEKEEPING/RULES");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Housekeeping").child("Rules");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Housekeeping").child("Rules");  // link để vào
                }
            }
        });

        imgbtn_quytrinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Housekeeping.this,Housekeeping_Video_List_Activity.class);
                intent.putExtra("Code1","HOUSEKEEPING/OTHER MANUAL");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Housekeeping").child("OtherManual");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Housekeeping").child("OtherManual");  // link để vào
                }

            }
        });

        imgbtn_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Housekeeping.this,Housekeeping_Video_List_Activity.class);
                intent.putExtra("Code1","HOUSEKEEPING/OTHER");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Housekeeping").child("Other");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Housekeeping").child("Other");  // link để vào
                }

            }
        });
        if (MainActivity.league =="vni"){
            txtimg1.setText("CƠ BẢN");
            txtimg2.setText("CÔNG CỘNG");
            txtimg3.setText("DỌN PHÒNG");
            txtimg4.setText("QUY TRÌNH KHÁC");
            txtimg5.setText("QUY ĐỊNH");
            txtimg6.setText("VẤN ĐỀ KHÁC");

            txttitle.setText("BUỒNG PHÒNG");

        }else{
            txtimg1.setText("BASIC");
            txtimg2.setText("PUBLIC");
            txtimg3.setText("MAKE ROOM");
            txtimg4.setText("OTHER MANUAL");
            txtimg5.setText("RULES");
            txtimg6.setText("OTHER");

            txttitle.setText("HOUSEKEEPING");
        }

    }

    private void Anhxa() {
        imageViewHK_Basic    = (ImageButton) findViewById(R.id.imgbnt_HK_basic);
        imageViewHK_Public   = (ImageButton) findViewById(R.id.imgbnt_HK_Public);
        imageViewHK_Makeroom = (ImageButton) findViewById(R.id.imgbnt_HK_Makeroom);
        imgbtn_quydinh       = (ImageButton) findViewById(R.id.imgbnt_HK_Quydinh);
        imgbtn_quytrinh      = (ImageButton) findViewById(R.id.imgbnt_HK_Quitrinh);
        imgbtn_other         = (ImageButton) findViewById(R.id.imgbnt_HK_Other);

        imgbtn_back          = (ImageButton) findViewById(R.id.imageView_HK_Back);
        imgbtn_home          = (ImageButton) findViewById(R.id.imageView_HK_Home);

        txtimg1              = (TextView) findViewById(R.id.textView_HK_Basic);
        txtimg2              = (TextView) findViewById(R.id.textView_HK_Public);
        txtimg3              = (TextView) findViewById(R.id.textView_HK_Makeroom);
        txtimg4              = (TextView) findViewById(R.id.textView_HK_Quitrinh);
        txtimg5              = (TextView) findViewById(R.id.textView_HK_Quydinh);
        txtimg6              = (TextView) findViewById(R.id.textview_HK_Other);

        txttitle             = (TextView) findViewById(R.id.textView_HK);

    }
}