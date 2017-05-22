package com.summercoder.money;

import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class BudgetList<HealthNode>
{
    protected List<HealthNode> elements;
    private int count;
    private int costTotal;
    
    public BudgetList() //Initialize our list so it can contain HealthNode components
    {
        this.elements = new ArrayList<HealthNode>();
    }
    
    public void add(HealthNode x)
    {
        //Add script later
    }
    
    public void addMultiple(HealthNode x, int n)
    {
        //Add script later
    }
    
    public HealthNode remove(HealthNode x)
    {
		return x;
        //Add script later
    }
    
    public int total()
    {
        return count;
    }
    
    public int totalCost()
    {
        return costTotal;
    }
    
    public void printList() //Outputs the list to the screen
    {
        //for (int i = 0; i <= count; i++)
        //{
        //    System.out.println(elements.get(i));
        //}
    }
    
    public void outputList() throws FileNotFoundException //Use the methodology of the above method to output the list to a file
    {
        File file = new File("ListofItems.txt");
        Scanner sc = new Scanner(file);
        for (int i = 0; i <= count; i++)
        {
            //
        }
    }
}
