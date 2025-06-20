package org.example;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Method1 {

    Set<Integer> userIds = new HashSet<>();

    public User createUser(long id) {
        if (!userIds.contains(id)) {
            return Optional.empty();
        }
    }
}
