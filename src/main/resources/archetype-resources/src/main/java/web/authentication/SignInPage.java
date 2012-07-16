/*
 *  Copyright 2010 inaiat.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package ${package}.web.authentication;

import org.apache.wicket.markup.html.WebPage;

import ${package}.web.component.bootstrap.SignInPanel;


/**
 * @author henrique
 */
public class SignInPage extends WebPage {

	private static final long serialVersionUID = 3487962276815648313L;

    public SignInPage() {        
        add(new SignInPanel("signInPanel", true));
    }
}