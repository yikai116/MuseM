package DTO.Out;

import java.util.List;

/**
 * Created by p on 2017/7/27.
 */
public class YearArt {
    private int year;
    private int count;
    private List<TimeArt> arts;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<TimeArt> getArts() {
        return arts;
    }

    public void setArts(List<TimeArt> arts) {
        this.arts = arts;
    }
}
