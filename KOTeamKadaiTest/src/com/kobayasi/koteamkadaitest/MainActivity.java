package com.kobayasi.koteamkadaitest;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	private WebView varWebView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		varWebView =(WebView)findViewById(R.id.webview);
		varWebView.setWebViewClient(new CustomBrowserClient());
		varWebView.getSettings().setJavaScriptEnabled(true);
	}
	private class CustomBrowserClient extends WebViewClient{
		public boolean shoudOverrideUrlLoading(WebView view,String url){
			view.loadUrl(url);
			return true;
		}
	}
	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);
		menu.add(0,0,0,"急上昇ワード:デイリー");
		menu.add(0,1,1,"Yahoo");
		menu.add(0,2,2,"NHKニュース");
		menu.add(0,3,3,"東京アメッシュ");
		menu.add(0,4,4,"NHKラジオ");
		menu.add(0,5,5,"CNN");
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item){
		super.onOptionsItemSelected(item);
		int iid=item.getItemId();
		switch(iid){
		case 0:
			varWebView.loadUrl("http://searchranking.yahoo.co.jp/burst_ranking/");
			break;
		case 1:
			varWebView.loadUrl("http://www.yahoo.com/");
			break;
		case 2:
			varWebView.loadUrl("http://www.smph.thenews.ne.jp/");
			break;
		case 3:
			varWebView.loadUrl("http://www.tokyo-ame.jwe.or.jp/");
			break;
		case 4:
			varWebView.loadUrl("http://www3.nhk.or.jp/netradio/");
			break;
		case 5:
			varWebView.loadUrl("http://www.cnn.co.jp/m/");
			break;
			default:
				break;
		}
		return true;
	}
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if ((keyCode==KeyEvent.KEYCODE_BACK)&&varWebView.canGoBack()){
			varWebView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode,event);
	}
}
