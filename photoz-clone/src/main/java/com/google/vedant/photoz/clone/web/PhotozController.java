package com.google.vedant.photoz.clone.web;

import com.google.vedant.photoz.clone.service.PhotozService;
import com.google.vedant.photoz.clone.model.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

@RestController
public class PhotozController {
    private final PhotozService photozService;

    public PhotozController(PhotozService photozService) {
        this.photozService = photozService;
    }

    //private List <Photo> db= List.of(new Photo("1", "hello.jpg"));


    @GetMapping("/")
    public String hello()
    {
        return "Hello World";
    }
    @GetMapping("/photoz")// fetching list of photos from database, but at the moment, we don't have any database
    public Collection<Photo> get()
    {
        return PhotozService.get();// return all the photos present in our hashmap
    }
    @GetMapping("/photoz/{id}")// fetching list of photos from database, but at the moment, we don't have any database
    public Photo get(@PathVariable String id)
    {
        Photo ph= PhotozService.get(id);
        if(ph==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ph;
    }
    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id)
    {
        Photo ph= PhotozService.remove(id);
        if(ph==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    //we want front end to send in some JSON and then we want that spring boot to covert that JSON to a photo object and we can handle photo object directly
    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        // Interesting this front end should not generate id, we should generate
        return PhotozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());

    }

}
