package org.example;

import java.util.ArrayList;
import java.util.Optional;

public class FamousSayings {
    private int nextId = 1;
    private ArrayList<FamousSaying> famousSayings = new ArrayList<>();

    public int create(String content, String author) {
        FamousSaying famousSaying = new FamousSaying(nextId++, content, author);
        famousSayings.add(famousSaying);
        return famousSaying.getId();
    }

    public ArrayList<FamousSaying> findAll() {
        return famousSayings;
    }

    public Optional<FamousSaying> findById(int id) {
        for (FamousSaying famousSaying : famousSayings) {
            if (famousSaying.getId() == id) {
                return Optional.of(famousSaying);
            }
        }
        return Optional.empty();
    }

    public void deleteFamousSaying(FamousSaying famousSaying) {
        famousSayings.remove(famousSaying);
    }

    public void updateFamousSaying(FamousSaying famousSaying, String content, String author) {
        famousSaying.update(content, author);
    }
}
