package fr.learn.jpaadvanced.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CourseDto {

    private Long id;

    @NotBlank(message = "Le nom du cours ne doit pas être vide")
    @Size(min = 5, max = 100, message = "Le nom du cours doit contenir entre 5 et 100 caractères")
    private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
