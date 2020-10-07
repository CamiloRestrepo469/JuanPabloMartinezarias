package com.example.taream1;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taream1.basedata.basedata;

public class MainActivity extends AppCompatActivity {
    EditText etnombres,ettelefono,editcorreo,editid;
    Button btnguardar,btnlistar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnombres=findViewById(R.id.etnombres);
        ettelefono=findViewById(R.id.ettelefono);
        editcorreo = findViewById(R.id.editcorreo);
        editid = findViewById(R.id.editid);
        btnguardar=findViewById(R.id.btnguardar);
        btnlistar=findViewById(R.id.btnlistar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar(editid.getText().toString(),etnombres.getText().toString(),editcorreo.getText().toString(),
                        ettelefono.getText().toString());

            }
        });
        btnlistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,listview.class));
            }
        });
    }

    protected void maleSimpleAlerDialog(String message, int duration){
        Toast.makeText(this,message,duration).show();
    }
    protected void maleSimpleAlerDialog(String title,String message) {
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

    private void guardar(String id, String nombres, String correo, String telefono) {
        basedata helper = new basedata(this,"BDCONTACTO",null,1);
        SQLiteDatabase db= helper.getWritableDatabase();
        try
        {
            //Contenedor de datos del contacto
            ContentValues c = new ContentValues();
            c.put("ID",id);
            c.put("NOMBRES",nombres);
            c.put("correo",correo);
            c.put("TELEFONO",telefono);
            db.insert("CONTACTO",null,c);
            db.close();

            startActivity(new Intent(MainActivity.this,listview.class));
            Toast.makeText(this,"Contacto agregado correctamente...",Toast.LENGTH_SHORT).show();

        }
        catch (Exception e)
        {
            maleSimpleAlerDialog("database error",1);
            maleSimpleAlerDialog("Error","No hay conecion a base de datos");
//            Toast.makeText(this,"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

//    private void otroguardar(String id, String nombre, String correo, String telefono) {
//        SQLiteDatabase db = helper.getWritableDatabase();
//        try {
//            ContentValues c = new ContentValues();
//            c.put("id",id);
//            c.put("nombre",nombre);
//            c.put("correo",correo);
//            c.put("telefono",telefono);
//
//            db.insert("contacto",null,c);
//            db.close();
//            Intent intent = new Intent(this,listview.class);
//            startActivity(intent);
//            Toast.makeText(getApplicationContext(),"guardado ",Toast.LENGTH_LONG).show();
//
//        }catch (Exception e){
//            Toast.makeText(this,"Error : "+e.getMessage(),Toast.LENGTH_SHORT).show();
//        }
//    }

}