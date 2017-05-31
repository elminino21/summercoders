package com.summercoder.health;

public class Item //The form that our pieces of food, medicine and other trackable expenses will take
{
    protected String info;
    protected double cost;
     protected double sugar;
    protected int calories;
    protected int caloriesFromFat;
    protected String saturatedFat;
    protected String TransFat;
    protected String Cholesterol;
    protected String Sodium;
    protected String Potassium;
    protected String Carbohydrates;
    protected String Protein;
    protected String Dietaryfiber;
    protected int expiryDate;
    private boolean isFood;
    private boolean isMedicine; //Not mutually exclusive with isFood: tea, vitamin supplements, etc. can be both
    
    public Item(String info, int cost, int expiryDate)
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
    public void setCost(double cost)
    {
        this.cost = cost;
    }
    public double getCost()
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
    public double getSugar()
    {
        return sugar;
    }
    
    public void setSugar(double sugar)
    {
        this.sugar = sugar;
    }
    
    public int getCalories()
    {
        return calories;
    }
    
    public void setCalories(int calories)
    {
        this.calories = calories;
    }
    
    public int getCaloriesFromFat()
    {
        return caloriesFromFat;
    }
    
    public void setCaloriesFromFat(int caloriesFromFat)
    {
        this.caloriesFromFat = caloriesFromFat;
    }
    
    public String getSaturatedFat() {
        return saturatedFat;
    }
    
    public void setSaturatedFat(String saturatedFat)
    {
        this.saturatedFat = saturatedFat;
    }
    
    public String getTransFat()
    {
        return TransFat;
    }
    
    public void setTransFat(String TransFat)
    {
        this.TransFat = TransFat;
    }
    
    public String getCholesterol()
    {
        return Cholesterol;
    }
    
    public void setCholesterol(String Cholesterol) 
    {
        this.Cholesterol = Cholesterol;
    }
    
    public String getSodium()
    {
        return Sodium;
    }
    
    public void setSodium(String Sodium)
    {
        this.Sodium = Sodium;
    }
    
    public String getPotassium()
    {
        return Potassium;
    }
    
    public void setPotassium(String Potassium) 
    {
        this.Potassium = Potassium;
    }
    
    public String getCarbohydrates() 
    {
        return Carbohydrates;
    }
    
    public void setCarbohydrates(String Carbohydrates) 
    {
        this.Carbohydrates = Carbohydrates;
    }
    
    public String getProtein()
    {
        return Protein;
    }
    
    public void setProtein(String Protein)
    {
        this.Protein = Protein;
    }
    
    public String getDietaryfiber()
    {
        return Dietaryfiber;
    }
    
    public void setDietaryfiber(String Dietaryfiber)
    {
        this.Dietaryfiber = Dietaryfiber;
    }
}           