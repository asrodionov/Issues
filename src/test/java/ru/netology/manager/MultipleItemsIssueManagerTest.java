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
public class MultipleItemsIssueManagerTest {
    @Mock
    private IssueRepository repository;
    @InjectMocks
    private IssueManager manager;

    private Issue first = new Issue(2336, "Rename Alphanumeric Orderer to MethodName", "open", "gaganis", 15062020, "With the introduction of DisplayName orderer in 6fee44d, the name of the Alphanumeric orderer becomes ambiguous ie", Set.of("component: Jupiter","status: team discussion"),Set.of("sormuras","marcphilipp"),Set.of("arodionov","marcphilipp","sormuras"));
    private Issue second = new Issue(2333, "Rename Alphanumeric Orderer to MethodName", "closed", "marcphilipp", 17062020, "With the introduction of DisplayName orderer in 6fee44d, the name of the Alphanumeric orderer becomes ambiguous ie", Set.of("component: Jupiter","3rd-party: Pioneer"),Set.of("sormuras","marcphilipp"),Set.of("marcphilipp","sormuras"));
    private Issue third = new Issue(2334, "Rename Alphanumeric Orderer to MethodName", "open", "arodionov", 20062020, "With the introduction of DisplayName orderer in 6fee44d, the name of the Alphanumeric orderer becomes ambiguous ie", Set.of("component: Jupiter","status: team discussion"),Set.of("sbrannen"),Set.of("marcphilipp","sormuras"));
    private Issue fourth = new Issue(2335, "Rename Alphanumeric Orderer to MethodName", "closed", "sormuras", 25062020, "With the introduction of DisplayName orderer in 6fee44d, the name of the Alphanumeric orderer becomes ambiguous ie", Set.of("component: Jupiter","status: team discussion"),Set.of("sormuras","marcphilipp"),Set.of("marcphilipp","sormuras"));

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    public void shouldGetOpenIssue() {
        List<Issue> returned = new ArrayList<>(List.of(first,second,third,fourth));
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>(List.of(first,third));
        List<Issue> actual = manager.getOpenIssue();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetClosedIssue() {
        List<Issue> returned = new ArrayList<>(List.of(first,second,third,fourth));
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>(List.of(second,fourth));
        List<Issue> actual = manager.getClosedIssue();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAuthor() {
        List<Issue> returned = new ArrayList<>(List.of(first,second,third,fourth));
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>(List.of(third));
        List<Issue> actual = manager.filterByAuthor("arodionov");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByLabel() {
        List<Issue> returned = new ArrayList<>(List.of(first,second,third,fourth));
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>(List.of(second));
        List<Issue> actual = manager.filterByLabel("3rd-party: Pioneer");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAssignee() {
        List<Issue> returned = new ArrayList<>(List.of(first,second,third,fourth));
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>(List.of(third));
        List<Issue> actual = manager.filterByAssignee("sbrannen");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByParticipant() {
        List<Issue> returned = new ArrayList<>(List.of(first,second,third,fourth));
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>(List.of(first));
        List<Issue> actual = manager.filterByParticipant("arodionov");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByAsc() {
        List<Issue> returned = new ArrayList<>(List.of(first,second,third,fourth));
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>(List.of(second,third,fourth,first));
        List<Issue> actual = manager.SortByAsc();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByDesc() {
        List<Issue> returned = new ArrayList<>(List.of(first,second,third,fourth));
        doReturn(returned).when(repository).getAll();

        IssueDescComparator comparator = new IssueDescComparator();

        List<Issue> expected = new ArrayList<>(List.of(first,fourth,third,second));
        List<Issue> actual = manager.SortByDesc(comparator);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldOpeningIssue() {
        List<Issue> returned = new ArrayList<>(List.of(first,second,third,fourth));
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>(List.of(new Issue(2333, "Rename Alphanumeric Orderer to MethodName", "open", "marcphilipp", 17062020, "With the introduction of DisplayName orderer in 6fee44d, the name of the Alphanumeric orderer becomes ambiguous ie", Set.of("component: Jupiter","3rd-party: Pioneer"),Set.of("sormuras","marcphilipp"),Set.of("marcphilipp","sormuras"))));
        List<Issue> actual = manager.OpeningIssue(2333);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCloseIssue() {
        List<Issue> returned = new ArrayList<>(List.of(first,second,third,fourth));
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = new ArrayList<>(List.of(new Issue(2336, "Rename Alphanumeric Orderer to MethodName", "closed", "gaganis", 15062020, "With the introduction of DisplayName orderer in 6fee44d, the name of the Alphanumeric orderer becomes ambiguous ie", Set.of("component: Jupiter","status: team discussion"),Set.of("sormuras","marcphilipp"),Set.of("arodionov","marcphilipp","sormuras"))));
        List<Issue> actual = manager.ClosedIssue(2336);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldOpeningNonexistentIssue() {
        List<Issue> returned = new ArrayList<>(List.of(first,second,third,fourth));
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = null;
        List<Issue> actual = manager.OpeningIssue(2);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCloseNonexistentIssue() {
        List<Issue> returned = new ArrayList<>(List.of(first,second,third,fourth));
        doReturn(returned).when(repository).getAll();

        List<Issue> expected = null;
        List<Issue> actual = manager.ClosedIssue(1);

        assertEquals(expected, actual);
    }
}