package com.ljg.restful.model;

public class ModelManager {

    private String modelName;

    public ModelManager(String name) {
        this.modelName = name;
    }

    public void start(){
        System.out.println("ModelManager start...");
    }

    public void close(){
        System.out.println("ModelManager close...");
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
