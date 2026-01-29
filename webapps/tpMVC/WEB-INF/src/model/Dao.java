package model;

import java.util.ArrayList;

public class Dao {
    private ArrayList<String> list;

    public Dao() {
        this.list = new ArrayList<String>();
        this.list.add("1erElement");
        this.list.add("2emmeElement");
    }

    public ArrayList<String> findAll() {
        return this.list;
    }

    public String findById(int id) {
        return this.list.get(id % this.list.size());
    }
}
