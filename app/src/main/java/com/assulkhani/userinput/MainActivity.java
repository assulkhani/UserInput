package com.assulkhani.userinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtSisi;
    Button btnHasil;
    TextView tvHasil;
    Spinner spinnerOption;
    String[] optionHitung = {"Volume", "Keliling", "Luas Permukaan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSisi = findViewById(R.id.txt_sisi);
        btnHasil = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);
        spinnerOption = findViewById(R.id.spinner);

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinnerOption.getSelectedItem().toString().equals(optionHitung[0])){
                    // rumus volume
                    rumusVolume();
                    // ctrl + alt + m (untuk membuat method sendiri)

            } else if (spinnerOption.getSelectedItem().toString().equals(optionHitung[1])){
                    // rumus keliling
                    Double sisi = Double.parseDouble(txtSisi.getText().toString());
                    rumusKeliling(sisi);

                } else if (spinnerOption.getSelectedItem().toString().equals(optionHitung[2])){
                    // rumus luas permukaan
                    Double hasil = rumusPermukaan();
                    tvHasil.setText(hasil.toString());
                }
        }
        });

        // membuat data
        // membuat adapter
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, optionHitung);
        spinnerOption.setAdapter(adapter);
    }

    private Double rumusPermukaan() {
        Double sisi = Double.parseDouble(txtSisi.getText().toString());
        Double hasil = 12 * sisi;
        return hasil;
        // contoh method III
    }

    private void rumusKeliling(Double sisi) {
        Double hasil = 6 * sisi * sisi;
        tvHasil.setText(hasil.toString());
        // contoh method II
    }

    private void rumusVolume() {
        Double sisi = Double.parseDouble(txtSisi.getText().toString());
        Double hasil = sisi * sisi * sisi;
        tvHasil.setText(hasil.toString());
        // contoh method I
    }
}
