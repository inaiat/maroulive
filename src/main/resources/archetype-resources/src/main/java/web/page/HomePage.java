package ${pacakage}.web.page;

import org.apache.wicket.markup.html.basic.Label;

import ${pacakage}.web.base.BasePage;

public class HomePage extends BasePage {

	private static final long serialVersionUID = -3516141952665953127L;
	
	public HomePage() {
		add(new Label("msg","Hello World!"));
	}

}
