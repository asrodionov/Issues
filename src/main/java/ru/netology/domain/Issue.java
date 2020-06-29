package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Issue implements Comparable<Issue>{
    private int id;
    private String name;
    private boolean isOpen;
    private String author;
    public LocalDate openingDate = LocalDate.now();
    private String text;
    private Set<String> label = new HashSet<>();
    private Set<String> assignee = new HashSet<>();
    private Set<String> participant = new HashSet<>();

    @Override
    public int compareTo(Issue o) {
        return id - o.id;
    }

}

