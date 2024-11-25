package com.java5.ps36645_lab3.Model;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @NotBlank(message = "{NotEmpty.student.name}")
    String name;

    @NotBlank(message = "{NotEmpty.student.email}")
    @Email
    String email;

    @Min(0)
    @Max(10)
    @NotNull(message = "{NotEmpty.student.mark}")
    Double mark;

    @NotBlank(message = "{NotEmpty.student.gender}")
    String gender;

    @NotBlank(message = "{NotEmpty.student.faculty}")
    String faculty;

    @NotBlank(message = "{NotEmpty.student.hobby}")
    String hobby;
    MultipartFile image;

    public enum genders {
        Male,
        Female,
        Other
    }

    public enum faculties {
        CNTT,
        QTKD,
        TKDH,
        QLNHKS
    }

    public enum hobbies {
        Reading,
        Music,
        Sport,
        Travel,
        Cooking,
        Other
    }
}
