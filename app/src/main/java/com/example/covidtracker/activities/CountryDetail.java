package com.example.covidtracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.example.covidtracker.R;
import com.example.covidtracker.adapter.PrecautionsAdapter;
import com.example.covidtracker.model.Country;

public class CountryDetail extends AppCompatActivity {

    TextView tvDetailCountryName, tvDetailTotalCases, tvDetailTodayCases, tvDetailTotalDeaths,
            tvDetailTodayDeaths, tvDetailTotalRecovered, tvDetailTotalActive, tvDetailTotalCritical;
    private SkeletonScreen skeletonScreen1, skeletonScreen2, skeletonScreen3, skeletonScreen4;
    private LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        getSupportActionBar().setTitle("COVID 19");
        tvDetailCountryName = findViewById(R.id.detail_country_name);
        tvDetailTotalCases = findViewById(R.id.detail_total_cases);
        tvDetailTodayCases = findViewById(R.id.detail_today_cases);
        tvDetailTotalDeaths = findViewById(R.id.detail_total_deaths);
        tvDetailTodayDeaths = findViewById(R.id.detail_today_deaths);
        tvDetailTotalRecovered = findViewById(R.id.detail_total_recovered);
        tvDetailTotalActive = findViewById(R.id.detail_total_active);
        tvDetailTotalCritical = findViewById(R.id.detail_total_critical);

        linearLayout1 = findViewById(R.id.linear_layout_1);
        linearLayout2 = findViewById(R.id.linear_layout_2);
        linearLayout3 = findViewById(R.id.linear_layout_3);
        linearLayout4 = findViewById(R.id.linear_layout_4);

        final Country covidCountry = getIntent().getParcelableExtra("EXTRA_COVID");
        tvDetailCountryName.setText(covidCountry.getmCovidCountry());

        skeletonScreen1 = Skeleton.bind(linearLayout1)
                .shimmer(true)
                .angle(20)
                .duration(1200)
                .load(R.layout.skeleton_list_item_1)
                .show();
        skeletonScreen2 = Skeleton.bind(linearLayout2)
                .shimmer(true)
                .angle(20)
                .duration(1200)
                .load(R.layout.skeleton_list_item_1)
                .show();
        skeletonScreen3 = Skeleton.bind(linearLayout3)
                .shimmer(true)
                .angle(20)
                .duration(1200)
                .load(R.layout.skeleton_list_item_2)
                .show();
        skeletonScreen4 = Skeleton.bind(linearLayout4)
                .shimmer(true)
                .angle(20)
                .duration(1200)
                .load(R.layout.skeleton_list_item_1)
                .show();


        Runnable mRunnable;
        Handler mHandler = new Handler();

        mRunnable = new Runnable() {

            @Override
            public void run() {

                skeletonScreen1.hide();
                skeletonScreen2.hide();
                skeletonScreen3.hide();
                skeletonScreen4.hide();
                // set text view
                tvDetailTotalCases.setText(Integer.toString(covidCountry.getmCases()));
                tvDetailTodayCases.setText(covidCountry.getmTodayCases());
                tvDetailTotalDeaths.setText(covidCountry.getmDeaths());
                tvDetailTodayDeaths.setText(covidCountry.getmTodayDeaths());
                tvDetailTotalRecovered.setText(covidCountry.getmRecovered());
                tvDetailTotalActive.setText(covidCountry.getmActive());
                tvDetailTotalCritical.setText(covidCountry.getmCritical());
            }
        };

        mHandler.postDelayed(mRunnable, 1300);

    }
}