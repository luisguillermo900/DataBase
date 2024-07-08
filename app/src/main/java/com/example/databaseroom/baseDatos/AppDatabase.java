package com.example.databaseroom.baseDatos;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.databaseroom.dao.AutorDao;
import com.example.databaseroom.dao.PinturaDao;
import com.example.databaseroom.dao.SalaDao;
import com.example.databaseroom.tablas.Autor;
import com.example.databaseroom.tablas.Pintura;
import com.example.databaseroom.tablas.Sala;

@Database(entities = {Autor.class, Pintura.class, Sala.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AutorDao autorDao();
    public abstract PinturaDao pinturaDao();
    public abstract SalaDao salaDao();
}
