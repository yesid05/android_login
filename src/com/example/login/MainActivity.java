package com.example.login;

import com.example.database.PersonaDao;
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

public class MainActivity extends Activity implements OnClickListener {

	EditText login_usuario, login_contrasena;

	Button login_btn_ingresar, login_btn_registrar;

	public static PersonaDao personaDao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		personaDao = new PersonaDao(this);

		login_usuario = (EditText) findViewById(R.id.login_usuario);
		login_contrasena = (EditText) findViewById(R.id.login_contrasena);

		login_btn_ingresar = (Button) findViewById(R.id.login_btn_ingresar);
		login_btn_ingresar.setOnClickListener(this);
		login_btn_registrar = (Button) findViewById(R.id.login_btn_registrar);
		login_btn_registrar.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login_btn_ingresar:
			Persona p = personaDao.buscarPersona(login_usuario.getText()
					.toString(), login_contrasena.getText().toString());
			if (p == null) {
				Toast.makeText(this, "Usuario null", Toast.LENGTH_LONG).show();
			} else {
				Intent intent =new Intent(this, BienvenidoActivity.class);
				intent.putExtra("id", p.getId());
				startActivity(intent);
			}
			break;
		case R.id.login_btn_registrar:
			Intent intent = new Intent(this, RegistrarActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}

	}

}
