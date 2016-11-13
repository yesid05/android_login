package com.example.login;

import com.example.modelo.Persona;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends Activity implements OnClickListener{
	
	EditText registrar_cedula,registrar_nombre,registrar_apellido,registrar_usuario,registrar_contrasena;
	
	Button registrar_btn_guardar,registrar_btn_regresar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registrar);
		
		registrar_apellido = (EditText) findViewById(R.id.registrar_apellido);
		registrar_cedula = (EditText) findViewById(R.id.registrar_cedula);
		registrar_contrasena = (EditText) findViewById(R.id.registrar_contrasena);
		registrar_nombre = (EditText) findViewById(R.id.registrar_nombre);
		registrar_usuario = (EditText) findViewById(R.id.registrar_usuario);
		
		registrar_btn_guardar = (Button) findViewById(R.id.registrar_btn_guardar);
		registrar_btn_guardar.setOnClickListener(this);
		registrar_btn_regresar =(Button) findViewById(R.id.registrar_btn_regresar);
		registrar_btn_regresar.setOnClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registrar, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.registrar_btn_guardar:
			Persona persona = new Persona();
			persona.setCedula(registrar_cedula.getText().toString());
			persona.setNombre(registrar_nombre.getText().toString());
			persona.setApellido(registrar_apellido.getText().toString());
			persona.setUsuario(registrar_usuario.getText().toString());
			persona.setContrasena(registrar_contrasena.getText().toString());
			if(MainActivity.personaDao.insertar(persona)){
				Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(this,MainActivity.class);
				startActivity(intent);
			}else{
				Toast.makeText(this, "Existe un error", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.registrar_btn_regresar:
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}
