package com.crud.cadastrodefilmes.Activity;

import com.crud.cadastrodefilmes.Adapter.ClienteAdapter;
import com.crud.cadastrodefilmes.DAO.ClienteDAO;
import com.crud.cadastrodefilmes.Model.Cliente;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


public class ListarActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	@Override 
	public void onResume(){
		super.onResume();
		ClienteDAO cliDao = new ClienteDAO(getBaseContext());
		setListAdapter(new ClienteAdapter(getBaseContext(),cliDao.getAll()));
	}
	 protected void onListItemClick(ListView l, View v, int position, long id) {
		 Cliente cliente = (Cliente)l.getAdapter().getItem(position);		 
		 startActivity(new Intent("EditarActivity").putExtra("codigo", cliente.getId()));		 
	    }
	
}
