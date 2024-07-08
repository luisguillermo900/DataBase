package com.example.databaseroom.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.databaseroom.relaciones.SalaPintura;
import com.example.databaseroom.tablas.Sala;

import java.util.List;

@Dao
public interface SalaDao {
    @Query("SELECT * FROM sala")
    List<Sala> getAll();

    @Query("SELECT * FROM sala WHERE idSala IN (:ids)")
    List<Sala> loadAllByIds(int[] ids);

    @Query("SELECT * FROM sala WHERE nombre LIKE :nombre AND tema LIKE :tema LIMIT 1")
    Sala findByName(String nombre, String tema);

    @Insert
    void insertAll(Sala... salas);

    @Delete
    void delete(Sala sala);

    @Transaction
    @Query("SELECT * FROM sala")
    List<SalaPintura> getSalaConPinturas();
}
