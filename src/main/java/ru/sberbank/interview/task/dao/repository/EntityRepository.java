package ru.sberbank.interview.task.dao.repository;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import ru.sberbank.interview.task.dao.model.*;

import java.util.*;

@Repository
public interface EntityRepository extends CrudRepository<EntityDao, Long> {

    List<EntityDao> getEntityDaosByIdIn(List<Long> ids);
    List<EntityDao> getEntityDaosByCode(Integer code);
    List<EntityDao> getEntityDaosBySysname(String sysname);
    List<EntityDao> getAllBy();
}