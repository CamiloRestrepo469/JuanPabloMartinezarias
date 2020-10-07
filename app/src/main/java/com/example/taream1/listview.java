package com.example.taream1;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taream1.adtador.adatador;
import com.example.taream1.basedata.basedata;
import com.example.taream1.modelo.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class listview extends AppCompatActivity {
    protected adatador adapter;
    private static int id;
    private static String nombres;
    private static String correo;
    private static String telefono;

    basedata helper = new basedata(this,"BDCONTACTO",null,1);
    TextView etnombres,ettelefono,editcorreo,editid;

    protected modelo models;
    protected ArrayList<modelo> modelsArrayList;
    protected ArrayList<basedata> usuarios;
    ListView listView;
    ArrayList<String> listado;
    private adatador adatador;

    @Override
    public String toString() {
        return "listview{" +
                "etnombres=" + etnombres +
                ", ettelefono=" + ettelefono +
                ", editcorreo=" + editcorreo +
                ", editid=" + editid +
                '}';
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView = findViewById(R.id.lvcontacto);
        cargarlistado();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                String
                            informacion= "id: "+ Arrays.toString(listado.get(position).getBytes()) +"\n";
                            informacion+= "nombres: "+listado.get(position).equals(nombres)+"\n";
                            informacion+= "correo: "+listado.get(position).equals(correo)+"\n";
                            informacion+= "telefono: "+listado.get(position).equals(telefono)+"\n";

                          maleSimpleAlerDialog("Contacto","detalle informacion :  "+"\n"+"\n"+informacion);
//                            Toast.makeText(getApplicationContext(), informacion, Toast.LENGTH_SHORT).show();


            }

        });
    }
    protected void maleSimpleAlerDialog(String message, int duration){
        Toast.makeText(this,message,duration).show();
    }

    private void maleSimpleAlerDialog(String title,String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void verlista(ArrayList<modelo>modelsArrayList){
        adatador = new adatador(this,modelsArrayList);
        listView.setAdapter(adatador);
    }
    private void cargarlistado() {
//        listado = listacontacto();
        listado=ListaContactos();
        ArrayAdapter<String>adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_expandable_list_item_1,listado);
        listView.setAdapter(adapter);
    }

    private ArrayList<String> ListaContactos() {
        ArrayList<String> datos = new ArrayList<String>();
        basedata helper = new basedata(this,"BDCONTACTO",null,1);
        SQLiteDatabase db= helper.getReadableDatabase();
        String sql = "Select Id,Nombres,Telefono,correo From Contacto";
        Cursor c = db.rawQuery(sql,null);
        if (c.moveToFirst())
        {
            do{
                String linea = c.getInt(0)+" , "+c.getString(1)+" , "+c.getString(2)+" , "+c.getString(3)+".";
                datos.add(linea);
            }while (c.moveToNext());
        }
        db.close();
        return datos;
    }


//    private ArrayList<String> listacontacto() {
//        try {
//            ArrayList<String> datos = new ArrayList<String>();
//            basedata helper = new basedata(this, "contacto", null, 1);
//            SQLiteDatabase db = helper.getReadableDatabase();
//            String sql = "Select id,nombres,correo,telefono From contacto";
//            Cursor c = db.rawQuery(sql, null);
//            if (c.moveToFirst()) {
//                do {
//                    String linea = c.getInt(0) + " " + c.getString(1) + " " + c.getString(2) + " " + c.getString(3);
//                    datos.add(linea);
//                } while (c.moveToNext());
//            }
//            db.close();
//            return datos;
//
//        }catch (Exception e){
//            Toast.makeText(this,"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
//
//        }
//
//        return null;
//    }
}




