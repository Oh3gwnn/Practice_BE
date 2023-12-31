package com.example.article;

import com.example.article.dto.ArticleDto;
import com.example.article.entity.ArticleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;

    public ArticleDto createArticle(ArticleDto dto) {
        ArticleEntity newArticle = new ArticleEntity();
        newArticle.setTitle(dto.getTitle());
        newArticle.setContent(dto.getContent());
        newArticle.setWriter(dto.getWriter());
        return ArticleDto.fromEntity(repository.save(newArticle));
    }

    public ArticleDto readArticle(Long id) {
        Optional<ArticleEntity> optionalArticle = repository.findById(id);
        if (optionalArticle.isPresent()) return ArticleDto.fromEntity(optionalArticle.get());
        else throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    public List<ArticleDto> readArticleAll() {
        List<ArticleDto> articleList = new ArrayList<>();
        for (ArticleEntity entity: repository.findAll()) {
            articleList.add(ArticleDto.fromEntity(entity));
        }
        return articleList;
    }

    public ArticleDto updateArticle(Long id, ArticleDto dto) {
        Optional<ArticleEntity> optionalArticle = repository.findById(id);
        if (optionalArticle.isPresent()) {
            ArticleEntity article = optionalArticle.get();
            article.setWriter(dto.getWriter());
            article.setTitle(dto.getTitle());
            article.setContent(dto.getContent());
            repository.save(article);
            return ArticleDto.fromEntity(article);
        }
        else throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    public void deleteArticle(Long id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Page<ArticleDto> readArticlePaged(Integer pageNumber, Integer pageSize) {
        // PagingAndSortingRepository 메서드에 전달하는 용도
        // 조회하고 싶은 페이지의 정보를 담는 객체
        // 20개씩 데이터를 나눌 때 0번 페이지를 달라고 요청하는 Pageable
        // 3번째 인자 - Sort, 역순 적용
        Pageable pageable = PageRequest.of(0, 20, Sort.by("id").descending());
        Page<ArticleEntity> articleEntityPage = repository.findAll(pageable);

//        List<ArticleDto> articleDtoList = new ArrayList<>();
//        for (ArticleEntity entity: articleEntityPage) {
//            articleDtoList.add(ArticleDto.fromEntity(entity));
//        }
//        return articleDtoList;

        // map -> 전달받은 함수를 각 원소에 인자로 전달한 결과를 다시 모아서 Stream으로
        // Page.map -> 전달받은 함수를 각 원소에 인자로 전달한 결과를 다시 모아서 Page으로
        Page<ArticleEntity> articleEntities = repository.findAll(pageable);
        Page<ArticleDto> articleDtoPage // Page.map()
                = articleEntityPage.map(ArticleDto::fromEntity);
        return articleDtoPage;
    }
}
