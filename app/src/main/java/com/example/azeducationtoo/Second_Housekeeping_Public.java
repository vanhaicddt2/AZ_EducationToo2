package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class Second_Housekeeping_Public extends AppCompatActivity {

    private Handler mHandler = new Handler();
    ImageButton imgbtn_Roten,imgbtn_Lobby,imgbtn_back,imgbtn_home;
    TextView txtimg1,txtimg2,txtimg3,txttitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__housekeeping__public);

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
                Intent intent = new Intent(Second_Housekeeping_Public.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //-----------------------------------

        imgbtn_Lobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Housekeeping_Public.this,Housekeeping_Video_List_Activity.class);
                intent.putExtra("Code1","HOUSEKEEPING/PUBLIC");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Housekeeping").child("Public").child("Lobby");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Housekeeping").child("Public").child("Lobby");  // link để vào
                }
            }
        });

        imgbtn_Roten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Housekeeping_Public.this,Housekeeping_Video_List_Activity.class);
                intent.putExtra("Code1","HOUSEKEEPING/PUBLIC");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Housekeeping").child("Public").child("Rotenburo");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Housekeeping").child("Public").child("Rotenburo");  // link để vào
                }
            }
        });


        if (MainActivity.league =="vni"){
            txtimg1.setText("V.SINH SẢNH");
            txtimg2.setText("ROTENBURO");
            txttitle.setText("BUỒNG PHÒNG");
        }else{
            txtimg1.setText("    LOBBY");
            txtimg2.setText("ROTENBURO");
            txttitle.setText("HOUSEKEEPING");
        }
    }

    private void Anhxa() {

        imgbtn_Roten    = (ImageButton) findViewById(R.id.imgbnt_HK_Public_Roten);
        imgbtn_Lobby = (ImageButton) findViewById(R.id.imgbnt_HK_Public_Lobby);
       // imgbtn_Chaohoi   = (ImageButton) findViewById(R.id.imgbnt_HK_BaseChaohoi);

        imgbtn_back      = (ImageButton) findViewById(R.id.imagebtn_HK_Public_Back);
        imgbtn_home      = (ImageButton) findViewById(R.id.imagebtn_HK_Public_Home);

        txtimg1          = (TextView) findViewById(R.id.textView_HK_Public_Lobby);
        txtimg2          = (TextView) findViewById(R.id.textView_HK_Public_Roten);
        txttitle         = (TextView) findViewById(R.id.textView_HK_Public_Title);

    }
}