package com.example.azeducationtoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnazuman, btnrc, btnhk, btnkc, btnmass ;
    Button btn_vni, btn_eng;
    RadioGroup radiolaunge;
    Button btnxacnhan;
    Integer intArea, intBranch;
    public static  String API_KEY = "AIzaSyANH1piTO66czg_z8yXBD5TI0MwPLiwGKw";

    static DatabaseReference reference;    // khai báo biến toàn cục để chỉ đường link database
    static String league = "vni";  // lưu ngôn ngữ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //#482979  Azumaya Color

        intArea = 0;
        intBranch = 0;

        Anhxa();

         btnazuman.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this,Second_Azuman.class);
                 startActivity(intent);
                }
         });


        btnrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Second_Reception.class);
                startActivity(intent);
            }
        });

        btnhk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Second_Housekeeping.class);
                startActivity(intent);
            }
        });

        btnkc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Second_Restaurant.class);
                startActivity(intent);
            }
        });

        btnmass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Second_Massage.class);
                startActivity(intent);
            }
        });

        btn_eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "English Select", Toast.LENGTH_SHORT).show();
                btn_eng.setEnabled(false);
                btn_vni.setEnabled(true);

                btnkc.setText("RESTAURENT");
                btnhk.setText("HOUSEKEEPING");
                btnrc.setText("RECEPTION");
                league="eng";

            }
        });

        btn_vni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Bạn đã chọn Tiếng Việt", Toast.LENGTH_SHORT).show();
                btn_vni.setEnabled(false);
                btn_eng.setEnabled(true);

                btnkc.setText("NHÀ HÀNG");
                btnhk.setText("BUỒNG PHÒNG");
                btnrc.setText("LỄ TÂN");
                league = "vni";
            }
        });

    }

    public void Anhxa(){
        btnazuman  = (Button) findViewById(R.id.button_azuman);
        btnrc      = (Button) findViewById(R.id.button_rc);
        btnhk      = (Button) findViewById(R.id.button_hk);
        btnkc = (Button) findViewById(R.id.button_kitchen);
        btnmass    = (Button) findViewById(R.id.button_mass);

        btn_eng    = (Button) findViewById(R.id.Button_eng);
        btn_vni    = (Button) findViewById(R.id.Button_vni);

    }
}
