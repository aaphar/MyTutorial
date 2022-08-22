package collections.LinkedList.Exercise;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String songTitle, double songDuration) {
        return this.songs.add(new Song(songTitle, songDuration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }

        System.out.println("The album doesn't have track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
        Song song = songs.findSong(songTitle);


        if (song != null) {
            playlist.add(song);
            return true;
        }

        System.out.println("The song " + songTitle + " is not in this album");
        return false;
    }

    public class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        public boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;

        }

        private Song findSong(String title) {
            for (Song song : songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int track) {
            int index = track - 1;
            if (index >= 0 && index < songs.size()) {
                return songs.get(index);
            }
            return null;
        }
    }
}

