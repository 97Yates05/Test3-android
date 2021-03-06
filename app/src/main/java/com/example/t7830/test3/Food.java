package com.example.t7830.test3;

/**
 * Created by t7830 on 2018/3/26.
 */
public class Food {
    private String name;
    private boolean hot;
    private boolean fish;
    private boolean sour;
    private int price;
    private int pic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean isFish() {
        return fish;
    }

    public void setFish(boolean fish) {
        this.fish = fish;
    }

    public boolean isSour() {
        return sour;
    }

    public void setSour(boolean sour) {
        this.sour = sour;
    }

    @Override
    public String toString() {
        return "Food [name=" + name + ", hot=" + hot + ", fish=" + fish
                + ", sour=" + sour + ", price=" + price + ", pic=" + pic + "]";
    }

    public Food(String name, int price, int pic, boolean hot, boolean fish, boolean sour
    ) {
        super();
        this.name = name;
        this.hot = hot;
        this.fish = fish;
        this.sour = sour;
        this.price = price;
        this.pic = pic;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

}

