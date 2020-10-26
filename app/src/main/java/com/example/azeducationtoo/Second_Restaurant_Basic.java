package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class Second_Restaurant_Basic extends AppCompatActivity {

    ImageButton imgbtn_Basic,imgbtn_Nihongo,imgbtn_Chaohoi,imgbtn_back,imgbtn_home;
    TextView txtimg1,txtimg2,txtimg3,txttitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__restaurant__basic);

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
                Intent intent = new Intent(Second_Restaurant_Basic.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //-----------------------------------

        imgbtn_Basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Second_Restaurant_Basic.this,  Restaurent_Video_List_Activity.class);
                intent.putExtra("Code1","RESTAURANT/BASIC");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Restaurant").child("Basic").child("TuyenNgon");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Restaurant").child("Basic").child("TuyenNgon");  // link để vào
                }
            }
        });

        imgbtn_Nihongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Restaurant_Basic.this,  Restaurent_Video_List_Activity.class);
                intent.putExtra("Code1","RESTAURANT/NIHONGO");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Restaurant").child("Basic").child("TiengNhat");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Restaurant").child("Basic").child("TiengNhat");  // link để vào
                }

            }
        });

        imgbtn_Chaohoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Restaurant_Basic.this, Restaurent_Video_List_Activity.class);
                intent.putExtra("Code1","RESTAURANT/MANNERS");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Restaurant").child("Basic").child("TacPhong");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Restaurant").child("Basic").child("TacPhong");  // link để vào
                }
            }
        });

        if (MainActivity.league =="vni"){
            txtimg1.setText("TUYÊN NGÔN");
            txtimg2.setText("TIẾNG NHẬT");
            txtimg3.setText("TÁC PHONG");
            txttitle.setText("NHÀ HÀNG");
        }else{
            txtimg1.setText("SEATEMENT");
            txtimg2.setText("JAPANESE");
            txtimg3.setText("MANNERS");
            txttitle.setText("RESTAURANT");
        }

    }

    private void Anhxa() {
        imgbtn_Basic     = (ImageButton) findViewById(R.id.imgbnt_KC_Basestatement);
        imgbtn_Nihongo   = (ImageButton) findViewById(R.id.imgbnt_KC_Basenihongo);
        imgbtn_Chaohoi   = (ImageButton) findViewById(R.id.imgbnt_KC_BaseChaohoi);

        imgbtn_back      = (ImageButton) findViewById(R.id.imagebtn_KC_Basic_Back);
        imgbtn_home      = (ImageButton) findViewById(R.id.imagebtn_KC_Basic_Home);

        txtimg1          = (TextView) findViewById(R.id.textView_KC_Basic_tuyenngon);
        txtimg2          = (TextView) findViewById(R.id.textView_KC_Basic_Nihongo);
        txtimg3          = (TextView) findViewById(R.id.textView_KC_Basic_Chaohoi);
        txttitle         = (TextView) findViewById(R.id.textView_KC_Basic_Title);

    }
}