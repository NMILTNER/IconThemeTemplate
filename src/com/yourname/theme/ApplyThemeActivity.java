package com.yourname.theme;



import com.yourname.theme.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ApplyThemeActivity extends Activity {

	public String pkg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.apply_layout);
	       
        /**
         * Creating all buttons instances
         * */
        // Nova Button
        Button btn_nova = (Button) findViewById(R.id.btn_nova);
         
        // Apex Button
        Button btn_apex = (Button) findViewById(R.id.btn_apex);
         
        // ADW Button
        Button btn_adw = (Button) findViewById(R.id.btn_adw);
         
        // Holo Button
        Button btn_action = (Button) findViewById(R.id.btn_action);
          
        /**
         * Handling all button click events
         * */
       
        // Nova Click Event Handler
      btn_nova.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String pkg = getResources().getString(R.string.pkg);
    	  Intent nova = new Intent("com.teslacoilsw.launcher.APPLY_ICON_THEME");
			nova.setPackage("com.teslacoilsw.launcher");
			nova.putExtra("com.teslacoilsw.launcher.extra.ICON_THEME_TYPE", "GO");
			nova.putExtra("com.teslacoilsw.launcher.extra.ICON_THEME_PACKAGE",
					pkg);
			
			try {
				startActivity(nova);
			} catch (ActivityNotFoundException e) {
				Intent novaMarket = new Intent(Intent.ACTION_VIEW);
				novaMarket.setData(Uri
						.parse("market://details?id=com.teslacoilsw.launcher"));
				startActivity(novaMarket);
				Toast.makeText(ApplyThemeActivity.this, "Can't Find Nova Launcher", Toast.LENGTH_SHORT).show();
				}   
          }
        });  
       // Listening Apex button click
        btn_apex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pkg = getResources().getString(R.string.pkg);
      	  Intent apex = new Intent("com.anddoes.launcher.SET_THEME");
      	  apex.putExtra("com.anddoes.launcher.THEME_PACKAGE_NAME", pkg);
      	  apex.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
  			
  			try {
  				startActivity(apex);
   			} catch (ActivityNotFoundException e) {
  				Intent apexMarket = new Intent(Intent.ACTION_VIEW);
  				apexMarket.setData(Uri
  						.parse("market://details?id=com.anddoes.launcher"));
  				startActivity(apexMarket);
  				Toast.makeText(ApplyThemeActivity.this, "Can't Find Apex Launcher", Toast.LENGTH_SHORT).show();
  				}   
            }
          }); 
        // Listening ADW button click
        btn_adw.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
                String pkg = getResources().getString(R.string.pkg);
            	Intent adw = new Intent("org.adw.launcher.SET_THEME");
				adw.putExtra("org.adw.launcher.theme.NAME",
						pkg);
				try {
					startActivity(Intent.createChooser(adw,
							"activating theme..."));
				} catch (ActivityNotFoundException e) {
	  				Intent adwMarket = new Intent(Intent.ACTION_VIEW);
	  				adwMarket.setData(Uri
	  						.parse("market://details?id=org.adw.launcher"));
	  				startActivity(adwMarket);
	  				Toast.makeText(ApplyThemeActivity.this, "Can't Find ADW Launcher", Toast.LENGTH_SHORT).show();
	  				}   
	            }
	          }); 
        // Listening to Action button click
        btn_action.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
  				Toast.makeText(ApplyThemeActivity.this, "We are working on Action Launcher support. Please apply through Launcher settings.  ", Toast.LENGTH_SHORT).show();
            }
        });
	}

}
