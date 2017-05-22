package com.summercoder.appsupport.HTML;

public class HTML implements IHTML{
	

	private String head;
	private String paragraph;
	private Styles type;

	@Override
	public void setHead(String head) {
		this.head = "<head>" + head + "</head>";
		
	}

	@Override
	public void setParagraph(String paragraph) {
		this.paragraph = "<p>" + paragraph+"</p>";
		
	}

	@Override
	public void setStyle(Styles type) {
		
		if(type == Styles.bold)
		{
			this.type = Styles.bold;
			this.head = "<b>" + head + "</b>";
			
		}else if (type == Styles.italic)
		{
			this.type = Styles.italic;
			
			this.head = "<i>" + head + "</i>";
			
		}	
		
	}
	
	

}
