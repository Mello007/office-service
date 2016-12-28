package ru.office.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.office.entity.Education;

@RepositoryRestResource(collectionResourceRel = "education", path = "education")
public interface EducationRepository extends PagingAndSortingRepository<Education, Long> {

    @Transactional
    void deleteByNameOfAdvocate(@Param("nameOfAdvocate") String nameOfAdvocate);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM education", nativeQuery = true)
    void deleteAll();
}
