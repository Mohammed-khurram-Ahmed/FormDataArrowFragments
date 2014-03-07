package com.example.formdataarrowfragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {
	RadioGroup radioGroupTabs;
	List<Fragment> fList;
	int pos = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		radioGroupTabs = (RadioGroup) findViewById(R.id.radioGroupTabs);
		fList = new ArrayList<Fragment>();
		fList.add(new TabFragment1());
		fList.add(new TabFragment2());
		fList.add(new TabFragment3());
		fList.add(new TabFragment4());
		fList.add(new TabFragment5());

		radioGroupTabs
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {

						int pos = 0;
						if (checkedId == R.id.btn1) {
							pos = 0;
						} else if (checkedId == R.id.btn2) {
							pos = 1;
						} else if (checkedId == R.id.btn3) {
							pos = 2;
						} else if (checkedId == R.id.btn4) {
							pos = 3;
						} else if (checkedId == R.id.btn5) {
							pos = 4;
						}
						selectedItemChange(pos);
					}
				});
		setUI();
	}

	private void setUI() {

		Button btnBack = (Button) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (pos != 0) {
					pos--;
				}
				RadioButton radioButtonTabs = (RadioButton) radioGroupTabs
						.getChildAt(pos);
				radioButtonTabs.setChecked(true);

			}
		});
		Button btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				RadioButton radioButtonTabs = (RadioButton) radioGroupTabs
						.getChildAt(pos);
				radioButtonTabs.setChecked(true);
				if (pos != 4) {
					pos++;
				}
			}
		});

	}

	void selectedItemChange(int position) {
		try {
			setArrowImage(position);
			loadFragment(position);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setArrowImage(int position) {
		if (position == 4) {
			((RadioGroup) radioGroupTabs).getChildAt(0).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(1).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(2).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(3).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(4).setBackgroundResource(
					R.drawable.arrow_tick);
		} else if (position == 3) {
			((RadioGroup) radioGroupTabs).getChildAt(0).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(1).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(2).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(3).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(4).setBackgroundResource(
					R.drawable.arrow_plane);
		} else if (position == 2) {
			((RadioGroup) radioGroupTabs).getChildAt(0).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(1).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(2).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(3).setBackgroundResource(
					R.drawable.arrow_plane);
			((RadioGroup) radioGroupTabs).getChildAt(4).setBackgroundResource(
					R.drawable.arrow_plane);
		} else if (position == 1) {
			((RadioGroup) radioGroupTabs).getChildAt(0).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(1).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(2).setBackgroundResource(
					R.drawable.arrow_plane);
			((RadioGroup) radioGroupTabs).getChildAt(3).setBackgroundResource(
					R.drawable.arrow_plane);
			((RadioGroup) radioGroupTabs).getChildAt(4).setBackgroundResource(
					R.drawable.arrow_plane);
		} else if (position == 0) {
			((RadioGroup) radioGroupTabs).getChildAt(0).setBackgroundResource(
					R.drawable.arrow_round);
			((RadioGroup) radioGroupTabs).getChildAt(1).setBackgroundResource(
					R.drawable.arrow_plane);
			((RadioGroup) radioGroupTabs).getChildAt(2).setBackgroundResource(
					R.drawable.arrow_plane);
			((RadioGroup) radioGroupTabs).getChildAt(3).setBackgroundResource(
					R.drawable.arrow_plane);
			((RadioGroup) radioGroupTabs).getChildAt(4).setBackgroundResource(
					R.drawable.arrow_plane);
		}
	}

	public void loadFragment(int position) {
		replaceFragment(fList.get(position), R.id.HomeFramLayout, position + "");
	}

	public void replaceFragment(Fragment replacementfragment,
			int replaceResourceId, String fragmentStringName) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		// Most Imp here is we clear the all top fragment on each tab change
		fragmentManager.popBackStack(null,
				FragmentManager.POP_BACK_STACK_INCLUSIVE);

		fragmentTransaction.replace(replaceResourceId, replacementfragment,
				fragmentStringName);
		fragmentTransaction.commit();
	}
}
