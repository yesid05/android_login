package com.example.database;

import com.example.modelo.Persona;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class PersonaDao {
	public static final String NOMBRE_TABLA = "persona";
    public static final String ID = "id";
    public static final String CEDULA = "cedula";
    public static final String NOMBRE = "nombre";
    public static final String APELLIDO = "apellido";
    public static final String USUARIO = "usuario";
    public static final String CONTRASENA = "contrasena";
    
    SQLiteDatabase db;
    
    public PersonaDao(Context contexto) {
		DataBaseHelper helper = new DataBaseHelper(contexto);
		
		db = helper.getWritableDatabase();
	}
    
    public boolean insertar(Persona unaPersona){
        ContentValues cv = new ContentValues();
        cv.put(CEDULA,unaPersona.getCedula());
        cv.put(NOMBRE,unaPersona.getNombre());
        cv.put(APELLIDO,unaPersona.getApellido());
        cv.put(USUARIO,unaPersona.getUsuario());
        cv.put(CONTRASENA,unaPersona.getContrasena());
        
        if((db.insert(NOMBRE_TABLA, null, cv))!=-1){
        	return true;
        }else{
        	return false;
        }
    }
    
    public Persona buscarPersona(String unNombre,String unaContrasena){
        String sql = "SELECT * FROM "+NOMBRE_TABLA+" WHERE "+USUARIO+" = '"+unNombre+"' AND "+CONTRASENA+" = '"+unaContrasena+"'";
        Persona p = null;

        Cursor c = db.rawQuery(sql,null);
        Log.d("cantidad", sql);
        if(c.getCount()>0){
            c.moveToNext();
            p = new Persona();
            
            p.setId(c.getInt(c.getColumnIndex(ID)));
            p.setCedula(c.getString(c.getColumnIndex(CEDULA)));
            p.setNombre(c.getString(c.getColumnIndex(NOMBRE)));
            p.setApellido(c.getString(c.getColumnIndex(APELLIDO)));
            p.setUsuario(c.getString(c.getColumnIndex(USUARIO)));
            p.setContrasena(c.getString(c.getColumnIndex(CONTRASENA)));

        }
        
        return p;
    }
    
    public Persona buscarPersonaId(int id){
    	String sql= "SELECT * FROM "+NOMBRE_TABLA+" WHERE "+ID+" = "+id;
    	Persona p = null;
    	Cursor c = db.rawQuery(sql,null);
    	
    	if (c.getCount()>0) {
			c.moveToNext();
			p = new Persona();
			p.setNombre(c.getString(c.getColumnIndex(NOMBRE)));
			p.setApellido(c.getString(c.getColumnIndex(APELLIDO)));
			p.setUsuario(c.getString(c.getColumnIndex(USUARIO)));
			
		}
    	
    	return p;
    }

}
