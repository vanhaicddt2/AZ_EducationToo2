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

import java.util.ArrayList;


public class Second_Azuman_Basic extends AppCompatActivity {

    private Handler mHandler = new Handler();
    public static String getvideocode;
    DatabaseReference mData;     // tạo database
    ImageButton imagebtn_Basicstatement,imagebtnChaoHoi,imgback,imghome,imgbtn_nihongo;
    TextView txtimg1,txtimg2,txtimg3;
    ArrayList<String> listsentlinkvideo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__azuman__basic);
        Anhxa();

/*
        mData = FirebaseDatabase.getInstance().getReference();

        mData.child("Hoctap").child("Azuman").child("Basic").child("TacPhong").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                getvideocode = snapshot.getValue().toString();    // lấy dữ liệu từ database về biến
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        }); */

        imagebtn_Basicstatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Second_Azuman_Basic.this, VIdeo_List_Activity.class);
                intent.putExtra("Code1","AZUMAN/SEATEMENT");  // gửi tiêu đề sang List VIdeo

                mToastRunnable.run();
                startActivity(intent);
                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Azuman").child("Basic").child("TacPhong");  // link để vào
                }else{
                MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Azuman").child("Basic").child("TacPhong");  // link để vào
                }
            }
        });

        imagebtnChaoHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman_Basic.this, VIdeo_List_Activity.class);
                intent.putExtra("Code1","AZUMAN/MANNERS");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                   MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Azuman").child("Basic").child("TuyenNgon");  // link để vào
                }else{
                   MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Azuman").child("Basic").child("TuyenNgon");  // link để vào
                }

            }
        });

        imgbtn_nihongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman_Basic.this, VIdeo_List_Activity.class);
                intent.putExtra("Code1","AZUMAN/NIHONGO");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                   MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Azuman").child("Basic").child("TiengNhat");  // link để vào
                }else{
                   MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Azuman").child("Basic").child("TiengNhat");  // link để vào
                }

            }
        });

        if (MainActivity.league =="vni"){
            txtimg1.setText("TUYÊN NGÔN");
            txtimg2.setText("TIẾNG NHẬT");
            txtimg3.setText("TÁC PHONG");
        }else{
            txtimg1.setText("SEATEMENT");
            txtimg2.setText("JAPANESE");
            txtimg3.setText("MANNERS");
        }

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Second_Azuman_Basic.this,Second_Azuman.class);
                startActivity(intent);
            }
        });

        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Second_Azuman_Basic.this,MainActivity.class);
               startActivity(intent);
            }
        });

    }


    private void Anhxa() {
        imagebtn_Basicstatement = (ImageButton ) findViewById(R.id.imgbnt_azuman_basic_Basestatement);
        imagebtnChaoHoi         = (ImageButton) findViewById(R.id.imgbnt_azuman_BaseChaohoi);
        imgbtn_nihongo          = (ImageButton) findViewById(R.id.imgbnt_azuman_Basenihongo);

        imgback                 = (ImageButton) findViewById(R.id.imageView_Basic_Back);
        imghome                 = (ImageButton) findViewById(R.id.imageView_Basic_Home);

        txtimg1                 = (TextView) findViewById(R.id.textView_Azuman_Basic_tuyenngon);
        txtimg2                 = (TextView) findViewById(R.id.textView_Azuman_Basic_nihongo);
        txtimg3                 = (TextView) findViewById(R.id.TextView_Azuman_Basic_tacphong);

    }

    // DELAY
    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() { ;
            mHandler.postDelayed(this, 50000);
        }
    };

}

