package com.example.quiz2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroupType, radioGroupExtras;
    private EditText editTextTime;
    private Button buttonPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupType = findViewById(R.id.radioGroupType);
        radioGroupExtras = findViewById(R.id.radioGroupExtras);
        editTextTime = findViewById(R.id.editTextTime);
        buttonPesan = findViewById(R.id.buttonPesan);

        buttonPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedTypeId = radioGroupType.getCheckedRadioButtonId();
                int selectedExtrasId = radioGroupExtras.getCheckedRadioButtonId();
                RadioButton radioButtonType = findViewById(selectedTypeId);
                RadioButton radioButtonExtras = findViewById(selectedExtrasId);

                if (radioButtonType == null) {
                    Toast.makeText(MainActivity.this, "Pilih jenis PS", Toast.LENGTH_SHORT).show();
                    return;
                }

                String type = radioButtonType.getText().toString();
                String extras = "";
                int time = Integer.parseInt(editTextTime.getText().toString());

                int hargaPS = 0;
                int hargaExtras = 0;

                switch (type) {
                    case "PS5":
                        hargaPS = 10000;
                        break;
                    case "PS4":
                        hargaPS = 8000;
                        break;
                    case "PS3":
                        hargaPS = 5000;
                        break;
                    case "PSVR":
                        hargaPS = 20000;
                        break;
                }

                // Periksa apakah radio button tambahan dipilih
                if (selectedExtrasId != -1 && time <= 2) {
                    extras = radioButtonExtras.getText().toString();
                    switch (extras) {
                        case "Indomie":
                            hargaExtras = 7000;
                            break;
                        case "Mie Ayam":
                            hargaExtras = 10000;
                            break;
                        case "Siomay":
                            hargaExtras = 5000;
                            break;
                    }
                }

                int totalHarga = (hargaPS + hargaExtras) * time;

                Intent intent = new Intent(MainActivity.this, InvoiceActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("extras", extras);
                intent.putExtra("time", time);
                intent.putExtra("totalHarga", totalHarga);
                startActivity(intent);
            }
        });
    }
}
