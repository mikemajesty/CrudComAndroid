package com.crud.cadastrodefilmes.Activity;

import com.crud.cadastrodefilmes.DAO.ClienteDAO;
import com.crud.cadastrodefilmes.Model.Cliente;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarActivity extends Activity{
	
	
	
	
   private EditText edtNome,edtCategoria,edtAno,edtNacionalidade;
   private Button btnCadastrar;
   @Override
   public void onCreate(Bundle savedInstanceState){
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.cadastrar);
	   mapEditText();
	   mapButton();
	   onClickBtnCadastrar();
   }
private void onClickBtnCadastrar() {
  btnCadastrar.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		if(clienteDao().Insert(setValuesInCliente(clienteValues()))){
	  Toast.makeText(getBaseContext(), "Sucesso!!", Toast.LENGTH_SHORT).show();
	  finish();
  }
	}
});
}
private void mapButton() {
	btnCadastrar = (Button)findViewById(R.id.cadastro_btnCadastrar);	
}
private void mapEditText() {
    edtNome = (EditText)findViewById(R.id.cadastro_edtNome);
	edtCategoria = (EditText)findViewById(R.id.cadastro_edtCategoria);
	edtNacionalidade = (EditText)findViewById(R.id.cadastro_edtNacionalidade);
	edtAno = (EditText)findViewById(R.id.cadastro_edtAno);
}

private Cliente setValuesInCliente(Cliente cliente){
	cliente.setNome(edtNome.getText().toString());
	cliente.setCategoria(edtCategoria.getText().toString());
	cliente.setAno(Integer.parseInt(edtAno.getText().toString()));
	cliente.setNacionalidade(edtNacionalidade.getText().toString());
	return cliente;
}
private ClienteDAO clienteDao(){
	ClienteDAO cli = new ClienteDAO(getBaseContext());
	return cli;
}
private Cliente clienteValues(){
	Cliente cliente = new Cliente();
	return cliente;
}
}