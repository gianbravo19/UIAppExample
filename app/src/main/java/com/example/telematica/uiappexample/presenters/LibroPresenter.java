package com.example.telematica.uiappexample.presenters;

import android.os.AsyncTask;

import com.example.telematica.uiappexample.models.HttpServerConnection;
import com.example.telematica.uiappexample.views.LibroVIew;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by italiano Leo on 15-01-2016.
 */
public class LibroPresenter implements com.example.telematica.uiappexample.presenters.contract.LibroPresenter{

   private LibroVIew mLibroView;

    public LibroPresenter ( LibroVIew mLibroView){

          this.mLibroView = mLibroView;
    }

    @Override
    public void obtenerLibros() {

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPreExecute(){

            }

            @Override
            protected String doInBackground(Void... params) {
                String resultado = new HttpServerConnection().connectToServer("http://www.mocky.io/v2/56990dc51200009e47e25b44", 15000);
                return resultado;
            }

            @Override
            protected void onPostExecute(String result) {
                if(result != null){
                    System.out.println(result);
                    mLibroView.manageLibro(getLista(result));



                }
            }
        };

        task.execute();
    }

    private List<Libro> getLista(String result){
        List<Libro> listaLibros = new ArrayList<Libro>();
        try {
            JSONArray lista = new JSONArray(result);

            int size = lista.length();
            for(int i = 0; i < size; i++){
                Libro libro = new Libro();
                JSONObject objeto = lista.getJSONObject(i);

                libro.setId(objeto.getInt("id"));
                libro.setNombre(objeto.getString("nombre"));
                libro.setEditorial(objeto.getString("editorial"));
                libro.setGenero(objeto.getString("genero"));
                libro.setAutor(objeto.getInt("autor"));

                listaLibros.add(libro);
            }
            return listaLibros;
        } catch (JSONException e) {
            e.printStackTrace();
            return listaLibros;
        }
    }

}
