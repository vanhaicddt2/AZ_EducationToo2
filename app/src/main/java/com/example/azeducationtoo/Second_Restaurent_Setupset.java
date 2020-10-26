package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class Second_Restaurent_Setupset extends AppCompatActivity {

    ImageButton imgbtn_Set1,imgbtn_Set2,imgbtn_back,imgbtn_home;
    TextView txtimg1,txtimg2,txtimg3,txtimg4,txttitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_restaurent_setupset);

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
                Intent intent = new Intent(Second_Restaurent_Setupset.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //-----------------------------------

        imgbtn_Set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Second_Restaurent_Setupset.this, Restaurent_Video_List_Activity.class);
                intent.putExtra("Code1","RESTAURANT/SETUP SET");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Restaurant").child("Sapxepset").child("Loai1");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Restaurent").child("Sapxepset").child("Loai1");  // link để vào
                }
            }
        });

        imgbtn_Set2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Second_Restaurent_Setupset.this, Restaurent_Video_List_Activity.class);
                intent.putExtra("Code1","RESTAURANT/SETUP SET");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Restaurant").child("Sapxepset").child("Loai2");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Restaurant").child("Sapxepset").child("Loai2");  // link để vào
                }
            }
        });


        if (MainActivity.league =="vni"){
            txtimg1.setText("NHÓM SET 1");
            txtimg2.setText("NHÓM SET 2");
            txttitle.setText("NHÀ HÀNG");

        }else{
            txtimg1.setText("GROUP SET 1");
            txtimg2.setText("GROUP SET 2");

            txttitle.setText("RESTAURENT");
        }
    }

    private void Anhxa() {
        imgbtn_Set1 = (ImageButton) findViewById(R.id.imgbnt_KC_Sapset_Group1);
        imgbtn_Set2 = (ImageButton) findViewById(R.id.imgbnt_KC_Sapset_Group2);

        imgbtn_back         = (ImageButton) findViewById(R.id.imageView_KC_Sapset_Back);
        imgbtn_home         = (ImageButton) findViewById(R.id.imageView_KC_Sapset_Home);

        txtimg1= (TextView) findViewById(R.id.textView_KC_Sapset_Group1);
        txtimg2= (TextView) findViewById(R.id.textView_KC_Sapxep_Group2);

        txttitle = (TextView) findViewById(R.id.textView_KC_Sapset);
    }
}