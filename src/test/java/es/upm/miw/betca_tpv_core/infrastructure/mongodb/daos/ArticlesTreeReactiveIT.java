package es.upm.miw.betca_tpv_core.infrastructure.mongodb.daos;

import es.upm.miw.betca_tpv_core.TestConfig;
import es.upm.miw.betca_tpv_core.infrastructure.mongodb.daos.synchronous.ArticlesTreeDao;
import es.upm.miw.betca_tpv_core.infrastructure.mongodb.entities.ArticlesTreeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@TestConfig
class ArticlesTreeReactiveIT {

    @Autowired
    private ArticlesTreeDao articlesTreeDao;

    @Test
    void testFindAll() {
        List< ArticlesTreeEntity > x = this.articlesTreeDao.findByReference("root");
        System.out.println("DB: " + x);
        x.get(0).contents().stream().forEach(z -> System.out.println(z));
    }

}
