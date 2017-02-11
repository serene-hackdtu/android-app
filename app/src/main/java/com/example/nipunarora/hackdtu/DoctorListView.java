package com.example.nipunarora.hackdtu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by nipunarora on 11/02/17.
 */
public class DoctorListView extends ArrayAdapter<Doctor> {
    public DoctorListView(Context context,ArrayList<Doctor> doctor_array)
    {
        super(context,0,doctor_array);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }
}
