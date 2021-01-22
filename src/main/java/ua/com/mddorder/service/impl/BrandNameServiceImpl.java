package ua.com.mddorder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.mddorder.model.BrandName;
import ua.com.mddorder.repository.BrandNameRepository;
import ua.com.mddorder.service.RootCrudService;

import java.util.List;

@Service
public class BrandNameServiceImpl implements RootCrudService<BrandName> {

    private final BrandNameRepository brandNameRepository;

    @Autowired
    public BrandNameServiceImpl(BrandNameRepository brandNameRepository) {
        this.brandNameRepository = brandNameRepository;
    }

    @Override
    public List<? extends BrandName> getAll() {
        return brandNameRepository.findAll();
    }

    @Override
    public BrandName getOne(Long id) {
        return brandNameRepository.getOne(id);
    }

    @Override
    public void create(BrandName brandName) {

    }

    @Override
    public void update(Long id, BrandName brandName) {

    }

    @Override
    public void delete(BrandName brandName) {

    }
}
