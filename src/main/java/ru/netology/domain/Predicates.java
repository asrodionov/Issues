package ru.netology.domain;

import java.util.function.Predicate;

public class Predicates {
    public static Predicate<Issue> filterByAuthor(String author) {
        return p -> p.getAuthor().equalsIgnoreCase(author);
    }

    public static Predicate<Issue> filterByAssignee(String assignee) {
        return p -> p.getAssignee().contains(assignee);
    }

    public static Predicate<Issue> filterByLabel(String label) {
        return p -> p.getLabel().contains(label);
    }

    public static Predicate<Issue> filterByParticipant(String participant) {
        return p -> p.getParticipant().contains(participant);
    }
}
