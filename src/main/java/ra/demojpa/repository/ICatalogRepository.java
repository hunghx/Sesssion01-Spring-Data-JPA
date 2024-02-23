package ra.demojpa.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import ra.demojpa.dto.CatalogDto;
import ra.demojpa.entity.Catalog;

import java.util.List;

public interface ICatalogRepository extends JpaRepository<Catalog,String> {
    Page<Catalog> findByCatalogNameContaining(String name, Pageable pageable);

    @Query("select new ra.demojpa.dto.CatalogDto(C.catalogId,C.catalogName) from Catalog C") // JPQL
    List<CatalogDto> findCatalogNameAndId();
}
