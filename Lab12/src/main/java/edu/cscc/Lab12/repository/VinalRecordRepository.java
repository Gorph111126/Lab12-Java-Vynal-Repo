package edu.cscc.Lab12.repository;
/*
 * @author Alexander Granville
 * @version 4/15/24;
 */

import org.springframework.data.repository.CrudRepository;

import edu.cscc.Lab12.model.VinalRecord;

public interface VinalRecordRepository extends CrudRepository<VinalRecord, Long > {

}
