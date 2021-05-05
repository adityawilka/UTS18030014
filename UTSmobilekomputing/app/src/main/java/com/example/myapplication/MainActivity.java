package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String Inim;
    String Inama_mahasiswa;
    Button submit;
    EditText Inputnim,Inam_mahasiswa, Inputkelas;
    RadioGroup Inputkel;
    RadioButton Radioid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inputnim = (EditText)findViewById(R.id.nim);
        Inam_mahasiswa = (EditText)findViewById(R.id.nama_mahasiswa);
        Inputkel = (RadioGroup)findViewById(R.id.kelas);

        //================================Fungsi Button Kirim============================
        //dikirim ke tampilan2
         submit = (Button)findViewById(R.id.kirim);
        submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Inim = Inputnim.getText().toString();
                Inama_mahasiswa = Inam_mahasiswa.getText().toString();
                int Ikelas = Inputkel.getCheckedRadioButtonId();
                Radioid = findViewById(Ikelas);
                String nilairadio = Radioid.getText().toString();
               //Toast.makeText(MainActivity.this,"nilairadio :"+nilairadio,Toast.LENGTH_LONG).show();

                Intent i = new Intent(MainActivity.this, tampil2.class);
                i.putExtra("nim",Inim);
                i.putExtra("nama",Inama_mahasiswa);
                i.putExtra("kelas",nilairadio);


                startActivity(i);
                finish();
            }
        });



    }
}