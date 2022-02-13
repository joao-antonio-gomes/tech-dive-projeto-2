package entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class TrilhaTest {
    public static void main(String[] args) {
        Trilha trilha1 = new Trilha(1L);
        List<Trilha> trilhas = new ArrayList<>();
        trilhas.add(trilha1);
        Trilha trilha2 = new Trilha(1L);
        System.out.println(trilhas.contains(trilha2));
    }
}
