package com.trnet.managedBean;

import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Locale;

@ManagedBean(name = "userMB")
@SessionScoped
public class UserMB {

    private Locale locale = new Locale("tr");
    private static final Logger logger = Logger.getLogger(UserMB.class);

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void changeLanguage(String language) {
        try{
            locale = new Locale(language);

            logger.warn("Selected language is : " + language);
        }catch(Exception ex){
            logger.error("Sorry, something wrong!", ex);
        }

        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }
}