package com.igp.imagegenerationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String userName;

    private String profilePicture;
}
