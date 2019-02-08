package com.concordia.cejv669.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner sp = findViewById(R.id.spinner_tip);
        final TextView tv_result = findViewById(R.id.text_result);
        final EditText edit_amount = findViewById(R.id.edit_price);
        Button b = findViewById(R.id.button);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.valueOf(edit_amount.getText().toString());
                String spinnerValue = sp.getSelectedItem().toString();
                double tipAmount = 0.0;

                switch (spinnerValue){
                    case "Red":
                      tipAmount = 0.25;
                      break;
                    case "Blue":
                        tipAmount = 0.20;
                        break;
                    case "Green":
                        tipAmount = 0.15;
                        break;
                }

                NumberFormat currency = NumberFormat.getCurrencyInstance();
                tv_result.setText(currency.format(amount*(tipAmount + 1)));

            }
        });
    }
}
