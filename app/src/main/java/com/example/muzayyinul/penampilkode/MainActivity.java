package com.example.muzayyinul.penampilkode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText inputUrl;
    Button buttonGetSourceCode;
    static TextView textResult;

    ConnectInternetTask connectInternetTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        inputUrl = (EditText) findViewById(R.id.input_url);
        buttonGetSourceCode = (Button) findViewById(R.id.button_get_source_code);
        textResult = (TextView) findViewById(R.id.result);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.protocol_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void getSourceCodeClick(View view) {
        if (inputUrl.getText().toString().isEmpty()) {
            Toast.makeText(this, "URL Kosong", Toast.LENGTH_SHORT).show();
        } else {
            connectInternetTask = new ConnectInternetTask(this);
            connectInternetTask.execute(spinner.getSelectedItem().toString() +
                    inputUrl.getText().toString());
        }
    }
}