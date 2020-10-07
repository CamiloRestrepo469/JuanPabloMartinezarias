package com.example.taream1.adtador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.example.taream1.R;
import com.example.taream1.modelo.modelo;

import java.util.ArrayList;

public class adatador extends BaseAdapter {

   private Context context;
   private ArrayList<modelo> modeloArrayList;
   private int id;
   private String nombre;
   private String correo;
   private String telefono;


   public adatador(Context context, ArrayList<modelo>modeloArrayList){
       this.context = context;
       this.modeloArrayList = modeloArrayList;
   }

    public adatador() {

    }


    @Override
    public int getCount() {
        return modeloArrayList.size();
    }

    @Override
    public modelo getItem(int position) {
        return modeloArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View adatapterview, ViewGroup viewGroup) {
        if(adatapterview == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            adatapterview = layoutInflater.inflate(R.layout.activity_listview,viewGroup,false);
        }
        EditText etnombres = adatapterview.findViewById(R.id.etnombres);
        EditText editcorreo = adatapterview.findViewById(R.id.editcorreo);
        EditText ettelefono = adatapterview.findViewById(R.id.ettelefono);
        EditText editid = adatapterview.findViewById(R.id.editid);

        etnombres.setText(getItem(position).getNombre());
        editcorreo.setText(getItem(position).getCorreo());
        ettelefono.setText(getItem(position).getTelefono());
        editid.setText(getItem(position).getId());

        return adatapterview;
    }
}
