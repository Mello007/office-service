package ru.office.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.office.entity.CaseService;

@RepositoryRestResource(collectionResourceRel = "case", path = "case")
public interface CaseRepository extends PagingAndSortingRepository<CaseService, Long> {

    @Transactional
    void deleteByAdvocate(@Param("advocate") String advocate);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM case", nativeQuery = true)
    void deleteAll();

}
