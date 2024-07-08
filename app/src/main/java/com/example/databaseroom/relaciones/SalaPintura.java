package com.example.databaseroom.relaciones;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.databaseroom.tablas.Pintura;
import com.example.databaseroom.tablas.Sala;

import java.util.List;

public class SalaPintura {
    @Embedded
    public Sala sala;

    @Relation(
            parentColumn = "idSala",
            entityColumn = "salaId"
    )
    public List<Pintura> pinturas;
}
