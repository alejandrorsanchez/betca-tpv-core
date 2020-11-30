package es.upm.miw.betca_tpv_core.infrastructure.mongodb.daos;

import es.upm.miw.betca_tpv_core.infrastructure.mongodb.entities.ArticleEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ArticleReactive extends ReactiveSortingRepository< ArticleEntity, String > {
    Mono< ArticleEntity > findByBarcode(String barcode);

    @Query("{$and:[" // allow NULL: all elements
            + "?#{ [0] == null ? { $where : 'true'} : { barcode : {$regex:[0], $options: 'i'} } },"
            + "?#{ [1] == null ? { $where : 'true'} : { description : {$regex:[1], $options: 'i'} } },"
            + "?#{ [2] == null ? { $where : 'true'} : { reference : {$regex:[2], $options: 'i'} } },"
            + "?#{ [3] == null ? { $where : 'true'} : { stock : {$lt:[3]} } },"
            + "?#{ [4] == null ? { $where : 'true'} : { discontinued : [4] } }"
            + "] }")
    Flux< ArticleEntity > findByBarcodeAndDescriptionAndReferenceAndStockLessThanAndDiscontinuedNullSafe(
            String barcode, String description, String reference, Integer stock, Boolean discontinued);

    Flux< ArticleEntity > findByProviderEntityIsNull();

    @Query("{$and:[" // allow NULL in barcode
            + "?#{ [0] == null ? { $where : 'true'} : { barcode : {$regex:[0], $options: 'i'} } },"
            + "{discontinued : false}"
            + "] }")
    Flux< ArticleEntity > findByBarcodeLikeAndNotDiscontinuedNullSafe(String barcode);
}
