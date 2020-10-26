package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class Second_Massage extends AppCompatActivity {

    ImageButton imgbtn_back,imgbtn_home,imageViewMa_Basic,imageViewMa_Thaotac,imageViewMA_Quitrinh;
    TextView txtimg1,txtimg2,txtimg3,txttitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__massage);
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
                Intent intent = new Intent(Second_Massage.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //-----------------------------------

        // -- nut Basic ---

        imageViewMa_Basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Massage.this,Second_Massage_Basic.class);
                startActivity(intent);
            }
        });

        imageViewMa_Thaotac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Massage.this, Massage_Video_List_Activity.class);
                intent.putExtra("Code1","MASSAGE/TECHNIQUE");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Massage").child("KyThuat");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Massage").child("KyThuat");  // link để vào
                }
            }
        });

        imageViewMA_Quitrinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Second_Massage.this, Massage_Video_List_Activity.class);
                intent.putExtra("Code1","MASSAGE/MANUAL");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Massage").child("QuyTrinh");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Massage").child("QuyTrinh");  // link để vào
                }

            }
        });


        if (MainActivity.league =="vni"){
            txtimg1.setText("CƠ BẢN");
            txtimg2.setText("KỸ THUẬT");
            txtimg3.setText("QUI TRÌNH");
            txttitle.setText("MASSAGE");

        }else{
            txtimg1.setText("BASIC  ");
            txtimg2.setText("TECHNIQUE");
            txtimg3.setText("MANUAL");

            txttitle.setText("MASSAGE");
        }

    }

    private void Anhxa() {
        imageViewMa_Basic   = (ImageButton) findViewById(R.id.imgbnt_Massage_Basic);
        imageViewMa_Thaotac   = (ImageButton) findViewById(R.id.imgbnt_Massage_Thaotac);
        imageViewMA_Quitrinh = (ImageButton) findViewById(R.id.imgbnt_Massage_Quitrinh);

        imgbtn_back         = (ImageButton) findViewById(R.id.imageView_Massage_Back);
        imgbtn_home         = (ImageButton) findViewById(R.id.imageView_Massage_Home);

        txtimg1= (TextView) findViewById(R.id.textView_Massage_Basic);
        txtimg2= (TextView) findViewById(R.id.textView_Massage_Thaotac);
        txtimg3= (TextView) findViewById(R.id.textView_Massage_Quitrinh);

        txttitle = (TextView) findViewById(R.id.textView_Massage);



    }
}