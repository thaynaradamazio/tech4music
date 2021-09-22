package com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;

import com.tech4me.tech4music.shared.MusicaDTO;

import org.springframework.stereotype.Service;

public interface MusicaService {
    
    List<MusicaDTO> obterTodos();

    Optional<MusicaDTO> obterPorId(String idMusica);

    MusicaDTO adicionar(MusicaDTO musicaDto);

    MusicaDTO atualizar(String id, MusicaDTO musicaDto);

    void delete(String idMusica);

}
