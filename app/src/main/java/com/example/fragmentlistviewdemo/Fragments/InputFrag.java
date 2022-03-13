package com.example.fragmentlistviewdemo.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragmentlistviewdemo.Classes.User;
import com.example.fragmentlistviewdemo.R;

public class InputFrag extends Fragment {

    private static final String TAG = "InputFrag";

    private Context context;
    private View inputFragView;

    private Button btnAdd;

    private EditText etName, etAge, etSalary;


    public InputFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        this.context = context.getApplicationContext();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // The very first method to be called when the fragment has
        // been associated with the activity. This method executes
        // only once during the lifetime of a fragment.

        Log.d(TAG, "onCreate: InputFrag");


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inputFragView = inflater.inflate(R.layout.fragment_input, container, false);

        etName = inputFragView.findViewById(R.id.editTextTextPersonName);
        etAge = inputFragView.findViewById(R.id.etAge);
        etSalary = inputFragView.findViewById(R.id.etSalary);
        btnAdd = inputFragView.findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name, age, salary;

                name = etName.getText().toString().trim();
                age = etAge.getText().toString().trim();
                salary = etSalary.getText().toString().trim();


                if (name.isEmpty() || age.isEmpty() || salary.isEmpty())
                {

                    Toast.makeText(context, "Enter your value", Toast.LENGTH_SHORT).show();
                    return;

                }
                else
                {
                    User user = new User(name, Integer.valueOf(age), Float.valueOf(salary));

                    getFragmentManager()
                            .beginTransaction().replace(R.id.fragmentContainerView, new OutputFrag(user))
                            .addToBackStack(null)
                            .commit();


                }
            }
        });



        return inputFragView;
    }

    @Override
    public void onPause() {
        super.onPause();

        // It indicates that the user is leaving the fragment.
        // System call this method to commit the changes made to the fragment.


        etName.setText(null);
        etAge.setText(null);
        etSalary.setText(null);

    }
}