package hu.me.iit.firstSpring;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ArticleRepositoryMemoryImplTest {

    void findAll_Empty() {
        //GIVEN
        ArticleRepositoryMemoryImpl articleRepositoryMemoryImpl = new ArticleRepositoryMemoryImpl();

        //WHEN
        List<ArticleDto> result = articleRepositoryMemoryImpl.findAll();

        //THEN
        assertEquals(0, result.size());
    }

    @Test
    void findAll_NotEmpty() {
        //GIVEN
        ArticleRepositoryMemoryImpl articleRepositoryMemoryImpl = new ArticleRepositoryMemoryImpl();
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(2L);
        articleDto.setTitle("title");

        articleRepositoryMemoryImpl.save(articleDto);

        // WHEN
        List<ArticleDto> result = articleRepositoryMemoryImpl.findAll();

        // THEN
        assertEquals(1, result.size());
        assertEquals(articleDto, result.get(0));
    }

    @Test
    void findById() {
        //GIVEN
        ArticleRepositoryMemoryImpl articleRepositoryMemoryImpl = new ArticleRepositoryMemoryImpl();
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(2L);
        articleDto.setTitle("title");

        articleRepositoryMemoryImpl.save(articleDto);

        //WHEN
        List<ArticleDto> result = articleRepositoryMemoryImpl.findAll();

        //THEN
        assertEquals(1, result.size());
        assertEquals(articleDto, result.get(0));

    }

    @Test
    void findArticleById() {
        //GIVEN
        ArticleRepositoryMemoryImpl articleRepositoryMemoryImpl = new ArticleRepositoryMemoryImpl();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemoryImpl.save(articleDto);

        //WHEN
        int result = articleRepositoryMemoryImpl.findArticleById(id);

        //THEN
        assertEquals(0, result);
    }

    @Test
    void findArticleById_NotFound() {
        //GIVEN
        ArticleRepositoryMemoryImpl articleRepositoryMemoryImpl = new ArticleRepositoryMemoryImpl();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemoryImpl.save(articleDto);

        //WHEN
        int result = articleRepositoryMemoryImpl.findArticleById(id);

        //THEN
        assertEquals(0, result);

    }

    @Test
    void deleteById_exists() {
        // GIVEN
        ArticleRepositoryMemoryImpl articleRepositoryMemoryImpl = new ArticleRepositoryMemoryImpl();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemoryImpl.save(articleDto);

        // WHEN
        articleRepositoryMemoryImpl.deleteById(id);

        // THEN
        assertEquals(0, articleRepositoryMemoryImpl.findAll().size());
    }

    @Test
    void deleteById_notExists() {
        //GIVEN
        ArticleRepositoryMemoryImpl articleRepositoryMemoryImpl = new ArticleRepositoryMemoryImpl();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemoryImpl.save(articleDto);

        // WHEN
        articleRepositoryMemoryImpl.deleteById(notExistsId);

        // THEN
        assertEquals(1, articleRepositoryMemoryImpl.findAll().size());
    }

    @Test
    void getById_notExists() {
        // GIVEN
        ArticleRepositoryMemoryImpl articleRepositoryMemoryImpl = new ArticleRepositoryMemoryImpl();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemoryImpl.save(articleDto);

        // WHEN
        ArticleDto dto = articleRepositoryMemoryImpl.getById(notExistsId);

        // THEN
        assertNull(dto);
    }

    @Test
    void getById_Exists() {
        // GIVEN
        ArticleRepositoryMemoryImpl articleRepositoryMemoryImpl = new ArticleRepositoryMemoryImpl();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemoryImpl.save(articleDto);

        // WHEN
        ArticleDto dto = articleRepositoryMemoryImpl.getById(id);

        // THEN
        assertEquals(articleDto, dto);
    }

    @Test
    void save_update() {
        //GIVEN
        ArticleRepositoryMemoryImpl articleRepositoryMemoryImpl = new ArticleRepositoryMemoryImpl();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemoryImpl.save(articleDto);

        //WHEN
        ArticleDto articleDto2 = new ArticleDto();
        articleDto2.setAuthor("Author 2");
        articleDto2.setPages(14);
        articleDto2.setId(id);
        articleDto2.setTitle("title 2");

        articleRepositoryMemoryImpl.save(articleDto2);

        //THEN
        List<ArticleDto> articleDtoList = articleRepositoryMemoryImpl.findAll();
        assertEquals(1, articleDtoList.size());

        assertEquals(articleDto2, articleDtoList.get(0));
    }
}