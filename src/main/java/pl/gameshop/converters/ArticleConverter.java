package pl.gameshop.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.gameshop.domain.model.Article;
import pl.gameshop.domain.repository.ArticleRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class ArticleConverter implements Converter<Long, Article>
{
    private ArticleRepository articleRepository;

    @Override
    public Article convert(Long src)
    {
        return Optional.of(src)
                .map(articleRepository::getById)
                .orElseThrow(IllegalStateException::new);
    }
}
