package ru.sberbank.interview.task.service;

import ru.sberbank.interview.task.controller.dto.res.*;
import ru.sberbank.interview.task.controller.dto.support.*;

import java.util.*;

public interface Service {
    List<?> getAllEntitiesByIdsOrMissingIds(List<Long> ids);
    List<Entity> getEntitiesByIds(List<Long> ids);
    List<Entity> getEntitiesByCodeAndSysname(Integer code, String sysname);
    GetListRes getList(String sysname);
}
