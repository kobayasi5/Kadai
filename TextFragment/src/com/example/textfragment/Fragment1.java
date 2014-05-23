package com.example.textfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment1 extends Fragment{
	EditText editText1;
	Button okButton;
	TextView textView1;

	@Override
	public View onCreateView(
			LayoutInflater inflater,
			ViewGroup container,
			Bundle savedInstanceState){
		return inflater.inflate(R.layout.fragment1,container, false);
		}

	@Override
	public void onStart(){
		super.onStart();
		findViews();

		okButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				textView1.setText(editText1.getText());
			}
		});
	}
	protected void findViews(){
		editText1 = (EditText)getActivity().findViewById(R.id.editText1);
		okButton = (Button)getActivity().findViewById(R.id.okButton);
		textView1 = (TextView)getActivity().findViewById(R.id.TextView1);
	}
}