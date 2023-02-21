package me.ethan.helloboot;

public class Hello {
    private String name;
    private int count;

    public String getName() {
        return name;
    }

    public Hello(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
