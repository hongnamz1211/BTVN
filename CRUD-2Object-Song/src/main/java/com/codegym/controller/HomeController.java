package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Song;
import com.codegym.service.ICategoryService;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Value("${file-upload}")
    public String fileUpload;

    @Value("${view}")
    public String view;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ISongService songService;

    @ModelAttribute(name = "categories")
    public Iterable<Category> categories() {
        return categoryService.allCategory();
    }

    @GetMapping("/asc")
    public ModelAndView sortByAsc(@SortDefault(sort = "name", direction = Sort.Direction.ASC)
                                  @PageableDefault Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Song> songs = songService.findAll(pageable);
        modelAndView.addObject("songs", songs);
        modelAndView.addObject("file", view);
        return modelAndView;
    }

    @GetMapping("/desc")
    public ModelAndView sortByDesc(@SortDefault(sort = "name", direction = Sort.Direction.DESC)
                                   @PageableDefault Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Song> songs = songService.findAll(pageable);
        modelAndView.addObject("songs", songs);
        modelAndView.addObject("file", view);
        return modelAndView;
    }

    @GetMapping("/list-category")
    public ModelAndView listCategory() {
        ModelAndView modelAndView = new ModelAndView("list-category");
        Iterable<Category> categories = categoryService.allCategory();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/view-songs/{id}")
    public ModelAndView viewByCategory(@PathVariable long id,
                                       @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("category-song");
        Page<Song> songs = songService.findAllSongByCategory(id, pageable);
        modelAndView.addObject("songs", songs);
        modelAndView.addObject("file", view);
        return modelAndView;
    }

    @GetMapping
    public ModelAndView listSong(@ModelAttribute("search") Optional<String> search,
                                 @PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Song> songs;
        if (search.isPresent()) {
            songs = songService.findAllSongByNameContaining(search.get(), pageable);
        } else {
            songs = songService.findAll(pageable);
        }
        if (songs.isEmpty()) {
            modelAndView.addObject("message", "Song is empty!!");
        }
        modelAndView.addObject("songs", songs);
        modelAndView.addObject("file", view);
        return modelAndView;
    }


    @GetMapping("/view/{id}")
    public ModelAndView detailSong(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        Optional<Song> song = songService.findById(id);
        modelAndView.addObject("song", song);
        modelAndView.addObject("file", view);
        return modelAndView;
    }

    @GetMapping("/create-song")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        Iterable<Category> categories = categoryService.allCategory();
        modelAndView.addObject("song", new Song());
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @PostMapping("/create-song")
    public String createProduct(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("create");
        if (bindingResult.hasFieldErrors()) {
            return "redirect:http://localhost:8080/home/create-song";
//            return new ModelAndView("create").addObject("song", song);
        }
        MultipartFile multipartFile = song.getImageFile();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(song.getImageFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        song.setImage(fileName);
        Song songCreate = songService.save(song);
        if (songCreate != null) {
            Iterable<Category> categories = categoryService.allCategory();
            modelAndView.addObject("categories", categories);
            modelAndView.addObject("message", "Create successfully");
        }
        return "redirect:/home";
    }

    @GetMapping("/delete-song/{id}")
    public ModelAndView showDeleteForm(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        songService.remove(id);
        return modelAndView;
    }

    @GetMapping("/edit-song/{id}")
    public ModelAndView showEditForm(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Optional<Song> song = songService.findById(id);
        Iterable<Category> categories = categoryService.allCategory();
        modelAndView.addObject("song", song);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("file", view);
        return modelAndView;
    }

    @PostMapping("/edit-song/{id}")
    public ModelAndView editSong(@Valid @ModelAttribute("song") Song song,
                                 @PathVariable("id") long id,
                                 BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("edit");
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("edit").addObject("song", song);
        }
        song.setId(id);
        if (song.getImageFile().getSize() != 0) {
            MultipartFile multipartFile = song.getImageFile();
            String fileName = multipartFile.getOriginalFilename();
            try {
                FileCopyUtils.copy(song.getImageFile().getBytes(), new File(fileUpload + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            song.setImage(fileName);
        } else {
            song.setImage(songService.findById(id).get().getImage());
        }
        Song songEdit = songService.save(song);
        if (songEdit != null) {
            Iterable<Category> categories = categoryService.allCategory();
            modelAndView.addObject("categories", categories);
            modelAndView.addObject("file", view);
            modelAndView.addObject("message", "Update Product Successfully !!!");
        }
        return new ModelAndView("redirect:/home");
    }


}
