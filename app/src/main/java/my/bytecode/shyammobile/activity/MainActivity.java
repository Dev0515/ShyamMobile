package my.bytecode.shyammobile.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import my.bytecode.shyammobile.R;

public class MainActivity extends AppCompatActivity {
	WebView web;
	WebView webView;
	String url="http://shyammobile.com/";
	ProgressDialog pd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar myActionBar = getSupportActionBar();
		myActionBar.hide();
		web=(WebView)findViewById(R.id.web);

		webView = (WebView) findViewById(R.id.web);
		pd = new ProgressDialog(MainActivity.this, R.style.MyTheme);
		pd.setCancelable(false);
		pd.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
		pd.show();
		web.getSettings().setJavaScriptEnabled(true);
		web.getSettings().setLoadsImagesAutomatically(true);
		web.getSettings().setAppCacheEnabled(true);
		web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		web.loadUrl(url);

		web.setWebViewClient(new WebViewClient()
		{
			public void onReceivedError(WebView view,int errorcode,String desc,String fail)
			{

				Log.e("2", "onReceivedError: "+errorcode+"\t"+desc +"\t"+fail);
				Toast.makeText(MainActivity.this, "error page", Toast.LENGTH_SHORT).show();
			}
			public void onPageFinished(WebView view,String url)
			{
				pd.dismiss();// swipe1.setRefreshing(false);
			}
		});
	}
	@Override

	public boolean onKeyDown(final int keyCode, final KeyEvent event) {

		if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
			webView.goBack();
//If there is history, then the canGoBack method will return ‘true’//
			return true;
		}


		return super.onKeyDown(keyCode, event);
	}
}
