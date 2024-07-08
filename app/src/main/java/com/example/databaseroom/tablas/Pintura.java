package com.example.databaseroom.tablas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Autor.class,
                parentColumns = "idAutor",
                childColumns = "autorId",
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Sala.class,
                parentColumns = "idSala",
                childColumns = "salaId",
                onDelete = ForeignKey.CASCADE)
})
public class Pintura {
    @PrimaryKey
    private int idPintura;

    @ColumnInfo(name = "titulo")
    private String titulo;

    @ColumnInfo(name = "autorId")
    private int autorId;

    @ColumnInfo(name = "salaId")
    private int salaId;

    @ColumnInfo(name = "tecnica")
    private String tecnica;

    @ColumnInfo(name = "categoria")
    private String categoria;

    @ColumnInfo(name = "descripcion")
    private String descripcion;

    @ColumnInfo(name = "anio")
    private int anio;

    @ColumnInfo(name = "enlaceImagen")
    private String enlaceImagen;

    // Getters
    public int getIdPintura() {
        return idPintura;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAutorId() {
        return autorId;
    }

    public int getSalaId() {
        return salaId;
    }

    public String getTecnica() {
        return tecnica;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getAnio() {
        return anio;
    }

    public String getEnlaceImagen() {
        return enlaceImagen;
    }

    // Setters
    public void setIdPintura(int idPintura) {
        this.idPintura = idPintura;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public void setSalaId(int salaId) {
        this.salaId = salaId;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setEnlaceImagen(String enlaceImagen) {
        this.enlaceImagen = enlaceImagen;
    }
}
