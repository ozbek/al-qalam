package com.uzislam.alqalam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class startQalam extends Activity {
	
	private Handler aqHandler;
	private ImageView frontSplash;
	private LinearLayout mainView;
	private ImageButton tmpImg;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        frontSplash = (ImageView) findViewById(R.id.splashimage);
        mainView = (LinearLayout) findViewById(R.id.mainview);
        
        tmpImg = (ImageButton) findViewById(R.id.imgBtnQuran);
        tmpImg.setVisibility(View.GONE);
        tmpImg = (ImageButton) findViewById(R.id.imgBtnBukhari);
        tmpImg.setVisibility(View.GONE);
        tmpImg = (ImageButton) findViewById(R.id.imgBtnMuslim);
        tmpImg.setVisibility(View.GONE);
        tmpImg = (ImageButton) findViewById(R.id.imgBtnTirmidi);
        tmpImg.setVisibility(View.GONE);
        tmpImg = (ImageButton) findViewById(R.id.imgBtnAbudovud);
        tmpImg.setVisibility(View.GONE);
        
        aqHandler = new Handler ();
        aqHandler.postDelayed(Splash, 2500);
        
        
    }
    
    private Runnable Splash = new Runnable() {
	 	   public void run() {
	 		frontSplash.setVisibility(View.GONE);
	 		mainView.setBackgroundResource(R.drawable.background) ;
	 		
	 		final ImageButton  imgBtnQuran = (ImageButton) findViewById(R.id.imgBtnQuran);
	 		imgBtnQuran.setVisibility(View.VISIBLE);
	 		imgBtnQuran.setClickable(true);
	 		imgBtnQuran.setOnClickListener(new OnClickListener() {
	    		public void onClick(View v) {
	    			 startActivity(new Intent(startQalam.this, QuranActivity.class));
	    		}
	        });
	        
	        final ImageButton imgBukhari = (ImageButton) findViewById(R.id.imgBtnBukhari);
	        imgBukhari.setVisibility(View.VISIBLE);
	        imgBukhari.setAlpha(80);
	    	
	        
	        final ImageButton imgMuslim = (ImageButton) findViewById(R.id.imgBtnMuslim);
	        imgMuslim.setVisibility(View.VISIBLE);
	        imgMuslim.setAlpha(80);
	    		        
	        final ImageButton imgTirmidi = (ImageButton) findViewById(R.id.imgBtnTirmidi);
	        imgTirmidi.setVisibility(View.VISIBLE);
	        imgTirmidi.setAlpha(80);
	    		        
	        final ImageButton imgAbudavud  = (ImageButton) findViewById(R.id.imgBtnAbudovud);
	        imgAbudavud.setVisibility(View.VISIBLE);
	    	imgAbudavud.setAlpha(80);
	 	   }
	};   
    
}