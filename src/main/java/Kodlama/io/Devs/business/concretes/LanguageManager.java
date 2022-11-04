package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageDao;
import Kodlama.io.Devs.dataAccess.concretes.InMemoryLanguageDao;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LanguageManager implements LanguageService {
    private LanguageDao languageDao;


    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public List<Language> getAll() {
        return languageDao.getAll();
    }

    @Override
    public Language createLang(Language language) {
        if(language.getName()==null||language.getName().equals("")){
            System.out.println("Dil kısmı boş olamaz");
            return null;
        }else {
            languageDao.createLang(language);
            return language;
        }
    }

    @Override
    public ResponseEntity<Language> getLanguageById(Long id) throws Throwable {
        Language language = languageDao.getById(id);
        return ResponseEntity.ok(language);
    }
    @Override
    public ResponseEntity<Language> updateLang(Long id, Language language) throws Throwable {
        if(language.getName()==null||language.getName().equals("")){
            System.out.println("Dil kısmı boş olamaz");
            return null;
        }else {
            Language lang = languageDao.getById(id);
            lang.setId(language.getId());
            lang.setName(language.getName());

            return ResponseEntity.ok(lang);
        }
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteLang(Long id) throws Throwable {
        languageDao.deleteLang(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
