package com.justforthetshirt.nobodycares;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MediaPlayerExample extends Activity implements MediaPlayer.OnCompletionListener{
	 int [] songs;
	 MediaPlayer mediaPlayer;
	 int current_index = 0; 
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.main);

	 songs= new int[] {R.raw.darkkevin,R.raw.kevin1,R.raw.mrchow,R.raw.noah,R.raw.noah2,R.raw.noah3,R.raw.santosh};

	 mediaPlayer = MediaPlayer.create(this, songs[0]);

	 mediaPlayer.setOnCompletionListener(this);

	 mediaPlayer.start();

	 }
	 //@Override
	     public void onCompletion(MediaPlayer mp) {
	         play();

	     }

	  private void play()
	     {
	         current_index = (current_index +1)% 4;
	        // AssetFileDescriptor afd = this.getResources().openRawResourceFd(songs[current_index]);

	         try
	         {   
	             mediaPlayer.reset();
	      //       mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
	             mediaPlayer.prepare();
	             mediaPlayer.start();
//	             afd.close();
	         }
	         catch (IllegalArgumentException e)
	         {
	 //            Log.e(TAG, "Unable to play audio queue do to exception: " + e.getMessage(), e);
	         }
	         catch (IllegalStateException e)
	         {
	   //          Log.e(TAG, "Unable to play audio queue do to exception: " + e.getMessage(), e);
	         }
	         catch (IOException e)
	         {
	       //      Log.e(TAG, "Unable to play audio queue do to exception: " + e.getMessage(), e);
	         }
	     }
	 }

