package com.google.vedant.photoz.clone.service;

import com.google.vedant.photoz.clone.model.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

//@Component
@Service
public class PhotozService {
    private static HashMap<String, Photo> db=new HashMap<>() {{
        put("1", new Photo("1", "hello.jpg"));
    }};

    public static Photo get(String id) {
        return db.get(id);
    }

    public static Photo remove(String id) {
        return db.remove(id);
    }

    public static Photo save(String fileName, String contentType, byte[] data) {
        Photo ph=new Photo();

        ph.setId(UUID.randomUUID().toString());
        ph.setContentType(contentType);
        ph.setFileName(fileName);
        ph.setData(data);
        db.put(ph.getId(),ph);
        return ph;
    }

    public static Collection<Photo> get() {
        return db.values();
    }
}
