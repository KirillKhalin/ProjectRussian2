package com.example.projectrussian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goPristavki(View v) {
        Intent intent = new Intent(this, ActivityPristavki.class);
        startActivity(intent);
    }

    public void goGlas(View v) {
        Intent intent = new Intent(this, ActivityGlas.class);
        startActivity(intent);
    }

    public void goNNN(View v) {
        Intent intent = new Intent(this, ActivityNNN.class);
        startActivity(intent);
    }

    public void goSuf(View v) {
        Intent intent = new Intent(this, ActivitySuf.class);
        startActivity(intent);
    }

    public void goSR(View v) {
        Intent intent = new Intent(this, ActivitySR.class);
        startActivity(intent);
    }
}