package com.learn.structure_data.graph;

import lombok.Data;

@Data
public class Vertex {
    private char name;
    private boolean isVisited;

    public Vertex(char name) {
        this.name = name;
        this.isVisited = false;
    }
}
