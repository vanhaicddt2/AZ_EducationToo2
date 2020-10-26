package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class Second_Reception_AzService extends AppCompatActivity {

    ImageButton imgbtn_back,imgbtn_home,imgbtnRC_Roten,imgbtnRC_Breafast,imgbtnRC_Laundry,imgbtn_Massage,imgbtn_Other;
    TextView txtimg1,txtimg2,txtimg3,txtimg5,txtimg4,txtimg6,txttitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__reception__az_service);

        Anhxa();

        imgbtnRC_Breafast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Second_Reception_AzService.this,  Reception_Video_List_Activity.class);
                intent.putExtra("Code1","RECEPTiON/SERVICE");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Reception").child("Service").child("Breakfast");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Reception").child("Service").child("Breakfast");  // link để vào
                }
            }
        });

        imgbtnRC_Roten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Reception_AzService.this,  Reception_Video_List_Activity.class);
                intent.putExtra("Code1","RECEPTiON/SERVICE");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Reception").child("Service").child("Roten");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Reception").child("Service").child("Roten");  // link để vào
                }

            }
        });

        imgbtn_Massage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Reception_AzService.this,  Reception_Video_List_Activity.class);
                intent.putExtra("Code1","RECEPTiON/SERVICE");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Reception").child("Service").child("Massage");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Reception").child("Service").child("Massage");  // link để vào
                }
            }
        });

        imgbtnRC_Laundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Reception_AzService.this,  Reception_Video_List_Activity.class);
                intent.putExtra("Code1","RECEPTiON/SERVICE");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Reception").child("Service").child("Laundry");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Reception").child("Service").child("Laundry");  // link để vào
                }
            }
        });

        imgbtn_Other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Reception_AzService.this,  Reception_Video_List_Activity.class);
                intent.putExtra("Code1","RECEPTiON/SERVICE");  // gửi tiêu đề sang List VIdeo
                startActivity(intent);

                if (MainActivity.league =="vni") {
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Reception").child("Service").child("Other");  // link để vào
                }else{
                    MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("English").child("Reception").child("Service").child("Other");  // link để vào
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
                Intent intent = new Intent(Second_Reception_AzService.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //-----------------------------------

        if (MainActivity.league =="vni"){
            txtimg1.setText("ĂN SÁNG");
            txtimg2.setText("ROTENBURO");
            txtimg3.setText("MASSAGE");
            txtimg4.setText("GIẶT LÀ");
            txtimg5.setText("DỊCH VỤ KHÁC");
            txttitle.setText("LỄ TÂN / DỊCH VỤ");

        }else{
            txtimg1.setText("BREAKFAST");
            txtimg2.setText("ROTENBURO");
            txtimg3.setText("MASSAGE");
            txtimg4.setText("LAUNDRY");
            txtimg5.setText("OTHER SERVICE");

            txttitle.setText("RECEPTION / SERVICE");
        }
    }

    private void Anhxa() {
        imgbtn_back = (ImageButton) findViewById(R.id.imageView_RC_Service_Back);
        imgbtn_home= (ImageButton) findViewById(R.id.imageView_RC_Service_Home);

        imgbtnRC_Roten= (ImageButton) findViewById(R.id.imgbnt_reception_Service_Roten);
        imgbtnRC_Breafast= (ImageButton) findViewById(R.id.imgbnt_reception_Service_Breakfast);
        imgbtn_Massage= (ImageButton) findViewById(R.id.imgbnt_reception_Service_Massage);
        imgbtnRC_Laundry= (ImageButton) findViewById(R.id.imgbnt_reception_Service_Laundry);
        imgbtn_Other= (ImageButton) findViewById(R.id.imgbnt_reception_Service_Other);

        txtimg1 = (TextView) findViewById(R.id.textView_RC_Service_Breakfast);
        txtimg2 = (TextView) findViewById(R.id.textView_RC_Service_Roten);
        txtimg3 = (TextView) findViewById(R.id.textView_RC_Service_Massage);
        txtimg4 = (TextView) findViewById(R.id.textView_RC_Service_Laundry);
        txtimg5 = (TextView) findViewById(R.id.textView_RC_Service_Other);
        txttitle= (TextView) findViewById(R.id.textView_Reception_Service_Title);
        
    }
}