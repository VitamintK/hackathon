package com.justforthetshirt.nobodycares;

import java.io.FileInputStream;
import java.io.IOException;

import android.content.Context;
import java.io.File;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Random;

public class startingPoint extends Activity {
	int[] songs= new int[] {R.raw.darkkevin,R.raw.kevin1,R.raw.mrchow,R.raw.noah,R.raw.noah2,R.raw.noah3,R.raw.santosh};
	/*String[] songz = new String[]{"/Nobody Cares/res/raw/darkkevin",
			"/Nobody Cares/res/raw/kevin1",
			"/Nobody Cares/res/raw/mrchow",
			"/Nobody Cares/res/raw/noah",
			"/Nobody Cares/res/raw/noah2",
			"/Nobody Cares/res/raw/noah3.wav",
			"/Nobody Cares/res/raw/santosh.wav"};*/
	//String mpath = sdcardEnvironment.getExternalStorageDirectory().getAbsolutePath();
	
	int counter;
	Button add;
	//TextView display;
    MediaPlayer[] mp = new MediaPlayer[7];
    Random rand = new Random();
    MediaPlayer curmp = mp[rand.nextInt(7)];
    

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		counter = 0;
		add = (Button) findViewById(R.id.bAdd);
		//sub = (Button) findViewById(R.id.bSub);
		//display = (TextView) findViewById(R.id.tvDisplay);
		for(int i=0;i<7;i++){
			mp[i]=MediaPlayer.create(this, songs[i]);
		}
		
		
	    
		add.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				//counter++;
				//counter = counter%7;
				curmp = mp[rand.nextInt(7)];
				curmp.start();

			//	display.setText("");
			}
		});
		
		for(int i=0;i<7;i++){
		mp[i].setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
			
			public void onCompletion(MediaPlayer medp){
			counter++;
			//counter=counter%7;
		       try {
		    	   //AssetFileDescriptor afd = context.getResources().openRawResourceFd(R.raw.myfile);
		    	   //mp.setDataSource(fd.getFileDescriptor());
		    	   //afd.close();
		    	   
		    	   //File file = new File(songz[counter]);
		    	   //FileInputStream inputStream = new FileInputStream(file);
		    	  // mp.setDataSource(inputStream.getFD());
		    	//   inputStream.close();
				//curmp.setDataSource(songz[counter]);
		    	   curmp = mp[rand.nextInt(7)];
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       /* Prepare the mediaplayer */
		       try {
				curmp.prepare();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       /* start */
		       //curmp.start();
			//mp = MediaPlayer.create(this, songs[counter]);
			
			
			
			}
		});
		}
		

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
