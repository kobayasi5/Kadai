package com.example.dynamic_layout_view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
//ボタンを表示するプログラム

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout linearLayout=new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		setContentView(linearLayout);

		Button button1 = new Button(this);
		button1.setText("OK");
		button1.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		linearLayout.addView(button1);

		Button button2 = new Button(this);
		button2.setText("Cancel");
		button2.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		linearLayout.addView(button2);
	}
}