package com.example.banco;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Cajero extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cajero);
	}
	public void Fun_cajero2(View v){
		Intent i = new Intent();
		i.setClass(Cajero.this, Cajero2.class);
		startActivity(i);
	}
}
