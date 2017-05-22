package com.summercoder.appsupport.HTML;



public class HTMLWriter 
{
	
	    private HTMLBuilder pizzaBuilder;

	    public void setPizzaBuilder(HTMLBuilder pb) {
	        pizzaBuilder = pb;
	    }

	    public HTML getHTML() {
	        return pizzaBuilder.getHTML();
	    }

	    public void build() {
	        pizzaBuilder.createNewHTMLPage();
	        pizzaBuilder.buildHead();
	        pizzaBuilder.buildParagraph();
	        pizzaBuilder.buildType();
	    
	}
}
