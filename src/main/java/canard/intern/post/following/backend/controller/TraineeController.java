package canard.intern.post.following.backend.controller;

import canard.intern.post.following.backend.dto.TraineeDto;
import canard.intern.post.following.backend.enums.Gender;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/trainees")

public class TraineeController {

    @GetMapping
    public List<TraineeDto> getAll () {
        return List.of(
                TraineeDto.builder()
                        .id(1)
                        .lastname("Aubert")
                        .firstname("Jean-Luc")
                        .gender(Gender.M)
                        .birthdate(LocalDate.of(1968, 4, 30))
                        .build(),
                TraineeDto.builder()
                        .id(3)
                        .lastname("Connor")
                        .firstname("Sarah")
                        .gender(Gender.F)
                        .birthdate(LocalDate.of(1982, 11, 24))
                        .build(),
                TraineeDto.builder()
                        .id(5)
                        .lastname("Delepch")
                        .firstname("Mathieu")
                        .gender(Gender.M)
                        .birthdate(LocalDate.of(1991, 07, 25))
                        .build(),
                TraineeDto.builder()
                        .id(4)
                        .lastname("Sake")
                        .firstname("Frodon")
                        .gender(Gender.M)
                        .birthdate(LocalDate.of(850, 05, 24))
                        .build()
        );
    }

    @GetMapping("/{id}")
    public TraineeDto getById(@PathVariable("id") int id) {
        return TraineeDto.builder()
                .id(id)
                .lastname("Moneypenny")
                .firstname("Miss")
                .gender(Gender.F)
                .build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TraineeDto create(@Valid @RequestBody TraineeDto traineeDto) {   /** créer un nouveau TraineeDtdo juste avec l'id mais le reste est null, @Valid = */
        traineeDto.setId(10);
        return traineeDto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable ("id") int id) {
        //TODO: remive Trainee with this id
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public TraineeDto upDate(
            @Valid @RequestBody TraineeDto traineeDto,
            @PathVariable ("id") int id
    ){
        if (traineeDto.getId() == null && (traineeDto.getId() != id)) {
            throw new RuntimeException();
        }

        return traineeDto;
    }
}

