package com.example.quiz2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class InvoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        String type = getIntent().getStringExtra("type");
        String extras = getIntent().getStringExtra("extras");
        int time = getIntent().getIntExtra("time", 0);
        int totalHarga = getIntent().getIntExtra("totalHarga", 0);

        int hargaType = 0;
        int hargaExtras = 0;

        switch (type) {
            case "PS5":
                hargaType = 10000;
                break;
            case "PS4":
                hargaType = 8000;
                break;
            case "PS3":
                hargaType = 5000;
                break;
            case "PSVR":
                hargaType = 20000;
                break;
        }

        // Menghitung total harga tambahan
        if (!extras.isEmpty()) {
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

        // Menghitung total harga
        int totalHargaType = hargaType * time;
        int totalHargaSemua = totalHargaType + hargaExtras;

        TextView textViewInvoiceTitle = findViewById(R.id.textViewInvoiceTitle);
        TextView textViewType = findViewById(R.id.textViewType);
        TextView textViewExtras = findViewById(R.id.textViewExtras);
        TextView textViewTime = findViewById(R.id.textViewTime);
        TextView textViewTotalHarga = findViewById(R.id.textViewTotalHarga);

        textViewInvoiceTitle.setText("Invoice Rental PS Thanos");
        textViewType.setText("Type: " + type + " (Rp " + hargaType + " per jam)");
        textViewExtras.setText("Tambahan: " + extras + " (Rp " + hargaExtras + ")");
        textViewTime.setText("Waktu: " + time + " jam");
        textViewTotalHarga.setText("Total : Rp " + totalHargaSemua);
    }
}
