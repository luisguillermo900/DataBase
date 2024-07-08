package com.example.databaseroom.relaciones;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.databaseroom.tablas.Autor;
import com.example.databaseroom.tablas.Pintura;

import java.util.List;

public class AutorPintura {
    @Embedded
    public Autor autor;

    @Relation(
            parentColumn = "idAutor",
            entityColumn = "autorId"
    )
    public List<Pintura> pinturas;
}
