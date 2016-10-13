package com.example.banco;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Bdh extends SQLiteOpenHelper {

	String sqlCreateAdmin ="CREATE TABLE Admin ( `idAdmin` INTEGER NOT NULL DEFAULT 1 PRIMARY KEY AUTOINCREMENT UNIQUE, `Usuario` TEXT NOT NULL UNIQUE, `Pass` TEXT NOT NULL )";
	String sqlCreateCli ="CREATE TABLE Cliente ( `idCli` INTEGER NOT NULL DEFAULT 1 PRIMARY KEY AUTOINCREMENT UNIQUE, `passCli` INTEGER NOT NULL, `cedulaCli` INTEGER NOT NULL UNIQUE, `nombre` TEXT NOT NULL, `sexo` TEXT NOT NULL )";
	String sqlCreateCu ="CREATE TABLE Cuenta ( `idCu` INTEGER NOT NULL DEFAULT 1 PRIMARY KEY AUTOINCREMENT UNIQUE, `saldo` INTEGER NOT NULL, `idCli` INTEGER NOT NULL, `idMov` INTEGER, `estado` TEXT NOT NULL, FOREIGN KEY(`idCli`) REFERENCES `Cliente`(`idCli`) )";
	String sqlCreateMov ="CREATE TABLE Movimiento ( `idMov` INTEGER NOT NULL DEFAULT 1 PRIMARY KEY AUTOINCREMENT UNIQUE, `tipo` TEXT NOT NULL, `monto` INTEGER NOT NULL, `idCli` INTEGER NOT NULL, `idCu` INTEGER NOT NULL )";
			
	public Bdh(Context contexto) {
		super(contexto, "Banco", null, 1);
		// TODO Auto-generated constructor stub
	}
	 @Override
	  public void onCreate(SQLiteDatabase db) {
	      db.execSQL(sqlCreateAdmin);
	      db.execSQL(sqlCreateCli);
	      db.execSQL(sqlCreateCu);
	      db.execSQL(sqlCreateMov);
	      
	        ContentValues valNom = new ContentValues();
	        valNom.put("idAdmin","1");
	        valNom.put("Usuario", "admin");
	        valNom.put("Pass", "123");
	      db.insert("Admin", null, valNom);
	 }
	  public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
	      db.execSQL("DROP TABLE IF EXISTS Admin");
	      db.execSQL("DROP TABLE IF EXISTS Cliente");  
	      db.execSQL("DROP TABLE IF EXISTS Cuenta");
	      db.execSQL("DROP TABLE IF EXISTS Movimiento");
	      
	      //Nueva Version tocará crear otra vez el admin?
	      db.execSQL(sqlCreateAdmin);
	      db.execSQL(sqlCreateCli);
	      db.execSQL(sqlCreateCu);
	      db.execSQL(sqlCreateMov);
	      
	        ContentValues valNom = new ContentValues();
	        valNom.put("Usuario", "admin");
	        valNom.put("Pass", "123");
	      db.insert("Admin", null, valNom);
	  }
	  
	  
	  
	    public List<String> funUsuAdmin( String usuario){
	    	List<String> valUsuAdmin = new ArrayList<String>();
	    	 SQLiteDatabase db = this.getReadableDatabase();
	    	 String selectQuery = "SELECT  * FROM Admin WHERE Usuario = '" + usuario + "'";
	    	 
	    	 Cursor cursor = db.rawQuery(selectQuery, null);
	    	 
	    	 if (cursor.moveToFirst()) {
	    		 do {
	    		 valUsuAdmin.add(cursor.getString(1));
	    		 } while (cursor.moveToNext());
	    	 }
	    	 	cursor.close();
		        db.close();
		        return valUsuAdmin;
		    }
	    public List<String> funPassAdmin( String pass){
	    	List<String> valPassAdmin = new ArrayList<String>();
	    	 SQLiteDatabase db = this.getReadableDatabase();
	    	 String selectQuery = "SELECT  * FROM Admin WHERE Pass = '" + pass+"'";
	    	 
	    	 Cursor cursor = db.rawQuery(selectQuery, null);
	    	 if (cursor.moveToFirst()) {
	    		 do {
	    		 valPassAdmin.add(cursor.getString(2));
	    		 } while (cursor.moveToNext());
	    	 }
	    	 	cursor.close();
		        db.close();
		        return valPassAdmin;
		    }
	    
	    public List<String> ObtenerCiu(String Depto){
	        List<String> valoresCiu = new ArrayList<String>();
	         
	        String selectQuery = "SELECT  * FROM Ciudades WHERE Fk_CodDep = " + Depto;
	      
	        SQLiteDatabase db = this.getReadableDatabase();
	        Cursor cursor = db.rawQuery(selectQuery, null);
	      
	        if (cursor.moveToFirst()) {
	            do {
	                valoresCiu.add(cursor.getString(1));
	            } while (cursor.moveToNext());
	        }
	         
	        cursor.close();
	        db.close();
	         
	        return valoresCiu;
	    }
	    
}
