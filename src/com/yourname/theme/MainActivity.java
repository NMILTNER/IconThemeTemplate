package com.yourname.theme;

import com.yourname.theme.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	public String marketurl; 
	public String share;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
	       
        /**
         * Creating all buttons instances
         * */
        // Apply button
        Button btn_apply = (Button) findViewById(R.id.btn_apply);
         
        // Email button
        Button btn_email = (Button) findViewById(R.id.btn_email);
         
        // Rate button
        Button btn_rate = (Button) findViewById(R.id.btn_rate);
         
        // G+ button
        Button btn_plus = (Button) findViewById(R.id.btn_plus);
         
        // Share button
        Button btn_share = (Button) findViewById(R.id.btn_share);
        
        // Wallpaper button
        Button btn_walls = (Button) findViewById(R.id.btn_walls);
         
         
        /**
         * Handling all button click events
         * */
 


        // Listening to Apply button click
      btn_apply.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
                // Launching Apply Screen
                Intent i = new Intent(getApplicationContext(), ApplyThemeActivity.class);
                startActivity(i);
            }
        });

       // Listening Email button click
        btn_email.setOnClickListener(new View.OnClickListener() {
             
            @Override
                // Launching Email Dev
          public void onClick(View v) {
                	try {
                		Intent emailIntent = new Intent
                				(android.content.Intent.ACTION_SEND);  
                		String aEmailList[] = { 
                				"nmthemes1@gmail.com",
                				"nmthemes1@gmail.com" };    
                		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, 
                				aEmailList);  
                		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, 
                				R.string.app_name);  
                		emailIntent.setType("plain/text");  
                		startActivity(emailIntent);
                	} 
                	catch (RuntimeException email) {
                		email.printStackTrace();
                	}
            }
        });
         
        // Listening Rate button click
        btn_rate.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
                // Go to market Listing
                String marketurl = getResources().getString(R.string.market);
            	Uri uri1 = Uri.parse(marketurl);
            	startActivity(new Intent(Intent.ACTION_VIEW, uri1));

            }
        });
         
        // Listening to GPlus button click
        btn_plus.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
                // Go to G+ Profile
            	Uri uri2 = Uri.parse("https://plus.google.com/103449403248431622195");
            	startActivity(new Intent(Intent.ACTION_VIEW, uri2));
            }
        });
        // Listening to wallpaper button click
        btn_walls.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
                // Launching wallpaper
                Intent i = new Intent(getApplicationContext(), wallpaper.class);
                startActivity(i);
            }
        });
         
        // Listening to Share button click
        btn_share.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
                // Launching Share Intent
                String share = "Check out " + getResources().getString(R.string.app_name) + " " + getResources().getString(R.string.web) + " on the Play Store";
            	Intent sendIntent = new Intent();
            	sendIntent.setAction(Intent.ACTION_SEND);
            	sendIntent.putExtra(Intent.EXTRA_TEXT, share);
            	sendIntent.setType("text/plain");
            	startActivity(sendIntent);

                
            }
        });
         
   
	}

}
