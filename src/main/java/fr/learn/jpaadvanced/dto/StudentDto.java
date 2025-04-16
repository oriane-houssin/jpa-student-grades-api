package fr.learn.jpaadvanced.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentDto {
    private Long id;

    @NotBlank(message = "Le prénom ne doit pas être vide")
    @Size(min = 2, max = 100, message = "Le prénom doit contenir entre 2 et 100 caractères")
    private String firstName;

    @NotBlank(message = "Le nom de famille ne doit pas être vide")
    @Size(min = 2, max = 100, message = "Le nom de famille doit contenir entre 2 et 100 caractères")
    private String lastName;

    @NotBlank(message = "l'adresse mail ne peut pas être vide")
    @Size(min = 10, max = 100, message = "L'adresse mail doit contenir entre 10 et 100 caractères")
    @Email
    private String email;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
