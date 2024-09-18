package com.google.vedant.photoz.clone.web;

import com.google.vedant.photoz.clone.service.PhotozService;
import com.google.vedant.photoz.clone.model.Photo;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {
    private final PhotozService photozService;

    public DownloadController(PhotozService photozService) {
        this.photozService = photozService;
    }
    @GetMapping("/download/{id}")
    public ResponseEntity <byte[]> download(@PathVariable String id)
    {
        Photo ph=PhotozService.get(id);
        if(ph==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        byte[]data=ph.getData();

        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.valueOf(ph.getContentType()));//img or png or gif
        // display photo in the browser or automaically download it
        headers.setContentDisposition(ContentDisposition.builder(
                "attachment")// type would be inline for the browser to download
                .filename(ph.getFileName())
                .build());
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
