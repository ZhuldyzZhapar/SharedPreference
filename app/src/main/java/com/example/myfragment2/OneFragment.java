package com.example.myfragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class OneFragment extends Fragment {
    EditText firstName, lastName;
    Button submitBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.one_fragment, container, false);

        firstName = (EditText) rootView.findViewById(R.id.firstname);
        lastName = (EditText) rootView.findViewById(R.id.lastname);
        submitBtn = (Button) rootView.findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = firstName.getText().toString();
                String last = lastName.getText().toString();


                Bundle bundle = new Bundle();
                bundle.putString("FirstName", first);
                bundle.putString("LastName", last);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.frame_container, secondFragment);
                fragmentTransaction.commit();


            }
        });

        return rootView;

    }
}
