package com.summercoder.health;

public class HealthNode //The form that our pieces of food, medicine and other trackable expenses will take
{
    protected String info;
    protected int cost;
    protected int expiryDate;
    private boolean isFood;
    private boolean isMedicine; //Not mutually exclusive with isFood: tea, vitamin supplements, etc. can be both
    
    public HealthNode(String info, int cost, int expiryDate)
    {
        this.info = info;
        this.cost = cost;
        this.expiryDate = expiryDate;
    }
    
    public void setInfo(String info)
    {
        this.info = info;
    }
    public String getInfo()
    {
        return info;
    }
    public void setCost(int cost)
    {
        this.cost = cost;
    }
    public int getCost()
    {
        return cost;
    }
    public void setExpiryDate(int expiryDate)
    {
        this.expiryDate = expiryDate;
    }
    public int getExpiryDate()
    {
        return expiryDate;
    }
}           