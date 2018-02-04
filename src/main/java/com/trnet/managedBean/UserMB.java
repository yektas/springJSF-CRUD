package com.trnet.managedBean;

import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Locale;

@ManagedBean(name = "userMB")
@SessionScoped
public class UserMB implements Serializable {

    private Locale locale;

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(CarMB.class);


    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void changeLanguage(String language) {
        locale = new Locale(language);

        // logs debug
        if (logger.isDebugEnabled()) {
            logger.debug("UserMB.process()");
        }

        // logs exception
        logger.error("This is Error message for UserMB", new Exception("UserMB Logs"));

        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }
}