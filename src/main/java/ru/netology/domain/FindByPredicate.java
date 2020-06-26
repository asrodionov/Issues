package ru.netology.domain;

import java.util.function.Predicate;

public class FindByPredicate implements Predicate<Issue> {
    @Override
    public boolean test(Issue issue) {
        return false;
    }
}
