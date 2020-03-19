package my.bytecode.shyammobile.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import my.bytecode.shyammobile.R;

public class SplashScreen extends AppCompatActivity {
	ProgressBar pgsBar;
	private int i = 0;

	private Handler hdlr = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		ActionBar myActionBar = getSupportActionBar();
		myActionBar.hide();
		//getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.backk));
		pgsBar = (ProgressBar) findViewById(R.id.pBar);

		i = pgsBar.getProgress();
		new Thread(new Runnable() {
			public void run() {
				while (i < 100) {
					i += 5;

					hdlr.post(new Runnable() {
						public void run() {
							pgsBar.setProgress(i); }
					});
					try {

						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Intent intent=new Intent(SplashScreen.this,Main2Activity.class);
				startActivity(intent);
			}
		}).start();
	}
}
