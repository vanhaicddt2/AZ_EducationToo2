package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class Second_Azuman_Checkinout extends AppCompatActivity {

    ImageButton imgbtn_Checkinout,imgbtn_case,imgbtn_back,imgbtn_home;
    TextView txtimg1,txtimg2,txtimg3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__azuman__checkinout);

        Anhxa();

        imgbtn_case.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman_Checkinout.this, VIdeo_List_Activity.class);
                intent.putExtra("Code1","AZUMAN/INOUT CASE");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Azuman").child("Checkinout").child("Case");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Azuman").child("Checkinout").child("Case");  // link để vào
                }

            }
        });

        imgbtn_Checkinout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Azuman_Checkinout.this, VIdeo_List_Activity.class);
                intent.putExtra("Code1","AZUMAN/INOUT MANUAL");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);
                Toast.makeText(Second_Azuman_Checkinout.this, ""+MainActivity.league, Toast.LENGTH_SHORT).show();

                  if (MainActivity.league =="vni"){
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Azuman").child("Checkinout").child("CheckinoutCon");  // link để vào
                  }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Azuman").child("Checkinout").child("CheckinoutCon");  // link để vào
                  }

            }
        });

        if (MainActivity.league =="vni"){
            txtimg1.setText("QUI TRÌNH IN/OUT");
            txtimg2.setText("TÌNH HUỐNG");
           //txtimg3.setText("TÁC PHONG");
        }else{
            txtimg1.setText("IN/OUT MANUAL");
            txtimg2.setText("CASES");
           // txtimg3.setText("MANNERS");
        }

    imgbtn_back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Second_Azuman_Checkinout.this,Second_Azuman.class);
            startActivity(intent);
        }
    });

        imgbtn_home.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Second_Azuman_Checkinout.this,MainActivity.class);
            startActivity(intent);
        }
    });

    }

    private void Anhxa() {
        imgbtn_Checkinout = (ImageButton) findViewById(R.id.imgbnt_azuman_Checkinout_Checkinout);
        imgbtn_case = (ImageButton) findViewById(R.id.imgbnt_Azuman_Checkinout_Tinhhuong);
        imgbtn_back = (ImageButton) findViewById(R.id.imageView_Checkinout_AzumanBack);
        imgbtn_home = (ImageButton) findViewById(R.id.imageView_Checkinout_AzumanHome);

        txtimg1 = (TextView) findViewById(R.id.textView_Azuman_Checkinout_Checkinout);
        txtimg2 = (TextView) findViewById(R.id.textView_Azuman_Checkinout_Tinhhuong);


    }
}