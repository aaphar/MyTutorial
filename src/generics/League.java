package generics;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;

    ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean add(T team) {
        if (league.contains(team)) {
            System.out.println(team.getName() + " already exist in league");
            return false;
        }
        league.add(team);
        return true;
    }

    public void showLeagueTable() {
        Collections.sort(league);

        for (T t : league) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
