package ${package}.web.application;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import br.com.digilabs.test.web.HomePage;

import ${package}.web.HomePage;
import ${package}.web.authentication.SignInPage;


/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 *
 */
public class MyApplication extends WebApplication {

    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<SignInPage> getHomePage() {
        return SignInPage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        getMarkupSettings().setStripWicketTags(true);
        getDebugSettings().setAjaxDebugModeEnabled(true);
        getDebugSettings().setDevelopmentUtilitiesEnabled(true);

        getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
        getMarkupSettings().setDefaultMarkupEncoding("UTF-8");

        mountPage("/login", SignInPage.class);
        mountPage("/home",HomePage.class);
    }

}
