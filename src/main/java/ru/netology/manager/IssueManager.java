package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.domain.Predicates;
import ru.netology.repository.IssueRepository;

import java.util.*;

public class IssueManager {

    IssueRepository repository = new IssueRepository();

    public void add(Issue item) {
        repository.add(item);
    }

    public List<Issue> getOpenIssue() {
        List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {
            if (issue.getStatus() == "open") {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> getClosedIssue() {
        List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {
            if (issue.getStatus() == "closed") {
                result.add(issue);
            }
        }
        return result;
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

    public List<Issue> SortByAsc() {
        List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {
            result.add(issue);
        }
        result.sort(null);
        return result;
    }

    public List<Issue> SortByDesc(Comparator<Issue> comparator) {
        List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {
            result.add(issue);
        }
        result.sort(comparator);
        return result;
    }

    public List<Issue> OpeningIssue(int id) {
        List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {
            if (issue.getId() == id && issue.getStatus() == "closed") {
                result.add(issue);
                result.get(0).setStatus("open");
                return result;
            }
        }
        return null;
    }

    public List<Issue> ClosedIssue(int id) {
        List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {
            if (issue.getId() == id && issue.getStatus() == "open") {
                result.add(issue);
                result.get(0).setStatus("closed");
                return result;
            }
        }
        return null;
    }
}
