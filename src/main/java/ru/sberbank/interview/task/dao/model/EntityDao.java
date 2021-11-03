package ru.sberbank.interview.task.dao.model;

import lombok.*;
import ru.sberbank.interview.task.controller.dto.support.Entity;
import javax.persistence.*;
import java.util.*;

@javax.persistence.Entity
@Table(name = "entity")
@Data
public class EntityDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK
    @Column(name = "code")
    private Integer code;
    @Column(name = "sysname")
    private String sysname;
    @Column(name = "watchedDttm")
    private Date watchedDttm;
    @Column(name = "description")
    private String description;
    @Column(name = "data")
    private String data;

    public Entity convertToEntityDto() {
        Entity dto = new Entity();

        dto.setId(this.id);
        dto.setCode(this.code);
        dto.setSysname(this.sysname);
        dto.setWatchedDttm(this.watchedDttm);
        dto.setDescription(this.description);
        dto.setData(this.data);

        return dto;
    }
}