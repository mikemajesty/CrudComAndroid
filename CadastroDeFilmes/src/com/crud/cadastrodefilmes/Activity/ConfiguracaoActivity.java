package com.crud.cadastrodefilmes.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfiguracaoActivity extends Activity
{

	private Button btnCadastrar;
	private EditText edtNome,edtSenha,edtServidor;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configuracao);
		
		mapButton();
		mapEditText();
		loadValuesInEditText();
		onClickBtnCadastrar();	
	}
	private void loadValuesInEditText() 
	{
		edtNome.setText(preferences().getString("usuario", "null"));
		edtSenha.setText(preferences().getString("senha", "null"));
		edtServidor.setText(preferences().getString("servidor", "null"));		
	}
	private void UpdateValuesSharedPreferences() 
	{
		SharedPreferences.Editor  editor = preferences().edit();
		editor.putString("usuario", edtNome.getText().toString());
		editor.putString("senha", edtSenha.getText().toString());
		editor.putString("servidor", edtServidor.getText().toString());
		if (editor.commit()) {
			startActivity(new Intent("LoginActivity"));
		}
		
		
	}
	private void onClickBtnCadastrar() 
	{
		btnCadastrar.setOnClickListener(new View.OnClickListener() 
		{			
			@Override
			public void onClick(View v) {
				UpdateValuesSharedPreferences();			
			}
		});
		
	}
	private void mapEditText() 
	{
		edtNome = (EditText)findViewById(R.id.config_edtNome);
		edtSenha = (EditText)findViewById(R.id.config_edtSenha);
		edtServidor = (EditText)findViewById(R.id.config_edtServidor);
	}
	private void mapButton() 
	{
		btnCadastrar = (Button)findViewById(R.id.config_btnCadastrar);
		
	}
	private SharedPreferences preferences()
	{
		SharedPreferences preferences  =getSharedPreferences("log", Context.MODE_PRIVATE);
		return preferences;
	}
	
}
