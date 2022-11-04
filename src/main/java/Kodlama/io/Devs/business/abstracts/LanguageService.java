package Kodlama.io.Devs.business.abstracts;

import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface LanguageService {
    List<Language> getAll();

    public Language createLang(Language language);
    public ResponseEntity<Language> getLanguageById(Long id) throws Throwable;
    public ResponseEntity<Language> updateLang(Long id, Language language) throws Throwable;
    public ResponseEntity<Map<String,Boolean>> deleteLang(Long id) throws Throwable;
}
