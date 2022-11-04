package Kodlama.io.Devs.dataAccess.abstracts;

import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageDao {
    List<Language> getAll();
    Language createLang(Language language);

    Language getById(Long id);
    Language deleteLang(Long id);
}
