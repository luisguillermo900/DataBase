package com.example.databaseroom.tablas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Sala {
    @PrimaryKey
    private int idSala;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "tema")
    private String tema;

    // Getters
    public int getIdSala() {
        return idSala;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTema() {
        return tema;
    }

    // Setters
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
