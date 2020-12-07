package doankimdinh.i.doankimdinhmusicplayer;

public class Song {
    private String tenBaiHat;
    private int mp3;
    private int imageSong;

    public Song(String tenBaiHat, int mp3, int imageSong) {
        this.tenBaiHat = tenBaiHat;
        this.mp3 = mp3;
        this.imageSong = imageSong;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public int getMp3() {
        return mp3;
    }

    public void setMp3(int mp3) {
        this.mp3 = mp3;
    }

    public int getImageSong() {
        return imageSong;
    }

    public void setImageSong(int imageSong) {
        this.imageSong = imageSong;
    }
}
