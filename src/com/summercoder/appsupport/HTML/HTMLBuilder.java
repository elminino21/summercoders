package com.summercoder.appsupport.HTML;
/**
 * html builder
 * @author Jose Gonzalez
 */
public abstract class HTMLBuilder 
{
	protected HTML html;

    public HTML getHTML() {
        return html;
    }

    public void createNewHTMLPage() {
    	html = new HTML();
    }

    public abstract void buildHead();
    public abstract void buildParagraph();
    public abstract void buildType();

}
