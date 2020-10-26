package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Second_Azuman extends AppCompatActivity {

    private Handler mHandler = new Handler();

    //public static String getvideocode;
    DatabaseReference mData;     // tạo database
    ImageButton imageViewazumanBasic,imageRoten,imgbtn_back,imgbtn_home,imageCheckinout,imgbtn_quytrinh,imgbtn_quydinh,imgbtn_other;
    TextView txtimg1,txtimg2,txtimg3,txtimg4,txtimg5,txtimg6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__azuman);
        Anhxa();

        imageViewazumanBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Second_Azuman.this, Second_Azuman_Basic.class);
                startActivity(intent);
            }
        });

        imageCheckinout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman.this,Second_Azuman_Checkinout.class);
                startActivity(intent);
            }
        });

        imageRoten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman.this,Second_Azuman_Rotenburo.class);
                startActivity(intent);
            }
        });

        imgbtn_quydinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman.this,VIdeo_List_Activity.class);
                intent.putExtra("Code1","AZUMAN/RULES");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Azuman").child("Rules");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Azuman").child("Rules");  // link để vào
                }
            }
        });

        imgbtn_quytrinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman.this,VIdeo_List_Activity.class);
                intent.putExtra("Code1","AZUMAN/OTHER MANUAL");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Azuman").child("OtherManual");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Azuman").child("OtherManual");  // link để vào
                }

            }
        });

        imgbtn_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman.this,VIdeo_List_Activity.class);
                intent.putExtra("Code1","AZUMAN/OTHER");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Azuman").child("Other");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Azuman").child("Other");  // link để vào
                }

            }
        });


        //------------------------------------------
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman.this,MainActivity.class);
                startActivity(intent);
            }
        });

        imgbtn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman.this,MainActivity.class);
                startActivity(intent);
            }
        });

       //------------------------------------------

        if (MainActivity.league =="vni"){
            txtimg1.setText("CƠ BẢN");
            txtimg2.setText("CHECK IN / OUT");
            txtimg3.setText("ROTENBURO");
            txtimg4.setText("QUY TRÌNH KHÁC");
            txtimg5.setText("QUY ĐỊNH");
            txtimg6.setText("VẤN ĐỀ KHÁC");

        }else{
            txtimg1.setText("BASIC");
            txtimg2.setText("CHECK IN / OUT");
            txtimg3.setText("ROTENBURO");
            txtimg4.setText("OTHER MANUAL");
            txtimg5.setText("RULES");
            txtimg6.setText("OTHER");
        }
    }

    private void Anhxa() {
        imageViewazumanBasic = (ImageButton ) findViewById(R.id.imgbnt_azuman_basic);
        imageCheckinout      = (ImageButton) findViewById(R.id.imgbnt_azuman_inout);
        imageRoten           = (ImageButton) findViewById(R.id.imgbnt_azuman_roten);
        imgbtn_quydinh       = (ImageButton) findViewById(R.id.imgbnt_azuman_Quydinh);
        imgbtn_quytrinh      = (ImageButton) findViewById(R.id.imgbnt_azuman_Quitrinh);
        imgbtn_other      = (ImageButton) findViewById(R.id.imgbnt_azuman_Other);

        imgbtn_back          = (ImageButton) findViewById(R.id.imageView_AzumanBack);
        imgbtn_home          = (ImageButton) findViewById(R.id.imageView_AzumanHome);

        txtimg1              = (TextView) findViewById(R.id.textView_Azuman_Tuyenngon);
        txtimg2              = (TextView) findViewById(R.id.textView_Azuman_checkinout);
        txtimg3              = (TextView) findViewById(R.id.textview_Azuman_Roten);

        txtimg4             = (TextView) findViewById(R.id.textView_Azuman_Quitrinh);
        txtimg5              = (TextView) findViewById(R.id.textView_Azuman_Quydinh);
        txtimg6              = (TextView) findViewById(R.id.textview_Azuman_Other);

    }
}

