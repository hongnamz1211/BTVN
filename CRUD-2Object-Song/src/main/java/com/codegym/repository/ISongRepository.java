package com.codegym.repository;

import com.codegym.model.Category;
import com.codegym.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongRepository extends PagingAndSortingRepository<Song, Long> {
    Page<Song> findSongsByCategory_Id(long category_id, Pageable pageable);

    Page<Song> findSongsByNameContaining(String name, Pageable pageable);
}
