package com.example.samplea;

import com.squareup.picasso.Picasso;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class thirdFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    ImageView imageView1;

    // newInstance constructor for creating fragment with arguments
    public static thirdFragment newInstance(int page, String title) {
        thirdFragment fragmentFirst = new thirdFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
        tvLabel.setText(page + " -- " + title);
        imageView1 = (ImageView)view.findViewById(R.id.imageView1);
        Picasso.with(getActivity()).load("http://i.imgur.com/DvpvklR.png").into(imageView1);
        return view;
    }
}