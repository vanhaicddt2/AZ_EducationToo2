package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class Second_Restaurant extends AppCompatActivity {

    ImageButton imgbtn_back,imgbtn_home,imageViewKC_Basic,imageViewKC_Xepset,imageViewKC_Cooking,imgbtn_quytrinh,imgbtn_quydinh,imgbtn_other;
    TextView txtimg1,txtimg2,txtimg3,txtimg4,txtimg5,txtimg6,txttitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__restaurant);

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
                Intent intent = new Intent(Second_Restaurant.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //-----------------------------------

        imageViewKC_Basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Restaurant.this,Second_Restaurant_Basic.class);
                startActivity(intent);
            }
        });

        imageViewKC_Xepset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Restaurant.this,Second_Restaurent_Setupset.class);
                startActivity(intent);
            }
        });

        imageViewKC_Cooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Restaurant.this,Second_Restaurent_Cooking.class);
                startActivity(intent);
            }
        });

        imgbtn_quydinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Restaurant.this,Restaurent_Video_List_Activity.class);
                intent.putExtra("Code1","AZUMAN/RULES");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Restaurant").child("Rules");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Restaurant").child("Rules");  // link để vào
                }
            }
        });

        imgbtn_quytrinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Restaurant.this,Restaurent_Video_List_Activity.class);
                intent.putExtra("Code1","AZUMAN/OTHER MANUAL");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Restaurant").child("OtherManual");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Restaurant").child("OtherManual");  // link để vào
                }

            }
        });

        imgbtn_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Restaurant.this,Restaurent_Video_List_Activity.class);
                intent.putExtra("Code1","AZUMAN/OTHER");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Restaurant").child("Other");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Restaurant").child("Other");  // link để vào
                }

            }
        });

        if (MainActivity.league =="vni"){
            txtimg1.setText("CƠ BẢN");
            txtimg2.setText("SẮP XẾP SET");
            txtimg3.setText("CHẾ BIẾN");
            txtimg4.setText("QUY TRÌNH KHÁC");
            txtimg5.setText("QUY ĐỊNH");
            txtimg6.setText("VẤN ĐỀ KHÁC");


            txttitle.setText("NHÀ HÀNG");

        }else{
            txtimg1.setText("BASIC");
            txtimg2.setText("SETUP SET");
            txtimg3.setText("COOKING");
            txtimg4.setText("OTHER MANUAL");
            txtimg5.setText("RULES");
            txtimg6.setText("OTHER");

            txttitle.setText("RESTAURENT");
        }

    }

    private void Anhxa() {
        imageViewKC_Basic    = (ImageButton) findViewById(R.id.imgbnt_KC_basic);
        imageViewKC_Xepset   = (ImageButton) findViewById(R.id.imgbnt_KC_Sapxepset);
        imageViewKC_Cooking  = (ImageButton) findViewById(R.id.imgbnt_KC_Chebien);
        imgbtn_quydinh       = (ImageButton) findViewById(R.id.imgbnt_KC_Quydinh);
        imgbtn_quytrinh      = (ImageButton) findViewById(R.id.imgbnt_KC_Quitrinh);
        imgbtn_other         = (ImageButton) findViewById(R.id.imgbnt_KC_Other);

        imgbtn_back          = (ImageButton) findViewById(R.id.imageView_KC_Back);
        imgbtn_home          = (ImageButton) findViewById(R.id.imageView_KC_Home);

        txtimg1              = (TextView) findViewById(R.id.textView_KC_Basic);
        txtimg2              = (TextView) findViewById(R.id.textView_KC_Sapxep);
        txtimg3              = (TextView) findViewById(R.id.textView_KC_Chebien);

        txtimg4              = (TextView) findViewById(R.id.textView_KC_Quitrinh);
        txtimg5              = (TextView) findViewById(R.id.textView_KC_Quydinh);
        txtimg6              = (TextView) findViewById(R.id.textview_KC_Other);


        txttitle = (TextView) findViewById(R.id.textView_KC);

    }
}