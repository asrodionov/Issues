package ru.netology.manager;

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

        int expected = 0;
        int actual = manager.getOpenIssue().size();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetClosedIssue() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        int expected = 0;
        int actual = manager.getClosedIssue().size();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAuthor() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        int expected = 0;
        int actual = manager.filterByAuthor("arodionov").size();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByLabel() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        int expected = 0;
        int actual = manager.filterByLabel("component: Jupiter").size();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAssignee() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        int expected = 0;
        int actual = manager.filterByAssignee("sormuras").size();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByParticipant() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        int expected = 0;
        int actual = manager.filterByParticipant("marcphilipp").size();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByAsc() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        int expected = 0;
        int actual = manager.sortByAsc().size();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByDesc() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        IssueDescComparator comparator = new IssueDescComparator();

        int expected = 0;
        int actual = manager.sortByDesc(comparator).size();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldOpeningIssue() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        Issue expected = null;
        Issue actual = manager.openingIssue(2336);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCloseIssue() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        Issue expected = null;
        Issue actual = manager.closedIssue(2336);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldOpeningNonexistentIssue() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        Issue expected = null;
        Issue actual = manager.openingIssue(2);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCloseNonexistentIssue() {
        List<Issue> returned = new ArrayList<>();
        doReturn(returned).when(repository).getAll();

        Issue expected = null;
        Issue actual = manager.closedIssue(1);

        assertEquals(expected, actual);
    }
}

