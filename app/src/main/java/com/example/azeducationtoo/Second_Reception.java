package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class Second_Reception extends AppCompatActivity {

    ImageButton imgbtn_back,imgbtn_home,imageViewRC_Basic,imageViewRC_Inout,imageViewRC_Service,imgbtn_quytrinh,imgbtn_quydinh,imgbtn_other;
    TextView txtimg1,txtimg2,txtimg3,txtimg4,txtimg5,txtimg6,txttitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__reception);
        
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
                Intent intent = new Intent(Second_Reception.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //-----------------------------------

        // -- nut Basic ---
        imageViewRC_Basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Reception.this,Second_Reception_Basic.class);
                startActivity(intent);
            }
        });

        imageViewRC_Inout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Reception.this,Second_Reception_Checkinout.class);
                startActivity(intent);
            }
        });

        imageViewRC_Service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Reception.this,Second_Reception_AzService.class);
                startActivity(intent);
            }
        });

        imgbtn_quydinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Reception.this,Reception_Video_List_Activity.class);
                intent.putExtra("Code1","RECEPTION/RULES");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Reception").child("Rules");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Reception").child("Rules");  // link để vào
                }
            }
        });

        imgbtn_quytrinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Reception.this,Reception_Video_List_Activity.class);
                intent.putExtra("Code1","RECEPTION/OTHER MANUAL");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Reception").child("OtherManual");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Reception").child("OtherManual");  // link để vào
                }

            }
        });

        imgbtn_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Reception.this,Reception_Video_List_Activity.class);
                intent.putExtra("Code1","RECEPTION/OTHER");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Reception").child("Other");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Reception").child("Other");  // link để vào
                }

            }
        });

        if (MainActivity.league =="vni"){
            txtimg1.setText("CƠ BẢN");
            txtimg2.setText("CHECK IN / OUT");
            txtimg3.setText("DỊCH VỤ");
            txtimg4.setText("QUY TRÌNH KHÁC");
            txtimg5.setText("QUY ĐỊNH");
            txtimg6.setText("VẤN ĐỀ KHÁC");

            txttitle.setText("LỄ TÂN");

        }else{
            txtimg1.setText("BASIC  ");
            txtimg2.setText("CHECK IN / OUT");
            txtimg3.setText("SERVICE");
            txtimg5.setText("RULES");
            txtimg6.setText("OTHER");

            txttitle.setText("RECEPTION");
        }

    }

    private void Anhxa() {
        imageViewRC_Basic    = (ImageButton) findViewById(R.id.imgbnt_reception_basic);
        imageViewRC_Inout    = (ImageButton) findViewById(R.id.imgbnt_reception_inout);
        imageViewRC_Service  = (ImageButton) findViewById(R.id.imgbnt_reception_service);
        imgbtn_quydinh       = (ImageButton) findViewById(R.id.imgbnt_Reception_Quydinh);
        imgbtn_quytrinh      = (ImageButton) findViewById(R.id.imgbnt_Reception_Quitrinh);
        imgbtn_other         = (ImageButton) findViewById(R.id.imgbnt_Reception_Other);

        imgbtn_back          = (ImageButton) findViewById(R.id.imageView_RC_Back);
        imgbtn_home          = (ImageButton) findViewById(R.id.imageView_RC_Home);

        txtimg1              = (TextView) findViewById(R.id.textView_RC_Basic);
        txtimg2              = (TextView) findViewById(R.id.textView_RC_Inout);
        txtimg3              = (TextView) findViewById(R.id.textView_RC_Service);
        txtimg4              = (TextView) findViewById(R.id.textView_Reception_Quitrinh);
        txtimg5              = (TextView) findViewById(R.id.textView_Reception_Quydinh);
        txtimg6              = (TextView) findViewById(R.id.textview_Reception_Other);

        txttitle = (TextView) findViewById(R.id.textView_Reception);



    }
}