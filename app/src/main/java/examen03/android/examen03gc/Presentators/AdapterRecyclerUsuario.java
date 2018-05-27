package examen03.android.examen03gc.Presentators;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import examen03.android.examen03gc.Models.Usuario;
import examen03.android.examen03gc.R;



public class AdapterRecyclerUsuario extends RecyclerView.Adapter<AdapterRecyclerUsuario.UsuarioViewHolder> {

    ArrayList<Usuario> listaUsuario;

    public AdapterRecyclerUsuario(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto,null,false);
        return new UsuarioViewHolder(view);

    }

    @Override
    public void onBindViewHolder(UsuarioViewHolder holder, int position) {

        holder.txtnombre.setText(listaUsuario.get(position).getNombre());
        holder.txtcel.setText(Integer.toString(listaUsuario.get(position).getNcelular()));


    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }





    public class UsuarioViewHolder extends RecyclerView.ViewHolder {

        TextView txtnombre,txtcel;

        public UsuarioViewHolder(View itemView) {
            super(itemView);
            txtnombre = (TextView) itemView.findViewById(R.id.contacname);
            txtcel = (TextView) itemView.findViewById(R.id.contacnumber);

        }
    }
}
