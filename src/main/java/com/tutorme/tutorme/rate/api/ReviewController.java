package com.tutorme.tutorme.rate.api;

import com.tutorme.tutorme.rate.domain.model.entities.Review;
import com.tutorme.tutorme.rate.domain.service.ReviewService;
import com.tutorme.tutorme.rate.mapping.ReviewMapper;
import com.tutorme.tutorme.rate.resource.CreateReviewResource;
import com.tutorme.tutorme.rate.resource.ReviewResource;
import com.tutorme.tutorme.shared.exeption.InternalServerErrorException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name= "reviews", description = "All the reviews.")
@AllArgsConstructor
@RestController
@RequestMapping("reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    @PostMapping
    public ResponseEntity<ReviewResource> save(@RequestBody CreateReviewResource resource){
        return new ResponseEntity<>(
                reviewMapper.toResource(reviewService.save(reviewMapper.toEntity(resource))), HttpStatus.CREATED);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")//enable request from this origin
    public ResponseEntity<List<Review>> fetchAll(){
        return ResponseEntity.ok(reviewService.fetchAll());
    }

    @GetMapping("rate/{rate}")
    public ResponseEntity<List<Review>> fetchByRate(@PathVariable("rate")int rate){
        return ResponseEntity.ok(reviewService.fetchByRate(rate));
    }
    @GetMapping("teacher/{teacherId}")
    public ResponseEntity<List<Review>> fetchByTeacherId(@PathVariable("teacherId")Integer teacherId){
        return ResponseEntity.ok(reviewService.fetchByTeacherId(teacherId));
    }


    @GetMapping("{id}")
    public ResponseEntity<ReviewResource> fetchbyId(@PathVariable("id") Integer id){
        return new ResponseEntity<>(
                reviewMapper.toResource(reviewService.fetchById(id)),
                HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){
        if(reviewService.deleteById(id)){
            return ResponseEntity.noContent().build();
        }
        throw new InternalServerErrorException("Review", "id", String.valueOf(id), "deleted");
    }

}
