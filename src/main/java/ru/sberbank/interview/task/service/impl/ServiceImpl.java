package ru.sberbank.interview.task.service.impl;


import lombok.*;
import org.springframework.stereotype.*;
import ru.sberbank.interview.task.controller.dto.res.*;
import ru.sberbank.interview.task.controller.dto.support.*;
import ru.sberbank.interview.task.dao.model.*;
import ru.sberbank.interview.task.dao.repository.*;
import ru.sberbank.interview.task.service.Service;

import java.util.*;
import java.util.stream.*;

@Component
@AllArgsConstructor
public class ServiceImpl implements Service {

    private final EntityRepository entityRepository;

    public List<?> getAllEntitiesByIdsOrMissingIds(List<Long> ids) {
        List<Entity> entities = getEntitiesByIds(ids);

        return entities.size() == ids.size() ? entities : getMissingIds(ids, entities);
    }

    public List<Entity> getEntitiesByIds(List<Long> ids) {
        return convertEntityDaosToDto(entityRepository.getEntityDaosByIdIn(ids));
    }

    private List<Long> getMissingIds(List<Long> ids, List<Entity> entities) {
        List<Long> res = new ArrayList<>();
        res.addAll(ids);
        res.removeAll(entities.stream().map(Entity::getId).collect(Collectors.toList()));

        return res;
    }

    public List<Entity> getEntitiesByCodeAndSysname(Integer code, String sysname) {
        List<Entity> res;

        if (code != null) {
            res = convertEntityDaosToDto(entityRepository.getEntityDaosByCode(code));
        } else if (sysname != null) {
            res = convertEntityDaosToDto(entityRepository.getEntityDaosBySysname(sysname));
        } else {
            res = convertEntityDaosToDto(entityRepository.getAllBy());
        }

        return res;
    }

    public GetListRes getList(String sysname) {
        List<Entity> entities = convertEntityDaosToDto(entityRepository.getEntityDaosBySysname(sysname));
        Long count = entities.stream().filter(w -> w.getWatchedDttm() == null).count();
        Integer unread = count.intValue();

        if (unread == 0) {
            entities = Collections.emptyList();
        }

        return new GetListRes(entities, unread);
    }

    private static List<Entity> convertEntityDaosToDto(List<EntityDao> entityDaos) {
        return entityDaos.stream().map(EntityDao::convertToEntityDto).collect(Collectors.toList());
    }
}
