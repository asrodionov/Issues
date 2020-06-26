package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Issue;
import ru.netology.domain.IssueDescComparator;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class EmptyIssueManagerTest {
    @Mock
    private IssueRepository repository;
    @InjectMocks
    private IssueManager manager;

    @Test
    public void shouldGetOpenIssue() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.getOpenIssue();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetClosedIssue() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.getClosedIssue();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAuthor() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.filterByAuthor("arodionov");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByLabel() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.filterByLabel("component: Jupiter");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAssignee() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.filterByAssignee("sormuras");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByParticipant() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.filterByParticipant("marcphilipp");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByAsc() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.SortByAsc();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByDesc() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        IssueDescComparator comparator = new IssueDescComparator();

        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.SortByDesc(comparator);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldOpeningIssue() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = null;
        List<Issue> actual = manager.OpeningIssue(2336);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCloseIssue() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = null;
        List<Issue> actual = manager.ClosedIssue(2336);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldOpeningNonexistentIssue() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = null;
        List<Issue> actual = manager.OpeningIssue(2);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCloseNonexistentIssue() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = null;
        List<Issue> actual = manager.ClosedIssue(1);

        assertEquals(expected, actual);
    }
}

