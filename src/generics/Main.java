package generics;

public class Main {

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckman = new SoccerPlayer("Beckman");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);

//        adelaideCrows.addPlayer(pat);
//        adelaideCrows.addPlayer(beckman);

        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballPlayerTeam = new Team<>("Chicago Cubs");
        baseballPlayerTeam.addPlayer(pat);

        Team<SoccerPlayer> brokenTeam = new Team<>("This won't work");
        brokenTeam.addPlayer(beckman);


        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);
//        adelaideCrows.matchResult(baseballPlayerTeam, 1, 1); // make matchResult generic

        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
        System.out.println(melbourne.getName() + ": " + melbourne.ranking());
        System.out.println(fremantle.getName() + ": " + fremantle.ranking());
        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());

        System.out.println();

        System.out.println(adelaideCrows.compareTo(melbourne));
        System.out.println(adelaideCrows.compareTo(hawthorn));
        System.out.println(hawthorn.compareTo(adelaideCrows));
        System.out.println(melbourne.compareTo(fremantle));


        /**
         * League
          */
        League<Team<FootballPlayer>> footballLeague=new League<>("AFL");
        footballLeague.add(adelaideCrows);
        footballLeague.add(melbourne);
        footballLeague.add(hawthorn);
        footballLeague.add(fremantle);

//        footballLeague.add(baseballPlayerTeam);


        footballLeague.showLeagueTable();

        /**
         * Generics make code more clear
         */

        Team rawTeam=new Team<>("Raw Team");
        rawTeam.addPlayer(beckman); // unchecked warning
        rawTeam.addPlayer(pat); // unchecked warning

        footballLeague.add(rawTeam); // unchecked warning

        League<Team> rawLeague=new League<>("Raw");
        rawLeague.add(adelaideCrows); // no warning
        rawLeague.add(baseballPlayerTeam); // no warning
        rawLeague.add(rawTeam); // no warning

        League reallyRaw=new League<>("Really raw");
        reallyRaw.add(adelaideCrows); // unchecked warning
        reallyRaw.add(baseballPlayerTeam); // unchecked warning
        reallyRaw.add(rawTeam); // unchecked warning




















//        ArrayList<Team> teams;
//        Collections.sort(teams);


//        // Using ArrayList without Generic
//        // ArrayList items = new ArrayList<>();
//        ArrayList<Integer> items = new ArrayList<>();
//        items.add(1);
//        items.add(2);
//        items.add(3);
//        items.add(4);
//        items.add(5);
////        items.add("Hay");
//
//        printDouble(items);
//
//    }
//
//    private static void printDouble(ArrayList<Integer> n) {
//        for (int i : n) {
//            System.out.println(i * 2);
//        }
    }
}
