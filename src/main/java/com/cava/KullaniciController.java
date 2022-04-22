package com.cava;

import com.cava.entity.Kullanici;
import com.cava.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullaniciController {

    @Autowired
    private KullaniciRepository kullaniciRepository;


    @PostConstruct
    public void init(){
        Kullanici k1 = new Kullanici();
        k1.setAdi("Ahmet");
        k1.setSoyadi("Kaya");
        HashMap<String,String> ozellikler = new HashMap<>();
        ozellikler.put("göz rengi","siyah");
        ozellikler.put("boyu","180");
        k1.setOzellikleri(ozellikler);
        kullaniciRepository.save(k1);
    }
    @PostMapping
    public ResponseEntity<Kullanici> ekle(@RequestBody Kullanici kullanici){
        return ResponseEntity.ok(kullaniciRepository.save(kullanici));
    }

    @GetMapping
    public ResponseEntity<List<Kullanici>> tumunuListele(){
        return ResponseEntity.ok(kullaniciRepository.findAll());
    }


}
