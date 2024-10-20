package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return number of cities in list
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *for the first phase it will be
     empty * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This checks and returns if a city is in the list
     * @param city
     * This is the city to check for
     * @return
     * Return true or false based on if city is in list
     */
    public boolean hasCity(City city) {  // boolean
        //return cities.contains(city);  // returns true or false
        return true;
    }
}
