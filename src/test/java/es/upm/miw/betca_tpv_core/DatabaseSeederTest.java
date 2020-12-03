package es.upm.miw.betca_tpv_core;

import es.upm.miw.betca_tpv_core.infrastructure.mongodb.daos.DatabaseSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("prod")
public class DatabaseSeederTest {

    @Autowired
    public DatabaseSeederTest(DatabaseSeeder databaseSeeder) {
        databaseSeeder.deleteAllAndInitializeAndSeedDataBase();
    }

}
