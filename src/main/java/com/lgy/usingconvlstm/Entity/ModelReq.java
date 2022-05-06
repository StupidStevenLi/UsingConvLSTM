package com.lgy.usingconvlstm.Entity;

public class ModelReq {
   private int kernelStructure;
   private int filters;
   private int optimizer;
   private int epochs;

   public ModelReq() {
   }

   public ModelReq(int kernelStructure, int filters, int optimizer, int epochs) {
      this.kernelStructure = kernelStructure;
      this.filters = filters;
      this.optimizer = optimizer;
      this.epochs = epochs;
   }

   public int getKernelStructure() {
      return kernelStructure;
   }

   public void setKernelStructure(int kernelStructure) {
      this.kernelStructure = kernelStructure;
   }

   public int getFilters() {
      return filters;
   }

   public void setFilters(int filters) {
      this.filters = filters;
   }

   public int getOptimizer() {
      return optimizer;
   }

   public void setOptimizer(int optimizer) {
      this.optimizer = optimizer;
   }

   public int getEpochs() {
      return epochs;
   }

   public void setEpochs(int epochs) {
      this.epochs = epochs;
   }
}
