package com.example.basedealumnos

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        grabar.setOnClickListener {
            val admin=BasededatosLite(this,"mibase",null,1)
            val bd=admin.writableDatabase
            val registro=ContentValues()
            registro.put("codigo",editcodigo.text.toString())
            registro.put("nombre",editnombre.text.toString())
            registro.put("lugar",editlugar.text.toString())
            registro.put("horario",edithorario.text.toString())
            registro.put("precio",editprecio.text.toString())
            registro.put("deberes",editdeberes.text.toString())
            bd.insert("misalumnos",null,registro)
            bd.close()
            editcodigo.setText("")
            editnombre.setText("")
            editlugar.setText("")
            edithorario.setText("")
            editprecio.setText("")
            editdeberes.setText("")
            Toast.makeText(this,"se cargo informacion de nuevo alumno",Toast.LENGTH_LONG).show()
        }
        listar.setOnClickListener {
            val admin=BasededatosLite(this,"mibase",null,1)
            val bd=admin.writableDatabase
            val fila=bd.rawQuery("select codigo, nombre, lugar, horario,precio, deberes from misalumnos where nombre='${editnombre.text.toString()}'",null)
            if(fila.moveToFirst()){
                editcodigo.setText(fila.getString(0))
                editnombre.setText(fila.getString(1))
                editlugar.setText(fila.getString(2))
                edithorario.setText(fila.getString(3))
                editprecio.setText(fila.getString(4))
                editdeberes.setText(fila.getString(5))


            }else{
                Toast.makeText(this,"no existe ese alumno",Toast.LENGTH_LONG).show()
                bd.close()
            }


        }
        borrar.setOnClickListener {
            val admin=BasededatosLite(this,"mibase",null,1)
            val bd=admin.writableDatabase
            val cant:Int=bd.delete("misalumnos","codigo=${editcodigo.text.toString()}",null)

            bd.close()
            editcodigo.setText("")
            editnombre.setText("")
            editlugar.setText("")
            edithorario.setText("")
            editprecio.setText("")
            editdeberes.setText("")
            if(cant==1){
                Toast.makeText(this,"se borro alumno",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"no se borro el alumno",Toast.LENGTH_LONG).show()
            }




        }



    }
}