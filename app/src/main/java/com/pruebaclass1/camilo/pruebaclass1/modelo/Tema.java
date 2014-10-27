package com.pruebaclass1.camilo.pruebaclass1.modelo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.pruebaclass1.camilo.pruebaclass1.R;

import java.util.Date;

/**
 * Created by Camilo on 23/10/2014.
 */
public class Tema {

    private Integer ID;

    private Context ctx;

    private String titulo;

    private String pregunta;

    private String nombreCreador;

    private String fechaCreado;

    private String email;

    //Metodos
    public Tema(){}

    public Tema(String tit, String preg, String nom, String fecha, String email)
    {
        titulo = tit;
        pregunta = preg;
        nombreCreador = nom;
        fechaCreado = fecha;
        this.email = email;
    }

    public void setTitulo(String tit)
    {
        titulo = tit;
    }

    public void setContext(Context context)
    {
        ctx=context;
    }

    //probando
    public ViewGroup renderizar()
    {
        ViewGroup vg = null;
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        vg = (ViewGroup) inflater.inflate(R.layout.activity_principal, null, true);

        TextView texto = (TextView) vg.findViewById(R.id.textView2);
        texto.setText(titulo);
        return vg;
    }

}
