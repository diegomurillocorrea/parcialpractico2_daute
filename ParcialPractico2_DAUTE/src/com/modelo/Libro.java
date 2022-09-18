package com.modelo;

public class Libro {

    private int id_libro;
    private String titulo;
    private String descripcion;
    private int stock;
    private int stockMinimo;
    private int categoryId;
    private int autorId;

    public Libro() {
    }

    public Libro(int id_libro, String titulo, String descripcion, int stock, int stockMinimo, int categoryId, int autorId) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.categoryId = categoryId;
        this.autorId = autorId;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }
}
