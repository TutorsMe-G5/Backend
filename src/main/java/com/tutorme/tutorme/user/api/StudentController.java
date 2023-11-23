package com.tutorme.tutorme.user.api;

import com.tutorme.tutorme.shared.exeption.InternalServerErrorException;
import com.tutorme.tutorme.user.domain.model.entities.Student;
import com.tutorme.tutorme.user.domain.service.StudentService;
import com.tutorme.tutorme.user.mapping.StudentMapper;
import com.tutorme.tutorme.user.resource.CreateStudentResource;
import com.tutorme.tutorme.user.resource.StudentResource;
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

@Tag(name= "students", description = "Everything about the students.")
@AllArgsConstructor
@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @Operation(summary = "Add a new student account",
            description = "Add a new student",
            operationId = "addStudent",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = StudentResource.class)
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
    public ResponseEntity<StudentResource> save (@RequestBody CreateStudentResource resource){
        return new ResponseEntity<>(
                studentMapper.toResource(studentService.save(studentMapper.toEntity(resource))),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> fetchAll() {
        return ResponseEntity.ok(studentService.fetchAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentResource> fetchById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(
                studentMapper.toResource(studentService.fetchById(id)),
                HttpStatus.OK);
    }

    @GetMapping("name/{first_name}")
    public ResponseEntity<StudentResource> findByName(@PathVariable("first_name") String name){
        return new ResponseEntity<>(
                studentMapper.toResource(studentService.findByName(name)),
                HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){
        if (studentService.deleteById(id)){
            return ResponseEntity.noContent().build();
        }
        throw new InternalServerErrorException("Student", "id", String.valueOf(id), "deleted");
    }

}
