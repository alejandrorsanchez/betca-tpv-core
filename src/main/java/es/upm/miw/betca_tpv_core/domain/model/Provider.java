package es.upm.miw.betca_tpv_core.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Provider {
    @NotNull
    @NotBlank
    private String company;
    @NotNull
    @NotBlank
    private String nif;
    @NotNull
    @NotBlank
    private String phone;
    private String address;
    private String email;
    private String note;
    private Boolean active;

    public static Provider ofCompanyPhoneNote(Provider provider) {
        return Provider.builder()
                .company(provider.getCompany())
                .phone(provider.getPhone())
                .note(provider.getNote()).build();
    }

    public void doDefault() {
        if (Objects.isNull(active)) {
            this.active = true;
        }
    }

}
