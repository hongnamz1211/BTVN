package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public Optional<Song> findById(long id) {
        return songRepository.findById(id);
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void remove(long id) {
        songRepository.deleteById(id);
    }

    @Override
    public Page<Song> findAllSongByCategory(long id, Pageable pageable) {
        return songRepository.findSongsByCategory_Id(id, pageable);
    }

    @Override
    public Page<Song> findAllSongByNameContaining(String name, Pageable pageable) {
        return songRepository.findSongsByNameContaining(name, pageable);
    }

    @Override
    public List<Song> sortSongByNameAsc(String name) {
        return (List<Song>) songRepository.findAll(Sort.by(Sort.Direction.ASC, name));
    }

    @Override
    public List<Song> sortSongByNameDesc(String name) {
        return (List<Song>) songRepository.findAll(Sort.by(Sort.Direction.DESC, name));
    }


}
