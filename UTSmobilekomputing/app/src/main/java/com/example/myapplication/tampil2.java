package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.os.Bundle;

public class tampil2 extends AppCompatActivity {
    TextView Tnim, Tnama_mahasiswa, Tkelas;
    EditText Imatkul, Isks , Isifat, Istudi, Idosen, Itgl;
    String tampil_nim, tampil_nama_mhsiswa, tampil_kel, tampil_matkul;
    String input_matkul, inputsks, inputtanggal, inputsifat, inputstudi, inputdosen;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    EditText txt_tgl;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil2);
        Tnim = (TextView) findViewById(R.id.nim);
        Tnama_mahasiswa = (TextView) findViewById(R.id.nama_mahasiswa);
        Tkelas = (TextView) findViewById(R.id.kelas);
        Imatkul = (EditText) findViewById(R.id.matakuliah);
        Isks = (EditText) findViewById(R.id.sks);
        txt_tgl = (EditText) findViewById(R.id.txt_tgl);
        Isifat = (EditText) findViewById(R.id.sifat);
        Istudi = (EditText) findViewById(R.id.studi);
        Idosen = (EditText) findViewById(R.id.dosen);


// Menampilkan
        if (getIntent().getStringExtra("nim") != null) {
            String nim = getIntent().getStringExtra("nim");
            String nama = getIntent().getStringExtra("nama");
            String kelas = getIntent().getStringExtra("kelas");
            Tnim.setText("NIM Mahasiswa  :  " + nim);
            Tnama_mahasiswa.setText("Nama Mahasiswa  :  " + nama);
            Tkelas.setText("" + kelas);
        }


// ========================================================== Calender ==========================================================

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        txt_tgl.setOnClickListener(new View.OnClickListener() { 

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(tampil2.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    private void updateLabel() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txt_tgl.setText(sdf.format(myCalendar.getTime()));





        // Fungsi untuk mengseret yang sudah diisikan semua dan dapat mengkosongkan kembali saat menekan button reset
        Button kembali = (Button) findViewById(R.id.reset);
        kembali.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText MATKUL = findViewById(R.id.matakuliah);
                EditText DOSEN = findViewById(R.id.dosen);
                EditText STUDI = findViewById(R.id.studi);
                EditText Sifat = findViewById(R.id.sifat);
                EditText SKS = findViewById(R.id.sks);
                EditText date = findViewById(R.id.txt_tgl);

                MATKUL.setText("");
                DOSEN.setText("");
                STUDI.setText("");
                Sifat.setText("");
                SKS.setText("");
                date.setText("");

            }
        });
        //=========================== Fungsi untuk button submit dan mengirimkan data ke tampilan activity2========================
        submit = (Button)findViewById(R.id.kirim);
        submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                input_matkul = Imatkul.getText().toString();
                inputsks = Isks.getText().toString();
                inputtanggal = txt_tgl.getText().toString();
//                inputsifat = Isifat.getText().toString();
                inputstudi = Istudi.getText().toString();
                inputdosen = Idosen.getText().toString();
                tampil_nim = Tnim.getText().toString();
                tampil_nama_mhsiswa = Tnama_mahasiswa.getText().toString();
                tampil_kel = Tkelas.getText().toString();



                Intent i = new Intent(tampil2.this, MainActivity2.class);
                i.putExtra("matkul",input_matkul);
                i.putExtra("sks",inputsks);
                i.putExtra("tgl",inputtanggal);
//                i.putExtra("sifat",inputsifat);
                i.putExtra("studi",inputstudi);
                i.putExtra("dosen",inputdosen);
                i.putExtra("nim",tampil_nim);
                i.putExtra("nama",tampil_nama_mhsiswa);
                i.putExtra("kelas",tampil_kel);


                startActivity(i);
                finish();
            }
        });
    }
    }
