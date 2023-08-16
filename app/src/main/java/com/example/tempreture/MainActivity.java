package com.example.tempreture;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTemperature;
    private TextView textViewResult;
    private Button buttonConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTemperature = findViewById(R.id.editTextTemperature);
        textViewResult = findViewById(R.id.textViewResult);
        buttonConvert = findViewById(R.id.buttonConvert);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String temperatureString = editTextTemperature.getText().toString();

        if (!temperatureString.isEmpty()) {
            double temperatureCelsius = Double.parseDouble(temperatureString);
            double temperatureFahrenheit = celsiusToFahrenheit(temperatureCelsius);
            String result = String.format("%.2f °F", temperatureFahrenheit);
            textViewResult.setText(result);
        } else {
            textViewResult.setText("Enter a valid temperature.");
        }
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
}
