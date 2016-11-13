package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{
	
	public static final String DB_NOMBRE = "persona.db";
	
	public static final int version = 1;

	public DataBaseHelper(Context context) {
		super(context, DB_NOMBRE, null, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase sql) {
		
		String sqlPersona = "CREATE TABLE " + PersonaDao.NOMBRE_TABLA + " ("
                + PersonaDao.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PersonaDao.CEDULA + " VARCHAR, "
                + PersonaDao.NOMBRE + " VARCHAR, "
                + PersonaDao.APELLIDO + " VARCHAR, "
                + PersonaDao.USUARIO + " VARCHAR, "
                + PersonaDao.CONTRASENA + " VARCHAR);";
		
		sql.execSQL(sqlPersona);
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
