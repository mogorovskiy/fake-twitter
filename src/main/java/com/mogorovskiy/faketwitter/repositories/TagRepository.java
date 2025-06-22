package com.mogorovskiy.faketwitter.repositories;

import com.mogorovskiy.faketwitter.domain.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
