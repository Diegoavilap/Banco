package com.example.banco;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void Fun_cajero(View v){
		
		
		Intent i = new Intent();
		i.setClass(MainActivity.this, Cajero.class);
		startActivity(i);
	}
	public void Fun_cajero2(View v){
		Intent i = new Intent();
		i.setClass(MainActivity.this, Cajero2.class);
		startActivity(i);
	}
}
