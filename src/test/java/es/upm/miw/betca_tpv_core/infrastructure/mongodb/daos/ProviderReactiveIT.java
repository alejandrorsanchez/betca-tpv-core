package es.upm.miw.betca_tpv_core.infrastructure.mongodb.daos;

import es.upm.miw.betca_tpv_core.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ProviderReactiveIT {

    @Autowired
    private ProviderReactive providerReactive;

    @Test
    void testFindByProviderEntityIsNull() {
        StepVerifier
                .create(this.providerReactive.findByCompanyAndActiveIsTrueNullSave(null))
                .expectNextCount(1)
                .thenCancel()
                .verify();
    }


}
