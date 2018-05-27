package examen03.android.examen03gc.Views;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import examen03.android.examen03gc.Models.Usuario;
import examen03.android.examen03gc.Presentators.AdapterRecyclerUsuario;
import examen03.android.examen03gc.Presentators.DBHelper;
import examen03.android.examen03gc.R;

public class ListarActivity extends AppCompatActivity {


    ArrayList<Usuario> listaUsuario;
    RecyclerView rvusuarios;
    DBHelper conn;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

         conn = new DBHelper(getBaseContext(),"Prueba",null,1);
        listaUsuario=new ArrayList<>();

        rvusuarios = (RecyclerView) findViewById(R.id.recyclerlista);
        rvusuarios.setLayoutManager(new LinearLayoutManager(this));
//        listaUsuario = db.listarusuarios();
        consultarListaPersonas();

        AdapterRecyclerUsuario adapter = new AdapterRecyclerUsuario(listaUsuario);
        rvusuarios.setAdapter(adapter);

    }


    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Usuario usuario=null;
        Cursor cursor=db.rawQuery("SELECT * FROM usuarios",null);
        while (cursor.moveToNext()){
            usuario=new Usuario();
//          usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
          usuario.setNcelular(Integer.valueOf(cursor.getString(2)));
            listaUsuario.add(usuario);
        }
    }



}
