package com.example.fragmentlistviewdemo.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentlistviewdemo.Classes.User;
import com.example.fragmentlistviewdemo.R;

public class OutputFrag extends Fragment {

    private Context context;

    private View outputFrag;

    private User userFrag;

    public OutputFrag(User user) {
        // Required empty public constructor

        this.userFrag = user;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        this.context = context;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        outputFrag = inflater.inflate(R.layout.fragment_output, container, false);

        TextView tvName, tvAge, tvSalary;

        tvName = outputFrag.findViewById(R.id.tvName);
        tvAge = outputFrag.findViewById(R.id.tvAge);
        tvSalary = outputFrag.findViewById(R.id.tvSalary);

        tvName.setText(userFrag.getName());
        tvAge.setText(""+userFrag.getAge());
        tvSalary.setText(""+userFrag.getSalary());



        return outputFrag;
    }
}