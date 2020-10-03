package com.example.covidtracker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.covidtracker.R;
import com.example.covidtracker.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> implements Filterable {

    private List<Country> covidCountries;
    private List<Country> covidCountriesFull;

    private Context context;

    public CountryAdapter(List<Country> covidCountries, Context context) {
        this.covidCountries = covidCountries;
        this.context = context;
        covidCountriesFull = new ArrayList<>(covidCountries);
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {
        Country covidCountry = covidCountries.get(position);
        holder.tvTotalCases.setText(Integer.toString(covidCountry.getmCases()));
        holder.tvCountryName.setText(covidCountry.getmCovidCountry());

        // Glide
        Glide.with(context)
                .load(covidCountry.getmFlags())
                .apply(new RequestOptions().override(240, 160))
                .into(holder.imgCountryFlag);
    }

    @Override
    public int getItemCount() {
        return covidCountries.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTotalCases, tvCountryName;
        ImageView imgCountryFlag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTotalCases = itemView.findViewById(R.id.country_cases);
            tvCountryName = itemView.findViewById(R.id.country_name);
            imgCountryFlag = itemView.findViewById(R.id.country_flag);
        }
    }

    @Override
    public Filter getFilter() {
        return covidCountriesFilter;
    }

    private Filter covidCountriesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Country> filteredCovidCountry = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredCovidCountry.addAll(covidCountriesFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Country itemCovidCountry : covidCountriesFull) {
                    if (itemCovidCountry.getmCovidCountry().toLowerCase().contains(filterPattern)) {
                        filteredCovidCountry.add(itemCovidCountry);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredCovidCountry;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            covidCountries.clear();
            covidCountries.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
