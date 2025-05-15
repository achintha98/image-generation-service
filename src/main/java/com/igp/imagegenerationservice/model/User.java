package com.igp.imagegenerationservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */

@Entity
@Table(name = "users") // ✅ avoid reserved keyword
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String userName;

    private String profilePicture;

    private LocalDate createAt;

    private LocalDate updateAt;
}
