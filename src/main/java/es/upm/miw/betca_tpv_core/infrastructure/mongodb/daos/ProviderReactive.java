package es.upm.miw.betca_tpv_core.infrastructure.mongodb.daos;

import es.upm.miw.betca_tpv_core.infrastructure.mongodb.entities.ProviderEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProviderReactive extends ReactiveSortingRepository< ProviderEntity, String > {
    Mono< ProviderEntity > findByCompany(String company);

    Mono< ProviderEntity > findByNif(String nif);

    @Query("{$and:[" // allow NULL in barcode
            + "?#{ [0] == null ? {_id : {$ne:null}} : { company : {$regex:[0], $options: 'i'} } }," //$where : 'true'
            + "{active : true}"
            + "] }")
    Flux< ProviderEntity > findByCompanyAndActiveIsTrueNullSave(String company);

    @Query("{$and:[" // allow NULL: all elements
            + "?#{ [0] == null ? {_id : {$ne:null}} : { company : {$regex:[0], $options: 'i'} } },"
            + "?#{ [1] == null ? {_id : {$ne:null}} : { nif : {$regex:[1], $options: 'i'} } },"
            + "?#{ [2] == null ? {_id : {$ne:null}} : { phone : {$regex:[2], $options: 'i'} } },"
            + "?#{ [3] == null ? {_id : {$ne:null}} : { note :{$regex:[3], $options: 'i'} }  }"
            + "] }")
    Flux< ProviderEntity > findByCompanyAndNifAndSPhoneAndNoteNullSafe(
            String company, String nif, String phone, String note);
}
