package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);

    Optional<Song> findById(long id);

    Song save(Song song);

    void remove(long id);

    Page<Song> findAllSongByCategory(long id, Pageable pageable);

    Page<Song> findAllSongByNameContaining(String name, Pageable pageable);

    List<Song> sortSongByNameAsc(String name);

    List<Song> sortSongByNameDesc(String name);
}
