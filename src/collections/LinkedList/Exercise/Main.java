package collections.LinkedList.Exercise;

import java.util.*;

public class Main {
    private static List<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Love me two times", 5.45);
        album.addSong("Holly man", 3.45);
        album.addSong("Hold on", 2.45);
        album.addSong("The gypsy", 3.5);
        album.addSong("Solider o fortune", 4.45);
        album.addSong("Lady double dealer", 3.45);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 4.45);
        album.addSong("Let's go", 3.5);
        album.addSong("Inject the venom", 2.5);
        album.addSong("Evil walks", 5.5);
        album.addSong("NB", 6.5);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("Holly man", playList);
        albums.get(0).addToPlayList("Solider o fortune", playList);
        albums.get(0).addToPlayList("Hold on", playList);
        albums.get(0).addToPlayList("Speaking", playList);
        albums.get(0).addToPlayList(6, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(24, playList);

        play(playList);


    }

    public static void play(List<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean qiut = false;
        boolean forward = true;

        ListIterator<Song> iterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now playing " + iterator.next().toString());
            printMenu();
        }

        while (!qiut) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    qiut = true;
                    break;
                case 1:
                    if (!forward) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        forward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Now playing " + iterator.next().toString());
                    } else {
                        System.out.println("We have reached end of the playList");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Now playing " + iterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playList");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            System.out.println("Now replaying " + iterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (iterator.hasNext()) {
                            System.out.println("Now replaying " + iterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        iterator.remove();
                        if (iterator.hasNext()) {
                            System.out.println("Now playing " + iterator.next());
                        } else if (iterator.hasPrevious()) {
                            System.out.println("Now playing " + iterator.previous());
                        }
                    }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions: \npress ");
        System.out.println("0 - to quit\n" +
                "1 - play to next song\n" +
                "2 - play to previous song\n" +
                "3 - replay current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - remove current song from playList"
        );
    }

    private static void printList(List<Song> playList) {
        Iterator<Song> iterator = playList.listIterator();
        System.out.println("=====================================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("======================================");
    }

}
