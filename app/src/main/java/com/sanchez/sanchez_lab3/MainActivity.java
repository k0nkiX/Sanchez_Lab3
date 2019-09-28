package com.sanchez.sanchez_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText input1, input2, input3, input4, input5, input6, input7, input8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1 = findViewById(R.id.s1);
        input2 = findViewById(R.id.s2);
        input3 = findViewById(R.id.s3);
        input4 = findViewById(R.id.s4);
        input5 = findViewById(R.id.s5);
        input6 = findViewById(R.id.s6);
        input7 = findViewById(R.id.s7);
        input8 = findViewById(R.id.s8);
    }

    public void writeData(View v) {
        String data1 = input1.getText().toString();
        String data2 = input2.getText().toString();
        String data3 = input3.getText().toString();
        String data4 = input4.getText().toString();
        String data5 = input5.getText().toString();
        String data6 = input6.getText().toString();
        String data7 = input7.getText().toString();
        String data8 = input8.getText().toString();

        FileOutputStream writer = null;
        try {
            writer = openFileOutput("subjects.txt", MODE_PRIVATE);
            writer.write(data1.getBytes());
            writer.write(data2.getBytes());
            writer.write(data3.getBytes());
            writer.write(data4.getBytes());
            writer.write(data5.getBytes());
            writer.write(data6.getBytes());
            writer.write(data7.getBytes());
            writer.write(data8.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error", "File Not Found");
        } catch (IOException e) {
            Log.d("error", "IO Error");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "File Not Found");
            }
        }
        Toast.makeText(this, "Subjects Saved", Toast.LENGTH_LONG).show();
    }

    public void nextPage(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }
}
