package canard.intern.post.following.backend.dto;

import canard.intern.post.following.backend.enums.Gender;
import lombok.Builder;
import lombok.Data;
import validator.DateLessThan;

import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
@Builder

public class TraineeDto {
    private Integer id;

    @NotBlank
    private String lastname;

    @NotBlank
    private String firstname;
    private Gender gender;
    @DateLessThan
    private LocalDate birthdate;
    @Pattern(regexp = "(\\+33|0)[0-9]{9}")
    private String phoneNumber;
    @NotBlank
    @Email
    private String mail;

}
