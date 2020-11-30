package es.upm.miw.betca_tpv_core.configuration;

import es.upm.miw.betca_tpv_core.infrastructure.api.http_errors.Role;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

class JwtUtilTest {

    @Test
    void testCreateToken() {
        LogManager.getLogger(this.getClass()).info("token:" + JwtUtil.createToken("666666000", "adm", Role.ADMIN.name()));
    }
}
