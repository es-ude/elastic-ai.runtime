package de.ude.es;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TwinList {

    private List<TwinData> twins = new ArrayList<>();

    public void changeTwinName(String ID, String newName) {
        TwinData twin = getTwin(ID);
        if (twin != null) {
            twin.setName(newName);
        }
    }

    public TwinData getTwin(String ID) {
        for (TwinData tw : twins) {
            if (Objects.equals(tw.getID(), ID)) {
                return tw;
            }
        }
        return null;
    }

    public void addTwin(String ID) {
        if (getTwin(ID) == null) {
            twins.add(new TwinData("Twin " + twins.size(), ID));
        }
    }

    public List<TwinData> getTwins() {
        return twins;
    }

}