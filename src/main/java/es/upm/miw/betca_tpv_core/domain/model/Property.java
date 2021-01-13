package es.upm.miw.betca_tpv_core.domain.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Property {
    private static final Property property = new Property();
    @Value("${miw.tpv}")
    private String miwTpv;

    public static Property getProperty() {
        return property;
    }

    public String getMiwTpv() {
        return miwTpv;
    }
}
