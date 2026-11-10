package edu.cscc.Lab12.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.cscc.Lab12.model.VinalRecord;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UnsafeVinalRecordRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<VinalRecord> findByTitle(String title) {

        String sql = "SELECT * FROM vinal_record WHERE title = '"
                + title + "'";

        return entityManager
                .createNativeQuery(sql, VinalRecord.class)
                .getResultList();
    }
}