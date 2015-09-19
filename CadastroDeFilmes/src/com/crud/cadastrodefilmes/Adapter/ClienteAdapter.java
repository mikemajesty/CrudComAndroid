package com.crud.cadastrodefilmes.Adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.crud.cadastrodefilmes.Activity.R;
import com.crud.cadastrodefilmes.Model.Cliente;

public class ClienteAdapter extends BaseAdapter{

	private Context ctx;
	private List<Cliente> listCliente;
	
	public ClienteAdapter(Context ctx,List<Cliente> listCliente){
		this.ctx = ctx;
		this.listCliente = listCliente;
	}
	@Override
	public int getCount() {
				return listCliente.size();
	}

	@Override
	public Object getItem(int location) {
		return listCliente.get(location);
	}

	@Override
	public long getItemId(int location) {
		return location;
	}

	@Override
	public View getView(int location, View v, ViewGroup viewGroup) {
		Cliente cliente = (Cliente)getItem(location);
		LayoutInflater layout = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = layout.inflate(com.crud.cadastrodefilmes.Activity.R.layout.listar, null);
		TextView txvId = (TextView)view.findViewById(R.id.listar_txvId);
		TextView txvNome = (TextView)view.findViewById(R.id.listar_txvNome);
		txvId.setText(""+cliente.getId());
		txvNome.setText(cliente.getNome().toString());
		return view;
	}

}
