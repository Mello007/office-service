package ru.office.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.office.entity.Court;

@RepositoryRestResource(collectionResourceRel = "court", path = "court")
public interface CourtRepository extends PagingAndSortingRepository<Court, Long> {

    @Transactional
    void deleteByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM court", nativeQuery = true)
    void deleteAll();
}
