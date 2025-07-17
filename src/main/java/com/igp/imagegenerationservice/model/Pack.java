package com.igp.imagegenerationservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * @author Achintha Kalunayaka
 * @since 5/15/2025
 */

@Entity
public class Pack {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "pack")
    private List<PackPrompt> packPromptList;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PackPrompt> getPackPromptList() {
        return packPromptList;
    }

    public void setPackPromptList(List<PackPrompt> packPromptList) {
        this.packPromptList = packPromptList;
    }
}
