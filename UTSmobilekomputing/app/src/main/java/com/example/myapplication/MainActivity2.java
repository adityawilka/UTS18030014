package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView Tmatkul,Tdosen, Tsks, Ttanggal, Tsifat, Tstudi, Tnim, Tnama, Tkelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Tmatkul = (TextView) findViewById(R.id.matkul);
        Tdosen = (TextView) findViewById(R.id.dosen);
        Tsks = (TextView) findViewById(R.id.sks);
//        Tsifat = (TextView) findViewById(R.id.sifat);
        Ttanggal = (TextView) findViewById(R.id.tanggal);
        Tstudi = (TextView) findViewById(R.id.programstudi);
        Tnim = (TextView) findViewById(R.id.tampilnim);
        Tnama = (TextView) findViewById(R.id.nama_mahasiswa);
        Tkelas = (TextView) findViewById(R.id.tampilkelas);
// Menampilkan
        if (getIntent().getStringExtra("matkul") != null) {
            String matkul = getIntent().getStringExtra("matkul");
            String studi = getIntent().getStringExtra("studi");
            String sks = getIntent().getStringExtra("sks");
            String tanggal = getIntent().getStringExtra("tgl");
//            String sifat = getIntent().getStringExtra("sifat");
            String dosen = getIntent().getStringExtra("dosen");
             String nim = getIntent().getStringExtra("nim");
            String namamahasiswa = getIntent().getStringExtra("nama");
            String kelas = getIntent().getStringExtra("kelas");

            Tmatkul.setText("Matakuliah         :  " + matkul);
            Tdosen.setText("Dosen Pengampuh    : " + dosen);
            Tstudi.setText(" PROGRAM STUDI       " + studi);
            Tsks.setText("Jumlah SKS              : " + sks);
            Ttanggal.setText("Tanggal Pelaksanaan : "+ tanggal);
//            Tsifat.setText(":"+ sifat);
            Tnim.setText(""+ nim);
            Tnama.setText(""+ namamahasiswa);
            Tkelas.setText("Kelas                  : "+ kelas);
        }
    }
}