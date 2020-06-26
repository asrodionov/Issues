package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();

    //@Test
//    void shouldAddProduct() {
//        repository.add(new Issue(2020,"New bug","open","rodionov",20202020,"New bug", Set.of("a1,b1"),Set.of("a1,b1"),Set.of("a1,b1")));
//
//        List<Issue> expected = List.of(2020,"New bug","open","rodionov",20202020,"New bug", Set.of("a1,b1"),Set.of("a1,b1"),Set.of("a1,b1"));
//        List<Issue> actual = repository.getAll();
//
//        assertEquals(expected, actual);
//    }

//    @Test
//    void shouldAddMultipleProducts() {
//        Collection<Issue> products = new ArrayList<>();
//        products.add(new Issue());
//        products.add(new Issue());
//        repository.addAll(products);
//
//        repository.addAll(List.of(new Issue(), new Issue()));
//    }

}