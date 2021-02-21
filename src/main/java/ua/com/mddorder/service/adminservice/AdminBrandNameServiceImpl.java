package ua.com.mddorder.service.adminservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.com.mddorder.model.BrandName;
import ua.com.mddorder.repository.BrandNameRepository;
import ua.com.mddorder.service.BrandNameService;

import java.util.List;

@Service
public class AdminBrandNameServiceImpl implements BrandNameService {

    private final BrandNameRepository brandNameRepository;

    @Autowired
    public AdminBrandNameServiceImpl(BrandNameRepository brandNameRepository) {
        this.brandNameRepository = brandNameRepository;
    }


    @Override
    public void delete(Long id) {
        brandNameRepository.deleteOne(id);
    }

    @Override
    public BrandName addNewBrandName(BrandName brandName) {
        return null;
    }

    @Override
    public List getAll() {
        return brandNameRepository.findAll();
    }

    @Override
    public BrandName findById(Long id) {
        return brandNameRepository.getOne(id);
    }

    @Override
    public void deleteOne(Long id) {

    }

    @Override
    public BrandName save(BrandName brandName) {
        return brandNameRepository.save(brandName);
    }

    @Override
    public void update(Long id, BrandName brandName) {

    }
}
