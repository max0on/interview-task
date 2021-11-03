package ru.sberbank.interview.task.controller.dto.res;

import lombok.*;
import ru.sberbank.interview.task.controller.dto.support.*;

import java.util.*;

@AllArgsConstructor
public class GetListRes {

    private List<Entity> items;
    private Integer unread;
}
