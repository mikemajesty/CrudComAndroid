package com.crud.cadastrodefilmes.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity{
    private Button btnCadastrar,btnListar,btnConfiguracao;
	 @Override 
	 public void onCreate(Bundle savedInstanceState){
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.menu);
		 mapButton();
		 onClickBtnCadastrar();
		 onClickBtnListar();
		 onClickBtnConfigurar();
		 }
	private void onClickBtnConfigurar() {
	  btnConfiguracao.setOnClickListener(new View.OnClickListener() {		
		@Override
		public void onClick(View v) {
			startActivity(new Intent("ConfiguracaoActivity"));
		}
	});
	}
	private void onClickBtnListar() {
		btnListar.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent("ListarActivity"));
			}
		});
		
	}
	
	private void onClickBtnCadastrar() {		
		btnCadastrar.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
			
				startActivity(new  Intent("CadastrarActivity"));
			}
		});
	}
	private void mapButton() {
		btnCadastrar  =(Button)findViewById(R.id.menu_btnCadastrar);
		btnListar = (Button)findViewById(R.id.menu_btnListar);
		btnConfiguracao = (Button)findViewById(R.id.menu_btnConfiguracao);		
	}
}
