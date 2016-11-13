package com.example.login;

import com.example.modelo.Persona;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class BienvenidoActivity extends Activity {

	TextView bienvenido_lbl_nombre, bienvenido_lbl_apellido,
			bienvenido_lbl_usuario;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bienvenido);

		Bundle bundle = getIntent().getExtras();

		int id = bundle.getInt("id");

		bienvenido_lbl_nombre = (TextView) findViewById(R.id.bienvenido_lbl_nombre);
		bienvenido_lbl_apellido = (TextView) findViewById(R.id.bienvenido_lbl_apellido);
		bienvenido_lbl_usuario = (TextView) findViewById(R.id.bienvenido_lbl_usuario);

		Persona p = MainActivity.personaDao.buscarPersonaId(id);
		if (id != 0 && p != null) {

			bienvenido_lbl_nombre.setText(p.getNombre());
			bienvenido_lbl_apellido.setText(p.getApellido());
			bienvenido_lbl_usuario.setText(p.getUsuario());
		} else {
			Toast.makeText(this, "Existeun error", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bienvenido, menu);
		return true;
	}

}
