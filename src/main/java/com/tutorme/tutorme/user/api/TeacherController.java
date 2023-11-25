package com.tutorme.tutorme.user.api;

import com.tutorme.tutorme.shared.exeption.InternalServerErrorException;
import com.tutorme.tutorme.user.domain.model.entities.Teacher;
import com.tutorme.tutorme.user.domain.service.TeacherService;
import com.tutorme.tutorme.user.mapping.TeacherMapper;
import com.tutorme.tutorme.user.resource.CreateTeacherResource;
import com.tutorme.tutorme.user.resource.TeacherResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name= "teachers", description = "Everything about the teachers.")
@AllArgsConstructor
@RestController
@RequestMapping("teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @CrossOrigin(origins = "http://localhost:4200")//enable request from this origin
    @Operation(summary = "Add a new teacher account",
            description = "Add a new teacher",
            operationId = "addTeacher",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TeacherResource.class)
                            )
                    ),@ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RuntimeException.class)
                    )
            )
            }
    )
    @PostMapping
    public ResponseEntity<TeacherResource> save (@RequestBody CreateTeacherResource resource){
        return new ResponseEntity<>(
                teacherMapper.toResource(teacherService.save(teacherMapper.toEntity(resource))),
                HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")//enable request from this origin
    @PutMapping("{id}")
    public ResponseEntity<TeacherResource> update(@PathVariable("id") Integer id, CreateTeacherResource resource){
        return new ResponseEntity<>(
                teacherMapper.toResource(teacherService.update(id, teacherMapper.toEntity(resource))),
                HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")//enable request from this origin
    @GetMapping
    public ResponseEntity<List<Teacher>> fetchAll(){
        return ResponseEntity.ok(teacherService.fetchAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")//enable request from this origin
    @GetMapping("{id}")
    public ResponseEntity<TeacherResource> fetchById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(
                teacherMapper.toResource(teacherService.fetchById(id)),
                HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")//enable request from this origin
    @GetMapping("auth/{mail}/{password}")
    public ResponseEntity<TeacherResource> fetchByMailAndPassword(@PathVariable("mail") String mail, @PathVariable("password") String password){
        return new ResponseEntity<>(
                teacherMapper.toResource(teacherService.findByMailAndPassword(mail, password)),
                HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")//enable request from this origin
    @GetMapping("name/{first_name}")
    public ResponseEntity<TeacherResource> findByName(@PathVariable("first_name") String name){
        return ResponseEntity.ok(
                teacherMapper.toResource(teacherService.findByName(name)));
    }

    @CrossOrigin(origins = "http://localhost:4200")//enable request from this origin
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){
        if (teacherService.deleteById(id)){
            return ResponseEntity.noContent().build();
        }
        throw new InternalServerErrorException("Teacher", "id", String.valueOf(id), "deleted");
    }
}
