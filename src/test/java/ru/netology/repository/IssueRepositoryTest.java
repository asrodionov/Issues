package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();

    @Test
    void shouldAddAndReturnIssue() {

        Issue first = new Issue(2336, "Rename Alphanumeric Orderer to MethodName", true, "gaganis", LocalDate.of(2020, 06, 29), "With the introduction of DisplayName orderer in 6fee44d, the name of the Alphanumeric orderer becomes ambiguous ie", Set.of("component: Jupiter", "status: team discussion"), Set.of("sormuras", "marcphilipp"), Set.of("arodionov", "marcphilipp", "sormuras"));
        Issue second = new Issue(2333, "Rename Alphanumeric Orderer to MethodName", false, "marcphilipp", LocalDate.of(2020, 06, 18), "With the introduction of DisplayName orderer in 6fee44d, the name of the Alphanumeric orderer becomes ambiguous ie", Set.of("component: Jupiter", "3rd-party: Pioneer"), Set.of("sormuras", "marcphilipp"), Set.of("marcphilipp", "sormuras"));
        Issue third = new Issue(2334, "Rename Alphanumeric Orderer to MethodName", true, "arodionov", LocalDate.of(2020, 06, 20), "With the introduction of DisplayName orderer in 6fee44d, the name of the Alphanumeric orderer becomes ambiguous ie", Set.of("component: Jupiter", "status: team discussion"), Set.of("sbrannen"), Set.of("marcphilipp", "sormuras"));
        Issue fourth = new Issue(2335, "Rename Alphanumeric Orderer to MethodName", false, "sormuras", LocalDate.of(2020, 06, 28), "With the introduction of DisplayName orderer in 6fee44d, the name of the Alphanumeric orderer becomes ambiguous ie", Set.of("component: Jupiter", "status: team discussion"), Set.of("sormuras", "marcphilipp"), Set.of("marcphilipp", "sormuras"));

        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);


        List<Issue> expected = new ArrayList<>(List.of(first,second,third,fourth));
        List<Issue> actual = repository.getAll();

        assertEquals(expected, actual);
    }



}