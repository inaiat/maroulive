/*
 * Copyright 2011 inaiat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ${package}.web.component.bootstrap;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class ModalPanel extends Panel {

	private static final long serialVersionUID = 5292554560675478627L;
	private static final String DEFAULT_CSS_CLASS = "modal hide";
	private final String cssClass;

	public ModalPanel(String id) {
		this(id, null);
	}

	public ModalPanel(String id, IModel<?> model) {
		this(id, model, null);
	}

	public ModalPanel(String id, IModel<?> model, String cssClass) {
		super(id, model);
		if (cssClass == null) {
			this.cssClass = DEFAULT_CSS_CLASS;
		} else {
			this.cssClass = cssClass;
		}
	}

	@Override
	protected void onComponentTag(ComponentTag tag) {
		AttributeModifier attr = new AttributeModifier("class", cssClass);
		tag.addBehavior(attr);
		super.onComponentTag(tag);
	}
	
	public void hide(AjaxRequestTarget target) {
		target.appendJavaScript("$('#" + this.getMarkupId(true) + "').modal('hide')");		
	}

}
