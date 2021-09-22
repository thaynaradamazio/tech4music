package com.tech4me.tech4music.view.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.tech4me.tech4music.service.MusicaService;
import com.tech4me.tech4music.shared.MusicaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {
    
    @Autowired
    MusicaService servicoMusica;

    @GetMapping
    public ResponseEntity<List<MusicaDTO>> obterTodos(){
    
        List<MusicaDTO> musicas = servicoMusica.obterTodos();
        return new ResponseEntity<>(musicas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MusicaDTO>> obterPorId(@PathVariable String id){
        Optional<MusicaDTO> musica = servicoMusica.obterPorId(id);

        return new ResponseEntity<>(musica, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MusicaDTO> adicionar(@RequestBody @Valid MusicaDTO musicaDto ){
        
        musicaDto = servicoMusica.adicionar(musicaDto);
        return new ResponseEntity<>(musicaDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id){
        servicoMusica.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicaDTO> atualizar(@PathVariable String id, @RequestBody @Valid MusicaDTO musicaDto){

        MusicaDTO dto = servicoMusica.atualizar(id, musicaDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}