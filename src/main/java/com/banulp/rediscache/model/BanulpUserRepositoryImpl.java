package com.banulp.rediscache.model;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class BanulpUserRepositoryImpl implements BanulpUserRepository {

    private RedisTemplate<String, BanulpUser> redisTemplate;
    private HashOperations hashOperations; //to access Redis cache

    public BanulpUserRepositoryImpl(RedisTemplate<String, BanulpUser> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(BanulpUser user) {
        hashOperations.put("BANULPUSER", user.getUid(), user);
    }

    @Override
    public Map<String, BanulpUser> findAll() {
        return hashOperations.entries("BANULPUSER");
    }

    @Override
    public BanulpUser findById(String id) {
        return (BanulpUser) hashOperations.get("BANULPUSER", id);
    }

    @Override
    public void update(BanulpUser user) {
        save(user);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("BANULPUSER", id);
    }
}
