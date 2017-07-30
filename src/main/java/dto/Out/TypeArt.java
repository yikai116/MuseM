package dto.Out;

import java.util.List;

/**
 * Created by p on 2017/7/26.
 */
public class TypeArt {
    private String type;
    private int count;
    private List<SimArt> arts;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<SimArt> getArts() {
        return arts;
    }

    public void setArts(List<SimArt> arts) {
        this.arts = arts;
    }
}
