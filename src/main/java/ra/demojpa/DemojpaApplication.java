package ra.demojpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

import ra.demojpa.dto.CatalogDto;
import ra.demojpa.repository.ICatalogRepository;

import java.util.List;

@SpringBootApplication
public class DemojpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemojpaApplication.class, args);

	}
	@Bean
	public CommandLineRunner runner(ICatalogRepository catalogRepository){
		return args -> {
//			ra.demojpa.entity.Catalog cat = new ra.demojpa.entity.Catalog(null, "Thời trang Nam","Thu đông",true)	;
//			catalogRepository.save(cat); // vừa thêm mới vừa cập nhật
//			catalogRepository.
			Sort sort = Sort.by("catalogName").descending();
			Pageable pageable = PageRequest.of(0,2,sort);
			Page<ra.demojpa.entity.Catalog> page =  catalogRepository.findByCatalogNameContaining("t",pageable);
			List<CatalogDto> catalogDtos = catalogRepository.findCatalogNameAndId();
			System.out.println();
		};
	}

}
