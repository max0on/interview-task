package ru.sberbank.interview.task.controller.dto.support;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@NoArgsConstructor
@Data
public class Entity {

    @JsonProperty("entityId")
    private Long id; // В json это поле должно называться entityId
    private Integer code;
    @JsonIgnore
    private String sysname; // В json этого поля не должно быть
    @JsonProperty("watched")
    private Date watchedDttm; // В json это поле должно называться watched
    private String description;
    private String data;

}
