package org.example.lab6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class InputElement {

    private Integer count;
    private List<Integer> inputs;

    private Integer sort;

    public InputElement() {
        this.sort = 0;
        this.count = 0;
        this.inputs = new ArrayList<>();
    }

    public Integer getCount() {
        return count;
    }

    public List<Integer> getInputs() {
        return inputs;
    }

    public void setCount(Integer newCount) {
        this.count = newCount;
    }

    public void addNewElByList(Integer newElIndex) {
        this.inputs.add(newElIndex);
    }

    public void setSort(Integer newSort) {
        this.sort = newSort;
    }

    public Integer getSort() {
        return sort;
    }
}