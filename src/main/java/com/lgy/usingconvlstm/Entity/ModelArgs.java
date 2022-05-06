package com.lgy.usingconvlstm.Entity;

public class ModelArgs {
    private int aid;
    private int batchSize;
    private int filters;
    private int k1;
    private int k2;
    private int k3;
    private String loss;
    private String optimizer;
    private int epochs;
    private String state;

    public ModelArgs(int aid, int batchSize, int filters, int k1, int k2, int k3, String loss, String optimizer, int epochs, String state) {
        this.aid = aid;
        this.batchSize = batchSize;
        this.filters = filters;
        this.k1 = k1;
        this.k2 = k2;
        this.k3 = k3;
        this.loss = loss;
        this.optimizer = optimizer;
        this.epochs = epochs;
        this.state = state;
    }

    public ModelArgs() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public int getFilters() {
        return filters;
    }

    public void setFilters(int filters) {
        this.filters = filters;
    }

    public int getK1() {
        return k1;
    }

    public void setK1(int k1) {
        this.k1 = k1;
    }

    public int getK2() {
        return k2;
    }

    public void setK2(int k2) {
        this.k2 = k2;
    }

    public int getK3() {
        return k3;
    }

    public void setK3(int k3) {
        this.k3 = k3;
    }

    public String getLoss() {
        return loss;
    }

    public void setLoss(String loss) {
        this.loss = loss;
    }

    public String getOptimizer() {
        return optimizer;
    }

    public void setOptimizer(String optimizer) {
        this.optimizer = optimizer;
    }

    public int getEpochs() {
        return epochs;
    }

    public void setEpochs(int epochs) {
        this.epochs = epochs;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
