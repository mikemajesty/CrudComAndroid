package com.crud.cadastrodefilmes.Activity;

import com.crud.cadastrodefilmes.DAO.ClienteDAO;
import com.crud.cadastrodefilmes.Model.Cliente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarActivity extends Activity{
      
	 private EditText edtNome,edtCategoria,edtAno,edtNacionalidade,edtCodigo;
	   private Button btnAlterar,btnDeletar;
	   private static int ID = 0;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editar);
		  mapEditText();
		   mapButton();
		   onClickBtnCadastrar();
		   onClickBtnDeletar();
		   Intent intent = getIntent();
		   
		   
		   
		   ID =  intent.getIntExtra("codigo", 0);
		   
		   Cliente cliente = CliDao().getById(ID);
		
		   setValuesInEditText(cliente);
	}
	
	
	private void onClickBtnDeletar() {
		btnDeletar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Cliente cliente = new Cliente();
				cliente.setId(ID);
				
				if (CliDao().Delete(cliente)) {
					Toast.makeText(getBaseContext(), "Sucesso!", Toast.LENGTH_SHORT).show();
					finish();
				}
				
			}
		});
		
	}

    private ClienteDAO CliDao(){
    	ClienteDAO cliDao = new ClienteDAO(getBaseContext());
    	return cliDao;
    }
	private void setValuesInEditText(Cliente cliente) {
		edtCodigo.setText(""+cliente.getId());
		edtNome.setText(cliente.getNome().toString());
		edtCategoria.setText(cliente.getCategoria().toString());
		edtAno.setText(""+cliente.getAno());
		edtNacionalidade.setText(cliente.getNacionalidade().toString());
	}


	private void onClickBtnCadastrar() {
		btnAlterar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Cliente cliente = new Cliente();
				cliente.setId(ID);
				cliente.setNome(edtNome.getText().toString());
				cliente.setCategoria(edtCategoria.getText().toString());
				cliente.setAno(Integer.parseInt(edtAno.getText().toString()));
				cliente.setNacionalidade(edtNacionalidade.getText().toString());
				
				if (CliDao().Update(cliente)) {
					Toast.makeText(getBaseContext(), "Sucesso!", Toast.LENGTH_SHORT).show();
					finish();
				}
				
			}
		});
		}
		private void mapButton() {
			btnAlterar = (Button)findViewById(R.id.editar_btnAlterar);	
			btnDeletar = (Button)findViewById(R.id.editar_btnDeletar);
		}
		private void mapEditText() {
		    edtNome = (EditText)findViewById(R.id.editar_edtNome);
			edtCategoria = (EditText)findViewById(R.id.editar_edtCategoria);
			edtNacionalidade = (EditText)findViewById(R.id.editar_edtNacionalidade);
			edtAno = (EditText)findViewById(R.id.editar_edtAno);
			edtCodigo = (EditText)findViewById(R.id.editar_edtId);
		}
		}

