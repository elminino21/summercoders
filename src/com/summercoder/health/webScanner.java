
package com.summercoder.health;
import java.io.IOException;
import java.util.List;
import javax.lang.model.element.Element;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.ArrayList;
import org.jsoup.select.Elements;
/**
 *
 * @author nickmotta
 */
public class webScanner 
{
    private String webPage;//Url that we will download.
    private Document downloadedPage;//Web Page that gets downloaded
    Item item = new Item(null, 0, 0);//Item to set data to.
    
    
    //Constructors
    webScanner()
    {
        
    }
    webScanner(String a)
    {
        webPage = a;
    }
    webScanner(String a, Document b)
    {
        webPage = a;
        downloadedPage = b;
    }
    
    
    
    //Sets Web Page.
    public void setWebPage(String webPage)
    {
        this.webPage = webPage;
    }
    
    //Sets the item that will recieve data
    public void setItem(Item item)
    {
        this.item = item;
    }
    
    //Gets the Item
    public Item getItem()
    {
        return item;
    }
    
    //Sets Node information
    public void setInfo()
    {
        
        try
        {
            //Downloads Page
            downloadedPage = Jsoup.connect(webPage).get();
            String title = downloadedPage.title();
            String price = downloadedPage.html();
            
            //Lists
            ArrayList priceList = new ArrayList();
            ArrayList caloriesList = new ArrayList();
            ArrayList caloriesFromFatList = new ArrayList();
            ArrayList sugarList = new ArrayList();
            
            //Boundaries
             int boundary = 0;
             int boundaryD = 0;
             int boundaryC = 0;
             int boundaryP = 0;
             int boundaryS = 0;
             
            //Sets items info
            item.setInfo(title);
            
            //SETS Cost
            //Loads page and converts to string
            org.jsoup.nodes.Element Price = downloadedPage.select("div.prod-PriceHero").first();
            String a = Price.html();
            
            
            //Loads price from string to Healthnode
            for(int z = 0; z != a.length(); z++)
            {
                char holder = a.charAt(z);
                if(Character.isDigit(a.charAt(z)))
                {
                    priceList.add(holder);
                }
                
                if(holder == '.')
                {
                    priceList.add(holder);
                }
            }
            String test = "";
            int count = 0;
            int count2 = 0;
            
            for(int z = 0; z != priceList.size(); z++)
            {
                
                char holder = (char) priceList.get(z);
                
                if(holder == '.')
                {
                    count++;
                }
                
                if(count == 1)
                {
                    count2++;
                }
                if(count2 <= 3)
                {
                    test = test + priceList.get(z);
                }
                
            }
            item.setCost(Double.parseDouble(test));
            
            
            
            //----GETS Calories and CalFromFat----
            //Parse information containing calories.
            org.jsoup.nodes.Element Calories = downloadedPage.select("div.NutritionFacts-allFacts-calorieInfo").first();
            String c = Calories.html();
            
            count = 0;
            count2 = 0;
            
            //Loads Calories and Calories from fat from string to Healthnode
            for(int z = 0; z != c.length(); z++)
            {
                char holder = c.charAt(z);
                
                if(Character.isDigit(c.charAt(z)))
                {
                    
                    
                    if(count2 > 0)
                    {
                        caloriesFromFatList.add(holder);
                        
                    }
                    
                    if(count2 == 0)
                    {
                        caloriesList.add(holder);
                        count++;
                    }
                    
                    
                    
                }
                else
                {
                    if(count > 0)
                    {
                        count2++;
                    }
                }
                
            }
            test = "";
            String test2 = "";
            for(int z = 0; z != caloriesList.size(); z++)
            {
                
                test = test + caloriesList.get(z);
                
                
            }
            for(int z = 0; z != caloriesFromFatList.size(); z++)
            {
                
                test2 = test2 + caloriesFromFatList.get(z);
                
                
            }
            item.setCalories(Integer.parseInt(test));
            item.setCaloriesFromFat(Integer.parseInt(test2));
            
            
            //----SETS Sugar---//Has total fat through protein.
            org.jsoup.nodes.Element NutricianFacts = downloadedPage.select("div.NutritionFacts-allFacts-nutrientInfo").first();
            String s = NutricianFacts.html();
            int []nutritianCount = new int[10];
             int countForSugar = 0;
             
             //Lists for nutritian data
              ArrayList DietaryFiberList = new ArrayList();
              ArrayList TransFat = new ArrayList();
              ArrayList Cholesteral = new ArrayList();
              ArrayList Carbs = new ArrayList();
              ArrayList Protein = new ArrayList();
              ArrayList Potassium = new ArrayList();
            
            for(int z = 0; z != s.length(); z++)
            {
                //Creates Lists
                //Dietary Fiber done
                if(s.charAt(z) == 'D')
                {
                    if(s.charAt(z + 1) == 'i')
                    {
                     nutritianCount[0] = 1;
                    }
                }
                //Trans Fat done
                if(s.charAt(z) == 'T')
                {
                    
                    if(s.charAt(z + 1) == 'r')
                    {
                     nutritianCount[1] = 1;
                    }
                }
                 //Cholesteral and Carbs done
                if(s.charAt(z) == 'C')
                {
                     if(s.charAt(z + 1) == 'h')
                    {
                      nutritianCount[2] = 1;
                    }
                     if(s.charAt(z + 1) == 'a')
                    {
                      nutritianCount[2] = 2;
                    }
                }
                //Saturated Fat, Sodium, Sugar
                if(s.charAt(z) == 'S')
                {
                    countForSugar++;
                    
                }
                //Protein done
                if(s.charAt(z) == 'P')
                {
                    nutritianCount[3] = 1;
                    countForSugar = 0;
                }
               
                
                
                //Loads to arraylists
                //Sugar
                if(countForSugar == 3)
                {
                    if(Character.isDigit(s.charAt(z)))
                    {
                        sugarList.add(s.charAt(z));
                        boundaryS = 1;
                    }
                    if(boundaryS == 1)
                    {
                        if(!Character.isDigit(s.charAt(z)))
                        {
                           countForSugar = 0;
                        }
                        
                    }
                    
                }
                
                //Dietary Fiber
                if(nutritianCount[0] == 1)
                {
                     if(Character.isDigit(s.charAt(z)))
                    {
                        DietaryFiberList.add(s.charAt(z)); 
                        boundaryD = 1;
                    }
                    if(boundaryD == 1)
                    {
                        if(!Character.isDigit(s.charAt(z)))
                        {
                           nutritianCount[0] = 0;
                        }
                        
                    }
                     
                }
                
                //Trans Fat
                if(nutritianCount[1] == 1)
                {
                   
                    if(Character.isDigit(s.charAt(z)))
                    {
                        boundary = 1;
                        TransFat.add(s.charAt(z));
                    }
                    if(boundary == 1)
                    {
                        if(!Character.isDigit(s.charAt(z)))
                        {
                            nutritianCount[1] = 0;
                        }
                    }
                }
                
                //Cholestoral
                if(nutritianCount[2] == 1)
                {
                    if(Character.isDigit(s.charAt(z)))
                    {
                        boundaryC = 1;
                        Cholesteral.add(s.charAt(z));
                    }
                    if(boundaryC == 1)
                    {
                        if(!Character.isDigit(s.charAt(z)))
                        {
                            nutritianCount[2] = 0;
                        }
                    }
                    
                }
                
                //Carbs
                if(nutritianCount[2] == 2)
                {
                    if(Character.isDigit(s.charAt(z)))
                    {
                        boundaryC = 2;
                        Carbs.add(s.charAt(z));
                    }
                    if(boundaryC == 2)
                    {
                        if(!Character.isDigit(s.charAt(z)))
                        {
                            nutritianCount[2] = 0;
                        }
                    }
                }
                
                //Protein 
                if(nutritianCount[3] == 1)
                {
                     if(Character.isDigit(s.charAt(z)))
                    {
                        boundaryP = 1;
                        Protein.add(s.charAt(z));
                    }
                    if(boundaryP == 1)
                    {
                        if(!Character.isDigit(s.charAt(z)))
                        {
                            nutritianCount[3] = 0;
                        }
                    }
                }
                
            }
            
            test = "";
            for(int z = 0; z != sugarList.size(); z++)
            {
                test = test + sugarList.get(z);
            }
            item.setSugar(Integer.parseInt(test));
            
            //System.out.println(Protein.size());
            System.out.println(test);
             System.out.println(s);
            //org.jsoup.nodes.Element Vitamins = downloadedPage.select("div.NutritionFacts-allFacts-nutrientInfo").first();
            // String v = Vitamins.html();
            
            
            
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        
        
        
    }

    

}
