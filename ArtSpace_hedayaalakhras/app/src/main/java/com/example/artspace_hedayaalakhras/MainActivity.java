package com.example.artspace_hedayaalakhras;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.artspace_hedayaalakhras.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_ARTIST = "extra_artist";
    public static final String EXTRA_YEAR = "extra_year";
    private static final String STATE_INDEX = "state_index";

    private ActivityMainBinding binding;


    private int currentArtwork = 1;


    private String currentTitle = "";
    private String currentArtist = "";
    private String currentYear = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        if (savedInstanceState != null) {
            currentArtwork = savedInstanceState.getInt(STATE_INDEX, 1);
        }


        updateArtwork();


        binding.btnNext.setOnClickListener(v -> {
            if (currentArtwork < 6) {
                currentArtwork++;
                updateArtwork();
            }
        });

        binding.btnPrevious.setOnClickListener(v -> {
            if (currentArtwork > 1) {
                currentArtwork--;
                updateArtwork();
            }
        });

        binding.ivArtwork.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ArtworkDetailsActivity.class);
            intent.putExtra(EXTRA_TITLE, currentTitle);
            intent.putExtra(EXTRA_ARTIST, currentArtist);
            intent.putExtra(EXTRA_YEAR, currentYear);
            startActivity(intent);
        });
    }


    private void updateArtwork() {
        binding.tvCounter.setText(currentArtwork + " / 6");

        if (currentArtwork == 1) {
            binding.ivArtwork.setImageResource(R.drawable.art1);
            currentTitle = "Starry Night Over Gaza";
            currentArtist = "Layla Mansour";
            currentYear = "2022";
        } else if (currentArtwork == 2) {
            binding.ivArtwork.setImageResource(R.drawable.art2);
            currentTitle = "Olive Harvest";
            currentArtist = "Tariq Haddad";
            currentYear = "2021";
        } else if (currentArtwork == 3) {
            binding.ivArtwork.setImageResource(R.drawable.art3);
            currentTitle = "Coastal Breeze";
            currentArtist = "Nadia Salem";
            currentYear = "2023";
        } else if (currentArtwork == 4) {
            binding.ivArtwork.setImageResource(R.drawable.art1);
            currentTitle = "Old City Arch";
            currentArtist = "Omar Khoury";
            currentYear = "2020";
        } else if (currentArtwork == 5) {
            binding.ivArtwork.setImageResource(R.drawable.art5);
            currentTitle = "Sunset Dunes";
            currentArtist = "Salma Nassar";
            currentYear = "2024";
        } else if (currentArtwork == 6) {
            binding.ivArtwork.setImageResource(R.drawable.art6);
            currentTitle = "Harmony in Blue";
            currentArtist = "Yousef Darwish";
            currentYear = "2019";
        }

        binding.tvTitle.setText(currentTitle);
        binding.tvArtistYear.setText(currentArtist + " (" + currentYear + ")");


        binding.btnPrevious.setEnabled(currentArtwork > 1);
        binding.btnNext.setEnabled(currentArtwork < 6);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_INDEX, currentArtwork);
    }
}