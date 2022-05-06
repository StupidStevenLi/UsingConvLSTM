package com.lgy.usingconvlstm.Entity;

public class ModelResponse {
    private int aid;
    private int batchSize;
    private int filters;
    private String kernelStructure;
    private String loss;
    private String optimizer;
    private int epochs;
    private String state;

    public ModelResponse() {
    }

    public ModelResponse(int aid, int batchSize, int filters, String kernelStructure, String loss, String optimizer, int epochs, String state) {
        this.aid = aid;
        this.batchSize = batchSize;
        this.filters = filters;
        this.kernelStructure = kernelStructure;
        this.loss = loss;
        this.optimizer = optimizer;
        this.epochs = epochs;
        this.state = state;
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

    public String getKernelStructure() {
        return kernelStructure;
    }

    public void setKernelStructure(String kernelStructure) {
        this.kernelStructure = kernelStructure;
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
