class Mobile extends Gadget{
    private int callingCredit;
    
    public Mobile(String model, double price, int weight, String size, int callingCredit)
    {
        super(model, price, weight, size);
        this.callingCredit = callingCredit;
    }
    
    public void addCallingCredit(int credit)
    {
        if(credit > 0)
            callingCredit+=credit;
        
            else
                System.out.println("Please enter some credit");
            
    }
    
    public void makeCall(String phoneNumber, int duration)
    {
        if (callingCredit >= duration)
        {
            System.out.println("Calling " + phoneNumber + "for " + duration + " minutes.");
            callingCredit -= duration;
         } 
         else 
         {
         System.out.println("Insufficient credit to make a call");
            }
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Calling Credit: " + callingCredit + " minutes");
    }
    
    
}

