package ra.demojpa.controler;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.demojpa.entity.Catalog;
import ra.demojpa.repository.ICatalogRepository;

@Controller
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final ICatalogRepository catalogRepository;
    @RequestMapping
    public String catalogList(Pageable pageable, Model model){
        Page<Catalog> page = catalogRepository.findAll(pageable);
        model.addAttribute("catalogs", page);
        String sort = page.getSort().toString().replace(": ",",");
        System.out.println(sort);
        model.addAttribute("sort", sort);
        return "catalog";
    }
}
