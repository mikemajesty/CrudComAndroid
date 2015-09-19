package com.crud.cadastrodefilmes.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

	public static String DATABASE_NAME = "locadora.db";
	public static int VERSION = 1;
	public static String  SQL= "CREATE TABLE [filmes] ( [id] INTEGER PRIMARY KEY AUTOINCREMENT, [nome] VARCHAR(20) [categoria] VARCHAR(20), [ano] INTEGER(4), [nacionalidade] VARCHAR(20));";
	
	public DataBase(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {		
		db.execSQL(SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
