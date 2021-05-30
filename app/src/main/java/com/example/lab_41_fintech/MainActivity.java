package com.example.lab_41_fintech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvContent;
    ListView lvcur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvContent = findViewById(R.id.tvContent);
    }

    public void onBtnDownloadClick(View view) {
        this.tvContent.setText("Loading...");

        {
            new DataLoader() {
                @Override
                public void onPostExecute(String result) {
                    tvContent.setText("List of currencies");

                    String[]NewList = result.split(";");

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1 ,NewList);
                    lvcur = findViewById(R.id.lvcur);
                    lvcur.setAdapter(arrayAdapter);

                }
            }.execute();
        }
    }
}