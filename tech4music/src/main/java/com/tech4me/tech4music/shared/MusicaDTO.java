package com.tech4me.tech4music.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MusicaDTO {

    
    private String id;

    @NotBlank(message = "O título deve conter caracteres não brancos")
    @NotEmpty(message = "O título precisa ser preenchido")
    @Size(min = 3, message = "O título deve possuir, no mínimo, 3 caracteres")
    private String titulo;

    private String artista;

    private String genero;

    private Integer anoLancamento;

    private String compositor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

}