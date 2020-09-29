package com.estudo.service;

import com.estudo.domain.Category;
import com.estudo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    private final Logger log = Logger.getLogger( CategoryService.class.getName() );

    public String saveCategory(Category category) {
        if(!StringUtils.isEmpty(category.getName())) {
            log.info("Entrou em salvar ein!");
            repository.save(category);
            return "Sucesso ao salvar a categoria!";
        }
        log.info("O nome da categoria veio vazio.");
        return "Falha ao salvar a categoria!";
    }

    public List<Category> getAllCategory() {
        log.info("Chamando buscar todas categorias");
        Iterable<Category> categoryIterable = repository.findAll();
        List<Category> categoryList = new ArrayList<>();
        categoryIterable.forEach(categoryList::add);
        System.out.println(categoryList.toString());
        return categoryList;
    }

    public String deleteCategoryById(Integer categoryId) {
        repository.deleteById(categoryId);
        return "Foi";
    }

}
