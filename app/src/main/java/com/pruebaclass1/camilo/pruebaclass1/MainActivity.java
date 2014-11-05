package com.pruebaclass1.camilo.pruebaclass1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.pruebaclass1.camilo.pruebaclass1.modelo.Tema;



public class MainActivity extends Activity
{

    DataBaseTemasManager manager;
    ListView listview;
    Cursor cursorTemas;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        manager = new DataBaseTemasManager(this);

        listview = (ListView) findViewById(R.id.listView);

        String[] from = new String[]{"titulo", "texto"};
        int[] to = new int[]{R.id.textView_superior, R.id.textView_inferior};

        cursorTemas = manager.getTemas();


        //int prueba1 = cursorTemas.getColumnCount();
        //int prueba2 = cursorTemas.getCount();

        //cursorTemas.moveToFirst();
        //String prueba = cursorTemas.getString(cursorTemas.getColumnIndex("titulo"));

        //Toast.makeText(getApplicationContext(), prueba, Toast.LENGTH_LONG).show();

        adapter = new SimpleCursorAdapter(this, R.layout.entrada, cursorTemas, from, to, 0);

        listview.setAdapter(adapter);

        /*Tema tema = new Tema();
        tema.setContext(this);
        ViewGroup cont = tema.renderizar();
        setContentView(cont);*/

    }



    public void irNuevo(View v)
    {
        Intent i = new Intent(MainActivity.this, NuevoActivity.class);
        startActivity(i);
    }

    public void irBuscar(View v)
    {
        Intent i = new Intent(MainActivity.this, BuscarActivity.class);
        startActivity(i);
    }

    public void irAyuda(View v)
    {
        Intent i = new Intent(MainActivity.this, AyudaActivity.class);
        //suponiendo que pasamos datos
        i.putExtra("nombre", "Camilo");
        i.putExtra("edad", 22);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
