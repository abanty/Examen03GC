package examen03.android.examen03gc.Views;

/*EXAMEN 03 APLICACIONES MOVILES - APP GESTION DE CONTACTOS*/

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import examen03.android.examen03gc.Presentators.DBHelper;

import examen03.android.examen03gc.R;


public class TabContactos extends Fragment {

    ListView lv;
    ArrayList<String> lista;
    ArrayAdapter adaptador;

    @Override
    @SuppressWarnings("unchecked")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2_contactos, container, false);
        lv = (ListView) rootView.findViewById(R.id.lista);
        DBHelper db = new DBHelper(getActivity(),null,null,1);
        lista = db.listarusuarios();


        adaptador = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adaptador);

        return rootView;
    }

}
