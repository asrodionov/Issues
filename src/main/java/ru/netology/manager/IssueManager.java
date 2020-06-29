package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.domain.Predicates;
import ru.netology.repository.IssueRepository;

import java.util.*;

public class IssueManager {

    private IssueRepository repository;

    public void IssueRepository(IssueRepository repository) {
        this.repository = repository;
    }

    public void add(Issue item) {
        repository.add(item);
    }

    private List<Issue> getIssueByStatus(boolean status) {
        List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {
            if (issue.isOpen() == status) {
                result.add(issue);
            }
        }
        return result;
    }


    public List<Issue> getOpenIssue() {
        return getIssueByStatus(true);
    }

    public List<Issue> getClosedIssue() {
        return getIssueByStatus(false);
    }

    public List<Issue> filterByAuthor(String author) {
        List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {
            if (Predicates.filterByAuthor(author).test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> filterByLabel(String label) {
        List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {
            if (Predicates.filterByLabel(label).test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> filterByAssignee(String assignee) {
        List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {
            if (Predicates.filterByAssignee(assignee).test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> filterByParticipant(String participant) {
        List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {
            if (Predicates.filterByParticipant(participant).test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> sortByAsc() {
        List<Issue> result = repository.getAll();

        result.sort(null);
        return result;
    }

    public List<Issue> sortByDesc(Comparator<Issue> comparator) {
        List<Issue> result = repository.getAll();

        result.sort(comparator);
        return result;
    }

    public Issue openingIssue(int id) {
        for (Issue issue : repository.getAll()) {
            if (issue.getId() == id && !issue.isOpen()) {
                issue.setOpen(true);
                return  issue;
            }
        }
        return null;
    }

    public Issue closedIssue(int id) {
        for (Issue issue : repository.getAll()) {
            if (issue.getId() == id && issue.isOpen()) {
                issue.setOpen(false);
                return issue;
            }
        }
        return null;
    }


}
