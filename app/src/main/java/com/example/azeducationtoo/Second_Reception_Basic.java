package com.example.azeducationtoo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;

public class Second_Reception_Basic extends AppCompatActivity {

    private Handler mHandler = new Handler();
    ImageButton imgbtn_Basic,imgbtn_Nihongo,imgbtn_Chaohoi,imgbtn_back,imgbtn_home;
    TextView txtimg1,txtimg2,txtimg3,txttitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__reception__basic);

        Anhxa();

        imgbtn_Basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Second_Reception_Basic.this,  Reception_Video_List_Activity.class);
                intent.putExtra("Code1","RECEPTION/BASIC");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Reception").child("Basic").child("TuyenNgon");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Reception").child("Basic").child("TuyenNgon");  // link để vào
                }
            }
        });

        imgbtn_Nihongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Reception_Basic.this,  Reception_Video_List_Activity.class);
                intent.putExtra("Code1","RECEPTION/NIHONGO");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Reception").child("Basic").child("TiengNhat");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Reception").child("Basic").child("TiengNhat");  // link để vào
                }

            }
        });

        imgbtn_Chaohoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Reception_Basic.this, Reception_Video_List_Activity.class);
                intent.putExtra("Code1","RECEPTION/MANNERS");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Reception").child("Basic").child("TacPhong");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Reception").child("Basic").child("TacPhong");  // link để vào
                }
            }
        });

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
                Intent intent = new Intent(Second_Reception_Basic.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //-----------------------------------

        if (MainActivity.league =="vni"){
            txtimg1.setText("TUYÊN NGÔN");
            txtimg2.setText("TIẾNG NHẬT");
            txtimg3.setText("TÁC PHONG");
            txttitle.setText("LỄ TÂN");
        }else{
            txtimg1.setText("SEATEMENT");
            txtimg2.setText("JAPANESE");
            txtimg3.setText("MANNERS");
            txttitle.setText("RECEPTION");
        }
    }

    private void Anhxa() {
        imgbtn_Basic     = (ImageButton) findViewById(R.id.imgbnt_reception_Basestatement);
        imgbtn_Nihongo   = (ImageButton) findViewById(R.id.imgbnt_reception_Basenihongo);
        imgbtn_Chaohoi   = (ImageButton) findViewById(R.id.imgbnt_reception_BaseChaohoi);

        imgbtn_back      = (ImageButton) findViewById(R.id.imagebtn_RC_Basic_Back);
        imgbtn_home      = (ImageButton) findViewById(R.id.imagebtn_RC_Basic_Home);

        txtimg1          = (TextView) findViewById(R.id.textView_RC_Basic_tuyenngon);
        txtimg2          = (TextView) findViewById(R.id.textView_RC_Basic_Nihongo);
        txtimg3          = (TextView) findViewById(R.id.textView_RC_Basic_Chaohoi);
        txttitle         = (TextView) findViewById(R.id.textView_RC_Basic_Title);

    }
}