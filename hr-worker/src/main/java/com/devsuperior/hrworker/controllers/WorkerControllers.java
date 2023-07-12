package com.devsuperior.hrworker.controllers;

import com.devsuperior.hrworker.entities.WorkerEntity;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerControllers {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    private ResponseEntity<List<WorkerEntity>> findAllWorkers(){
        List<WorkerEntity> workers = workerRepository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<WorkerEntity> findWorkerById(@PathVariable Long id){
        Optional<WorkerEntity> worker = workerRepository.findById(id);
        return ResponseEntity.ok(worker.get());
    }
}
