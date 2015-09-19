package com.crud.cadastrodefilmes.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity{
	
	private Button btnLogar;
	private EditText edtNome,edtSenha;
    @Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		mapButton();
		mapEditText();
		onClickBtnLogar();
	}
	private void onClickBtnLogar() {
		btnLogar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String usuario = preferences().getString("usuario", "admin");
				String senha = preferences().getString("senha", "123");
				
				if (usuario.equals(edtNome.getText().toString())) {
					if (senha.equals(edtSenha.getText().toString())) {
						
						startActivity(new Intent("MenuActivity"));
					}
				}
				
			}
		});
		
	}
	private void mapEditText() {
		edtNome = (EditText)findViewById(R.id.login_edtLogin);
		edtSenha = (EditText)findViewById(R.id.login_edtSenha);
	}
	private void mapButton() {
		btnLogar = (Button)findViewById(R.id.login_btnLenha);		
	}
	private SharedPreferences preferences(){
		SharedPreferences pref = getSharedPreferences("log", Context.MODE_PRIVATE);
		return pref;
	}
}
