package ru.sberbank.interview.task.controller;

import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.interview.task.service.*;

import java.util.*;

@RestController
@RequestMapping("${spring.application.name}")
@AllArgsConstructor
public class ServiceController {

    private final Service service;

    @GetMapping
    public ResponseEntity<?> getAllEntitiesByIdsOrMissingIds(@RequestHeader(value = "ids", required = false) List<Long> ids,
                                                             @RequestParam(value = "code", required = false) Integer code,
                                                             @RequestParam(value = "sysname", required = false) String sysname) {
        if (ids != null) {
            return ResponseEntity.ok(service.getAllEntitiesByIdsOrMissingIds(ids));
        } else {
            return ResponseEntity.ok(service.getEntitiesByCodeAndSysname(code, sysname));
        }
    }

    @GetMapping("/{sysname}")
    public ResponseEntity<?> getList(@PathVariable String sysname) {
        return ResponseEntity.ok(service.getList(sysname));
    }
}