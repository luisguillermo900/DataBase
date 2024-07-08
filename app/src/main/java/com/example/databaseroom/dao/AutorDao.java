package com.example.databaseroom.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.databaseroom.relaciones.AutorPintura;
import com.example.databaseroom.tablas.Autor;

import java.util.List;

@Dao
public interface AutorDao {
    @Query("SELECT * FROM autor")
    List<Autor> getAll();

    @Query("SELECT * FROM autor WHERE idAutor IN (:ids)")
    List<Autor> loadAllByIds(int[] ids);

    @Query("SELECT * FROM autor WHERE nombre LIKE :nombre AND apellido LIKE :apellido LIMIT 1")
    Autor findByName(String nombre, String apellido);

    @Insert
    void insertAll(Autor... autores);

    @Delete
    void delete(Autor autor);

    @Transaction
    @Query("SELECT * FROM autor")
    List<AutorPintura> getAutoresConPinturas();
}
