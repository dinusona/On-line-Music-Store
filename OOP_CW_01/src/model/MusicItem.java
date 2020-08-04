package model;

import java.util.Objects;
//implements Comparable<MusicItem>
public class MusicItem implements Comparable<MusicItem> {
    protected int itemID;
    protected String title;
    protected String genre;
    protected String releaseDate;
    protected String artist;
    protected int price;

    public MusicItem(int itemID, String title, String genre, String releaseDate, String artist, int price) {
        super();
        this.itemID = itemID;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.price = price;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
//set equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicItem musicItem = (MusicItem) o;
        return itemID == musicItem.itemID &&
                price == musicItem.price &&
                title.equals(musicItem.title) &&
                genre.equals(musicItem.genre) &&
                releaseDate.equals(musicItem.releaseDate) &&
                artist.equals(musicItem.artist);
    }
//generate hashCode
    @Override
    public int hashCode() {
        return Objects.hash(itemID, title, genre, releaseDate, artist, price);
    }



    @Override
    public int compareTo(MusicItem obj) {
        return this.title.compareTo(obj.getTitle());
    }

    @Override
    public String toString() {
        return "MusicItem{" +
                "itemID='" + itemID + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", artist='" + artist + '\'' +
                ", price=" + price +
                '}';
    }
}
