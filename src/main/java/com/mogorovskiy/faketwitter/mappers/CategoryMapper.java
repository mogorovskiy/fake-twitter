package com.mogorovskiy.faketwitter.mappers;

import com.mogorovskiy.faketwitter.domain.PostStatus;
import com.mogorovskiy.faketwitter.domain.dto.CategoryDto;
import com.mogorovskiy.faketwitter.domain.dto.CreateCategoryRequest;
import com.mogorovskiy.faketwitter.domain.entities.Category;
import com.mogorovskiy.faketwitter.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequest createCategoryRequest);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (null == posts || posts.isEmpty()) {
            return 0;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
