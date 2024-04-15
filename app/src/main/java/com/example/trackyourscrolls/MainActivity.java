package com.example.trackyourscrolls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ZoneModel>zoneModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupZoneModel();
        RecyclerView recyclerView = findViewById(R.id.RVZone);
        Zone_Adapter adapter = new Zone_Adapter(this, zoneModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupZoneModel(){
        String[] zoneNames = getResources().getStringArray(R.array.test);

        for (int i = 0; i<zoneNames.length; i++){
            zoneModels.add(new ZoneModel(zoneNames[i]));
        }
    }


}