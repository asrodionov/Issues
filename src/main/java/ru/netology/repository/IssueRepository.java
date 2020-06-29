package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssueRepository {
    private List<Issue> items = new ArrayList<>();

    public boolean add(Issue item) {
        return items.add(item);
    }

    public List<Issue> getAll() {
        return items;
    }

}
