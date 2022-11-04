package Kodlama.io.Devs.dataAccess.concretes;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageDao;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageDao implements LanguageDao {

    List<Language> languages ;

    public InMemoryLanguageDao() {
        languages = new ArrayList<>();
        languages.add(new Language(1,"Java"));
        languages.add(new Language(2,"C#"));
        languages.add(new Language(3,"C"));
        languages.add(new Language(4,"C++"));
        languages.add(new Language(5,"JavaScript"));
        languages.add(new Language(6,"Python"));

    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public Language createLang(Language language) {
        for(Language l:languages){
            if(l.getName().equals(language.getName())){
                System.out.println("Bu isim sistemde kayıtlıdır.");
            }
        }
        languages.add(language);
        return language;
    }
    @Override
    public Language getById(Long id) {
        Language language = new Language();
        language=null;
        for(Language l: languages) {
            if (l.getId() == id) {
                language = l;
            }
        }
        return  language;
    }

    @Override
    public Language deleteLang(Long id) {
        Language language = new Language();
        language=null;
        for(Language l: languages) {
            if (l.getId() == id) {
                language = l;
            }
        }
        languages.remove(language);
        return language;
    }
}
