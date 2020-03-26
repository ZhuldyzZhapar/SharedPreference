package com.example.myfragment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SecondFragment extends Fragment {
    private SharedPreferenceConfig sharedPreferenceConfig;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.second_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.listRecyclerView);

        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return rootView;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_fragment);
        startActivity(new Intent(this, SecondFragment.class));
    }

    public void Logout(View view) {
        sharedPreferenceConfig.login_status(false);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
