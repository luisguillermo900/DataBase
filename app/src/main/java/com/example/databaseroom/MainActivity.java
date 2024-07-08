package com.example.databaseroom;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.databaseroom.baseDatos.AppDatabase;
import com.example.databaseroom.tablas.Autor;
import com.example.databaseroom.tablas.Pintura;
import com.example.databaseroom.tablas.Sala;
import com.example.databaseroom.relaciones.PinturaDetalles;
import com.example.databaseroom.relaciones.SalaPinturaDetalles;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // Datos
                Autor autor = new Autor();
                autor.setIdAutor(1);
                autor.setNombre("Leonardo");
                autor.setApellido("da Vinci");
                db.autorDao().insertAll(autor);

                Sala sala = new Sala();
                sala.setIdSala(1);
                sala.setNombre("Renacimiento");
                sala.setTema("Arte del Renacimiento");
                db.salaDao().insertAll(sala);

                Pintura pintura = new Pintura();
                pintura.setIdPintura(1);
                pintura.setTitulo("Mona Lisa");
                pintura.setAutorId(1);
                pintura.setSalaId(1);
                pintura.setTecnica("Óleo");
                pintura.setCategoria("Retrato");
                pintura.setDescripcion("Pintura famosa");
                pintura.setAnio(1503);
                pintura.setEnlaceImagen("enlace_a_la_imagen");
                db.pinturaDao().insertAll(pintura);

                // Consulta 1
                List<PinturaDetalles> pinturaDetalles = db.pinturaDao().getPinturaDetalles();
                for (PinturaDetalles p : pinturaDetalles) {
                    System.out.println(p.titulo + " - " + p.autor);
                }

                // Consulta 2
                List<SalaPinturaDetalles> salaPinturaDetalles = db.pinturaDao().getSalaPinturaDetalles();
                for (SalaPinturaDetalles sp : salaPinturaDetalles) {
                    System.out.println(sp.nombreSala + " - " + sp.titulo + " - " + sp.autor);
                }
            }
        }).start();
    }
}