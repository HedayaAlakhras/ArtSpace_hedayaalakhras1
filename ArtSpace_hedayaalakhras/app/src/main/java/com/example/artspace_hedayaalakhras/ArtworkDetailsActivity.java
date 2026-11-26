package com.example.artspace_hedayaalakhras;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.artspace_hedayaalakhras.databinding.ActivityArtworkDetailsBinding;

public class ArtworkDetailsActivity extends AppCompatActivity {

    private ActivityArtworkDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityArtworkDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        String title = intent.getStringExtra(MainActivity.EXTRA_TITLE);
        String artist = intent.getStringExtra(MainActivity.EXTRA_ARTIST);
        String year = intent.getStringExtra(MainActivity.EXTRA_YEAR);


        String details = "Artwork Title: " + title
                + "\nArtist Name: " + artist
                + "\nCreation Year: " + year;
        binding.tvDetails.setText(details);


        binding.btnVisitWebsite.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://developer.android.com");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

            if (webIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(webIntent);
            } else {
                Toast.makeText(this, "No browser app available", Toast.LENGTH_SHORT).show();
            }
        });


        binding.btnBackMain.setOnClickListener(v -> finish());
    }
}