package Kodlama.io.Devs.webApi.controllers;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/get")
    public List<Language> getAll(){
        return languageService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable Long id){
        List<Language> list = languageService.getAll();
        return ResponseEntity.ok(list.get(id.intValue()));
    }
    @PostMapping("/languages")
    public Language createEmployee(@RequestBody Language language){
        languageService.createLang(language);
        return language;
    }

    //Update
    //http://localhost:8080/api/languages/languages/1
    @PutMapping("/languages/{id}")
    public ResponseEntity<Language> updateEmployee(@PathVariable Long id,@RequestBody Language language) throws Throwable {
        languageService.updateLang(id, language);
        return ResponseEntity.ok(language);
    }

    //Delete
    //http://localhost:8080/api/v1/employees/2
    @DeleteMapping("/languages/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {
        languageService.deleteLang(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
