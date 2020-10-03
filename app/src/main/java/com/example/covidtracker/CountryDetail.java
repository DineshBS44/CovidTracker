package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.covidtracker.model.Country;

public class CountryDetail extends AppCompatActivity {

    TextView tvDetailCountryName, tvDetailTotalCases, tvDetailTodayCases, tvDetailTotalDeaths,
            tvDetailTodayDeaths, tvDetailTotalRecovered, tvDetailTotalActive, tvDetailTotalCritical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        // call view
        tvDetailCountryName = findViewById(R.id.detail_country_name);
        tvDetailTotalCases = findViewById(R.id.detail_total_cases);
        tvDetailTodayCases = findViewById(R.id.detail_today_cases);
        tvDetailTotalDeaths = findViewById(R.id.detail_total_deaths);
        tvDetailTodayDeaths = findViewById(R.id.detail_today_deaths);
        tvDetailTotalRecovered = findViewById(R.id.detail_total_recovered);
        tvDetailTotalActive = findViewById(R.id.detail_total_active);
        tvDetailTotalCritical = findViewById(R.id.detail_total_critical);


        // call Country model class
        Country covidCountry = getIntent().getParcelableExtra("EXTRA_COVID");

        // set text view
        tvDetailCountryName.setText(covidCountry.getmCovidCountry());
        tvDetailTotalCases.setText(Integer.toString(covidCountry.getmCases()));
        tvDetailTodayCases.setText(covidCountry.getmTodayCases());
        tvDetailTotalDeaths.setText(covidCountry.getmDeaths());
        tvDetailTodayDeaths.setText(covidCountry.getmTodayDeaths());
        tvDetailTotalRecovered.setText(covidCountry.getmRecovered());
        tvDetailTotalActive.setText(covidCountry.getmActive());
        tvDetailTotalCritical.setText(covidCountry.getmCritical());

    }
}