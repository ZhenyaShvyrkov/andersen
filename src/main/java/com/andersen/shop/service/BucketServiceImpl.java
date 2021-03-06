package com.andersen.shop.service;

import com.andersen.shop.model.Product;
import com.andersen.shop.dao.BucketDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BucketServiceImpl implements BucketService {
    private final BucketDao bucketDao;

    public BucketServiceImpl(BucketDao bucketDao) {
        this.bucketDao = bucketDao;
    }

    @Override
    @Transactional()
    public void addProductToUserBucketById(int userId, int id) {
        bucketDao.addProductToUserBucketById(userId, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAll(int userId) {
        return bucketDao.getAll(userId);
    }

    @Override
    @Transactional()
    public void removeProductById(int userId, int id) {
        bucketDao.removeProductById(userId, id);
    }
}
