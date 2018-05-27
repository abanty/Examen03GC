package examen03.android.examen03gc.Presentators;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Prueba", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String consulta = "create table usuarios(_ID integer primary key autoincrement," +
                "Nombre TEXT,Ncelular INTEGER)";
        db.execSQL(consulta);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void abrirbd(){
        this.getWritableDatabase();
    }

    public void cerrarbd(){
        this.close();
    }

    public void registrar(String name, String ncel){
        ContentValues datos = new ContentValues();
        datos.put("Nombre",name);
        datos.put("Ncelular",ncel);


        this.getWritableDatabase().insert("usuarios",null,datos);
    }


    public ArrayList listarusuarios(){
        ArrayList<String> lista = new ArrayList<String>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM usuarios";
        Cursor registros = database.rawQuery(q,null);
        if (registros.moveToFirst()){
            do{
                lista.add(registros.getString(1));

            }while (registros.moveToNext());
        }
        return lista;
    }







    public ArrayList listarusuariosnumero(){
        ArrayList<String> listan = new ArrayList<String>();
        SQLiteDatabase database = this.getWritableDatabase();
        String qn = "SELECT * FROM usuarios";
        Cursor registros = database.rawQuery(qn,null);
        if (registros.moveToFirst()){
            do{
                listan.add(registros.getString(2));

            }while (registros.moveToNext());
        }
        return listan;
    }


}
