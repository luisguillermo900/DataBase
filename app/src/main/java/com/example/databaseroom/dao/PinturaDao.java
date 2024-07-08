package com.example.databaseroom.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.databaseroom.tablas.Pintura;
import com.example.databaseroom.relaciones.PinturaDetalles;
import com.example.databaseroom.relaciones.SalaPinturaDetalles;

import java.util.List;

@Dao
public interface PinturaDao {
    @Query("SELECT * FROM pintura")
    List<Pintura> getAll();

    @Query("SELECT * FROM pintura WHERE idPintura IN (:ids)")
    List<Pintura> loadAllByIds(int[] ids);

    @Insert
    void insertAll(Pintura... pinturas);

    @Delete
    void delete(Pintura pintura);

    @Query("SELECT pintura.titulo, autor.nombre || ' ' || autor.apellido AS autor, pintura.tecnica, pintura.categoria, pintura.descripcion, pintura.anio, pintura.enlaceImagen " +
            "FROM pintura JOIN autor ON pintura.autorId = autor.idAutor")
    List<PinturaDetalles> getPinturaDetalles();

    @Query("SELECT sala.nombre AS nombreSala, pintura.titulo, autor.nombre || ' ' || autor.apellido AS autor, pintura.enlaceImagen " +
            "FROM pintura JOIN sala ON pintura.salaId = sala.idSala JOIN autor ON pintura.autorId = autor.idAutor")
    List<SalaPinturaDetalles> getSalaPinturaDetalles();
}
