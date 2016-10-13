package com.example.banco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Cajero2 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cajero2);
	}
	
	public void Fun_consultasal(View v){
		Intent i = new Intent();
		i.setClass(Cajero2.this, Consulta.class);
		startActivity(i);
	}
	
	public void Fun_retiro(View v){
		Intent i = new Intent();
		i.setClass(Cajero2.this, Retiro.class);
		startActivity(i);
	}
	
	public void Fun_clave(View v){
		Intent i = new Intent();
		i.setClass(Cajero2.this, Clave.class);
		startActivity(i);
	}
}
