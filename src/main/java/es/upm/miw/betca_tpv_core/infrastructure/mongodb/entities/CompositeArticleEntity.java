package es.upm.miw.betca_tpv_core.infrastructure.mongodb.entities;

import es.upm.miw.betca_tpv_core.domain.model.TreeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "articlesTree")
public class CompositeArticleEntity extends ArticlesTreeEntity {
    private String description;
    @DBRef(lazy = true)
    private List< ArticlesTreeEntity > articlesTreeEntityList;

    public CompositeArticleEntity(String reference, TreeType treeType, String description) {
        super(reference, treeType);
        this.description = description;
        this.articlesTreeEntityList = new ArrayList<>();
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void add(ArticlesTreeEntity articlesTreeEntityList) {
        this.articlesTreeEntityList.add(articlesTreeEntityList);
    }

    @Override
    public void remove(ArticlesTreeEntity articlesTreeEntityList) {
        this.articlesTreeEntityList.remove(articlesTreeEntityList);
    }

    @Override
    public List< ArticlesTreeEntity > contents() {
        return this.articlesTreeEntityList;
    }

    @Override
    public String toString() {
        return "CompositeArticleEntity{" +
                "description='" + description + '\'' +
                ", articlesTreeEntityList=" + articlesTreeEntityList +
                "} " + super.toString();
    }
}
