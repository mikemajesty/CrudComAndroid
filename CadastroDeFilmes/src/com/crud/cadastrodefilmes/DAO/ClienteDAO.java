package com.crud.cadastrodefilmes.DAO;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.crud.cadastrodefilmes.Model.Cliente;

public class ClienteDAO {
 
	 private Context ctx;
	 private static String TABLE_NAME ="filmes";
	 private static String[] COLUMNS = {"id","nome","categoria","ano","nacionalidade"};
	 public boolean Insert(Cliente cliente){		 
		 return( gerenciadorBanco().insert(TABLE_NAME, null, setValuesInCliente(cliente)) > 0);	 
	 }
	 public boolean Update(Cliente cliente){
		return (gerenciadorBanco().update(TABLE_NAME, setValuesInClienteWithID(cliente), "id=?", new String[] {""+cliente.getId()}) >0);
	 }
	 public boolean Delete(Cliente cliente){
		 return(gerenciadorBanco().delete(TABLE_NAME, "id=?", new String[] {""+cliente.getId()}) >0);		
	 }
	 public Cliente getById(int ID){
		 Cursor cursor = gerenciadorBanco().query(TABLE_NAME, COLUMNS, "id=?", new String[] {""+ID}, null, null, null);
		 Cliente cliente = null;
		 if (cursor.moveToFirst()) {
			cliente = new Cliente();
			
			cliente.setId(ID);
			cliente.setNome(cursor.getString(cursor.getColumnIndex("nome")));
			cliente.setCategoria(cursor.getString(cursor.getColumnIndex("categoria")));
			cliente.setAno(cursor.getInt(cursor.getColumnIndex("ano")));
			cliente.setNacionalidade(cursor.getString(cursor.getColumnIndex("nacionalidade")));
			
		}
		return cliente;
		 
	 }
	 public List<Cliente> getAll(){
		Cursor cursor = gerenciadorBanco().rawQuery("SELECT * FROM FILMES", null);
		Cliente cliente = null;
		List<Cliente> listCliente = new ArrayList<Cliente>();
		
		while (cursor.moveToNext()) {
			cliente = new Cliente();
		    cliente.setId(cursor.getInt(cursor.getColumnIndex("id")));
			cliente.setNome(cursor.getString(cursor.getColumnIndex("nome")));
			cliente.setCategoria(cursor.getString( cursor.getColumnIndex("categoria")));
			cliente.setAno(cursor.getInt(cursor.getColumnIndex("ano")));
			cliente.setNacionalidade(cursor.getString(cursor.getColumnIndex("nacionalidade")));
			listCliente.add(cliente);
		}		
		return listCliente;		 
	 }
	 
	 
	 
	 
	 public ClienteDAO(Context ctx){
		 this.ctx = ctx;
	 }
	 public SQLiteDatabase gerenciadorBanco(){
		 SQLiteDatabase banco = new DataBase(ctx).getWritableDatabase();
		 return banco;
	 }
	 public ContentValues setValuesInCliente(Cliente cliente){
		 ContentValues values = new ContentValues();
		 values.put("nome", cliente.getNome());
		 values.put("categoria", cliente.getCategoria());
		 values.put("ano", cliente.getAno());
		 values.put("nacionalidade", cliente.getNacionalidade());
		 return values;
	 }
	 public ContentValues setValuesInClienteWithID(Cliente cliente){
		 ContentValues values = new ContentValues();
		 values.put("id", cliente.getId());
		 values.put("nome", cliente.getNome());
		 values.put("categoria", cliente.getCategoria());
		 values.put("ano", cliente.getAno());
		 values.put("nacionalidade", cliente.getNacionalidade());
		 return values;
	 }
}
