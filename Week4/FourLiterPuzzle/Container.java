public class Container {
    private int capacity;
    private int liquid;
    
    public Container(int capacity, int liquid) {
        this.capacity = capacity;
        this.liquid = liquid;
    }
    
    
    public int getCapacity() {
        return this.capacity;
    }
    
    
    public int getLiquid() {
        return this.liquid;
    }
    
    
    public void setLiquid(int amount) {
        this.liquid = amount;
    }
    
    
    public static void transferLiquid(Container containerToTransferFrom, Container containerToTransferTo) {
        int amountToTransfer = containerToTransferFrom.getLiquid(); 
        int amountThatFits = containerToTransferTo.getCapacity() - containerToTransferTo.getLiquid(); 
        
        if (amountToTransfer > amountThatFits) {
            amountToTransfer = amountThatFits;
        }

        containerToTransferFrom.setLiquid(containerToTransferFrom.getLiquid() - amountToTransfer);
        containerToTransferTo.setLiquid(containerToTransferTo.getLiquid() + amountToTransfer);
    }
    
    
    public void fillCompletely() {
        this.liquid = this.capacity;
    }
    
    
    public void emptyContainer() {
        this.liquid = 0;
    }
    
    
    @Override
    public String toString() {
        return this.liquid + "L/" + this.capacity + "L";
    }
}