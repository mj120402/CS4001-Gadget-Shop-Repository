class MP3 extends Gadget{
    private int availableMemory;
    
    public MP3(String model, double price, int weight, String size, int availableMemory)
    {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }
    
    public int getAvailableMemory()
    {
        return availableMemory;
    }
    
    public void downloadMusic(int downloadSize){
        if (availableMemory>= downloadSize){
            availableMemory-= downloadSize;
            System.out.println("Music downloaded successfully");
        } else{
            System.out.println("Not enough storage");
        }
    }
    
    public void deleteMusic(int musicSize){
        availableMemory+=musicSize;
        System.out.println("Music deleted");
    }
    
    @Override
    public void display(){
        super.display();
        System.out.println("Available Memory: " + availableMemory + " MB");
    }
    
}

