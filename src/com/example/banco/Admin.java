package com.example.banco;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends Activity{
	
	EditText EdPass,EdUsu;
	Button IngresarAdmin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin);
		
		EdPass = (EditText) findViewById(R.id.passAdmin);
		EdUsu = (EditText) findViewById(R.id.usuAdmin);
		IngresarAdmin = (Button) findViewById(R.id.button1);
		
		
		
		IngresarAdmin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String textoUsu = EdUsu.getText().toString();
				String textoPass = EdPass.getText().toString();
				
				if (textoUsu.trim().length() > 0 && textoPass.trim().length() > 0 ) {
					Bdh dbh = new Bdh(getApplicationContext());
                    List<String> listUsuAdmin = dbh.funUsuAdmin(textoUsu);
                    List<String> listPassAdmin = dbh.funPassAdmin(textoPass);
                    Object x = EdUsu.getText().toString();
                    Object y = EdPass.getText().toString();
                    
    					if(!listUsuAdmin.contains(x)){
    						Toast.makeText(getApplicationContext(), "El Usuario de Administrador no existe.",
    	                            Toast.LENGTH_SHORT).show();
    					}
    					if(!listPassAdmin.contains(y)){
    						Toast.makeText(getApplicationContext(), "La Contraseña no es valida.",
    	                            Toast.LENGTH_SHORT).show();
    					}    					
    					Toast.makeText(getApplicationContext(), "Welcome!",
					 			Toast.LENGTH_SHORT).show();
    				 } else {
    					 	Toast.makeText(getApplicationContext(), "Por favor, ingrese un valor",
    					 			Toast.LENGTH_SHORT).show();
                }
				
			}	
		});
	
		
	}

	
}
