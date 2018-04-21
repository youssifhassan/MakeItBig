package com.udacity.gradle.builditbigger;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidlib.JokeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {

Button button;
    public MainActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View root = inflater.inflate(R.layout.fragment_main, container, false);



        button = root.findViewById(R.id.jokebtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new FetchJoke() {
                    @Override
                    protected void onPostExecute(String s) {
                        Intent intent = new Intent(getActivity(), JokeActivity.class);
                        intent.putExtra("jok",s);

                        startActivity(intent);
                    }
                }.execute();
            }
        });
        return root;
    }

}
