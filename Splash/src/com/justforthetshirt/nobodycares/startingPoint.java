package com.justforthetshirt.nobodycares;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class startingPoint extends Activity {

	//int counter;
	Button add;
	//TextView display;
	MediaPlayer mp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//counter = 0;
		add = (Button) findViewById(R.id.bAdd);
		//sub = (Button) findViewById(R.id.bSub);
		//display = (TextView) findViewById(R.id.tvDisplay);
		mp = MediaPlayer.create(this, R.raw.voice012);

		add.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				//counter++;
				mp.start();
			//	display.setText("");
			}
		});

		/*
		sub.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				counter--;
				display.setText("Your total is " + counter);

			}
		});
		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_starting_point, menu);
		return true;
	}

}
