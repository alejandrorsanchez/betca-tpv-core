package es.upm.miw.betca_tpv_core.configuration;

import es.upm.miw.betca_tpv_core.TestConfig;
import es.upm.miw.betca_tpv_core.infrastructure.api.http_errors.Role;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
class JwtServiceTest {

    @Autowired
    private JwtService jwtService;

    @Test
    void testCreateToken() {
        LogManager.getLogger(this.getClass()).info("token:" + jwtService.createToken("666666000", "adm", Role.ADMIN.name()));
    }
}
