package es.upm.miw.betca_tpv_core.infrastructure.mongodb.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class DatabaseSeederDev {

    @Autowired
    public DatabaseSeederDev(DatabaseSeeder databaseSeeder) {
        databaseSeeder.deleteAllAndInitializeAndSeedDataBase();
    }

}
