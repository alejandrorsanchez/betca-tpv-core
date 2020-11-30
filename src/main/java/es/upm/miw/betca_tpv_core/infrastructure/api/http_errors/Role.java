package es.upm.miw.betca_tpv_core.infrastructure.api.http_errors;

public enum Role {
    ADMIN, MANAGER, OPERATOR, CUSTOMER;

    public static String prefix = "ROLE_";

    public static Role of(String withPrefix) {
        return Role.valueOf(withPrefix.replace(Role.prefix, ""));
    }

    public String withPrefix() {
        return prefix + this.toString();
    }

}
