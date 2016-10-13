package com.example.banco;



import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Bdh usdbh = new Bdh(this);
		db = usdbh.getWritableDatabase();

	}

	public void Fun_cajero(View v){
		Intent i = new Intent();
		i.setClass(MainActivity.this, Cajero.class);
		startActivity(i);
	}
	public void Fun_Admin(View v){
		Intent i = new Intent();
		i.setClass(MainActivity.this, Admin.class);
		startActivity(i);
	}
	

}
