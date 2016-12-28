package ru.office.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.office.entity.Advocate;

@RepositoryRestResource(collectionResourceRel = "advocate", path = "advocate")
public interface AdvocateRepository extends PagingAndSortingRepository<Advocate, Long> {

    @Transactional
    void deleteByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM advocate", nativeQuery = true)
    void deleteAll();
}
