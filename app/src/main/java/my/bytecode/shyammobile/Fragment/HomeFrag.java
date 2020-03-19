package my.bytecode.shyammobile.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import my.bytecode.shyammobile.R;
import my.bytecode.shyammobile.activity.MainActivity;

public class HomeFrag extends Fragment {
	WebView web;
	WebView webView;
	String url="http://shyammobile.com/";
	ProgressDialog pd;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_home2, container, false);
	}


	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);


		web = (WebView) view.findViewById(R.id.web);
		pd = new ProgressDialog(getContext(), R.style.MyTheme);
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

				//Log.e("2", "onReceivedError: "+errorcode+"\t"+desc +"\t"+fail);
				Toast.makeText(getContext(), "error page", Toast.LENGTH_SHORT).show();
			}
			public void onPageFinished(WebView view,String url)
			{
				pd.dismiss();// swipe1.setRefreshing(false);
			}
		});

	}
}


