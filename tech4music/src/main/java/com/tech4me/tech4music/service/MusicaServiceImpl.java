package com.tech4me.tech4music.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.tech4music.model.Musica;
import com.tech4me.tech4music.repository.MusicaRepository;
import com.tech4me.tech4music.shared.MusicaDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    MusicaRepository repositorioMusica;

    @Override
    public List<MusicaDTO> obterTodos() {
        
        List<Musica> musicas = repositorioMusica.findAll();

        ModelMapper mapper = new ModelMapper();

        return musicas.stream()
        .map(jogo -> mapper.map(jogo, MusicaDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public MusicaDTO adicionar(MusicaDTO musicaDto) {
   
        ModelMapper mapper = new ModelMapper();

        Musica musica = mapper.map(musicaDto, Musica.class);

        musica.setId(null);

        musica = repositorioMusica.save(musica);
        return mapper.map(musica, MusicaDTO.class);
    }

    @Override
    public Optional<MusicaDTO> obterPorId(String idMusica) {
        
        Optional<Musica> optionalMusica = repositorioMusica.findById(idMusica);

        if(optionalMusica.isEmpty()){
            throw new InputMismatchException("Não foi encontrada a música com o id: " + idMusica);
        }

        MusicaDTO  musicaDto = new ModelMapper().map(optionalMusica.get(), MusicaDTO.class);
        return Optional.of(musicaDto);
    }

    @Override
    public void delete(String idMusica) {
        // Aqui poderia criar uma logica para saber se o Musica existe com esse id.
        repositorioMusica.deleteById(idMusica);
    }

    @Override
    public MusicaDTO atualizar(String id, MusicaDTO musicaDto) {
                
        musicaDto.setId(id);

        Musica musica = new ModelMapper().map(musicaDto, Musica.class);
        repositorioMusica.save(musica);

        return musicaDto;
    }
    
}

