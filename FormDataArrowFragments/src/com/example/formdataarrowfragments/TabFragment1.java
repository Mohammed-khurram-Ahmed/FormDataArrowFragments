package com.example.formdataarrowfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment1 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.e("Tab1", "onCreateView");
		View rootView = inflater.inflate(R.layout.tab1, container, false);
		return rootView;
	}

}
