package com.example.datamahasiswaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.datamahasiswaapp.adapter.MahasiswaAdapter;
import com.example.datamahasiswaapp.model.Mahasiswa;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    EditText etSearch;
    Button btnCari;

    ArrayList<Mahasiswa> list = new ArrayList<>();
    MahasiswaAdapter adapter;
    RequestQueue requestQueue;

    String BASE_URL = "http://192.168.137.172:3000/api/mahasiswa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        etSearch = findViewById(R.id.etSearch);
        btnCari = findViewById(R.id.btnCari);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MahasiswaAdapter(list);
        recyclerView.setAdapter(adapter);

        requestQueue = Volley.newRequestQueue(this);

        // load awal
        loadData("");

        btnCari.setOnClickListener(v ->
                loadData(etSearch.getText().toString())
        );
    }

    private void loadData(String nama) {
        progressBar.setVisibility(View.VISIBLE);
        list.clear();

        String url = BASE_URL + "?nama=" + nama;

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    progressBar.setVisibility(View.GONE);

                    try {
                        // ambil array "data"
                        JSONArray dataArray = response.getJSONArray("data");

                        if (dataArray.length() == 0) {
                            Toast.makeText(this,
                                    "Data tidak ditemukan",
                                    Toast.LENGTH_SHORT).show();
                        }

                        for (int i = 0; i < dataArray.length(); i++) {
                            JSONObject obj = dataArray.getJSONObject(i);
                            list.add(new Mahasiswa(
                                    obj.getString("id"),
                                    obj.getString("nama"),
                                    obj.getString("nim"),
                                    obj.getString("jurusan")
                            ));
                        }

                        adapter.notifyDataSetChanged();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(this,
                                "Gagal parsing data",
                                Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(this,
                            error.toString(),
                            Toast.LENGTH_LONG).show();
                }
        );

        requestQueue.add(request);
    }
}
