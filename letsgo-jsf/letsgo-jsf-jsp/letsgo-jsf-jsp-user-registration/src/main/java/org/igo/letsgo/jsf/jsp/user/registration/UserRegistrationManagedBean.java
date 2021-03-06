/*
 * Copyright (C) 2016 surzhin.konstantin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.igo.letsgo.jsf.jsp.user.registration;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import java.io.File;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author surzhin.konstantin
 */
@Named(value = "userRegistrationManagedBean")
@RequestScoped
public class UserRegistrationManagedBean {

    private String login;
    private String password;
    private String rpassword;
    private String lastError;

    /**
     * Creates a new instance of UserRegistrationManagedBean
     */
    public UserRegistrationManagedBean() {
    }

    public void addUser() {

        if (!password.equals(rpassword)) {
            FacesContext.getCurrentInstance().addMessage("userForm:newPassword2", new FacesMessage(java.util.ResourceBundle.getBundle("Bundle").getString("ERROR_PASSWORD2")));
            return;
        }

        final String url = "http://localhost:8080//letsgo-rest-resteasy-user-registation-jpa-mysql/webresources/user/"; //NOI18N
        final ResteasyClient client = new ResteasyClientBuilder().build();
        final ResteasyWebTarget target = client.target(url);
        final User outUser = new User();

        outUser.setLogin(login);
        outUser.setPassword(password);
        outUser.setPasswordRepetition(rpassword);
        
        //toFile(outUser);

        final Entity entity = Entity.entity(outUser, MediaType.APPLICATION_XML);
        try {
            final User inUser = target.request().post(entity, User.class);
            String userUrl = (inUser.getUserURL());
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            ec.redirect(userUrl);

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage("error", new FacesMessage(ex.getMessage())); //NOI18N
        }
    }

    private void toFile(User user) {
        try {

            final File file = new File("D:\\file.xml"); //NOI18N
            final JAXBContext jaxbContext = JAXBContext.newInstance(User.class
            );
            final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(user, file);
            jaxbMarshaller.marshal(user, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the rpassword
     */
    public String getRpassword() {
        return rpassword;
    }

    /**
     * @param rpassword the rpassword to set
     */
    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }

    /**
     * @return the lastError
     */
    public String getLastError() {
        return lastError;
    }

    /**
     * @param lastError the lastError to set
     */
    public void setLastError(String lastError) {
        this.lastError = lastError;
    }
}
