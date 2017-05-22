package com.summercoder.appsupport.HTML;

public class SimpleHTMLPageBuilder extends HTMLBuilder{
	
	  
		@Override
		public void buildHead() {
			html.setHead("test inof");
			
		}

		@Override
		public void buildParagraph() {
			html.setParagraph("paragraph");
			
		}

		@Override
		public void buildType() 
		{
			html.setStyle(null);
			
		}
	

}
