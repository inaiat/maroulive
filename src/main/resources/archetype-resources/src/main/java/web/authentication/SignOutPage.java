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

import org.apache.wicket.request.mapper.parameter.PageParameters;

import ${package}.web.base.BasePage;

public class SignOutPage extends BasePage {

    private static final long serialVersionUID = 1L;

    /**
     * Construct.
     */
    public SignOutPage(final PageParameters parameters) {

        getSession().invalidate();
    }
    /**
     * Constructor
     *
     * @param parameters Page parameters (ignored since this is the home page)
     */
}
