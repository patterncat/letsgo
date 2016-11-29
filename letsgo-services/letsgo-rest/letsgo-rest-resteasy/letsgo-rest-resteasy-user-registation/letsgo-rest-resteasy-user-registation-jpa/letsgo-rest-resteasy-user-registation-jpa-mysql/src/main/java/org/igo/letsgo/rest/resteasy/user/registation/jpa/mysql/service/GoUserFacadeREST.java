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
package org.igo.letsgo.rest.resteasy.user.registation.jpa.mysql.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.igo.entities.GoUser;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
@Path("user")
public class GoUserFacadeREST extends AbstractFacade<GoUser> {

    @PersistenceContext(unitName = "gamePU")
    private EntityManager em;

    public GoUserFacadeREST() {
        super(GoUser.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response createUser(User user) {

        String originalPassword = user.getPassword();
        String repetitionPassword = user.getPasswordRepetition();

        if (passwordComplexityChecks(originalPassword)) {
            user.setLastError(java.util.ResourceBundle.getBundle("Bundle").getString("PASSWORD_TOO_WEAK"));
            return Response.status(Response.Status.BAD_REQUEST).entity(user).build();
        }
        if (!repetitionPassword.equals(originalPassword)) {
            user.setLastError(java.util.ResourceBundle.getBundle("Bundle").getString("PASSWORDS_DO_NOT_MATCH"));
            return Response.status(Response.Status.BAD_REQUEST).entity(user).build();
        }

        final String url = "http://localhost:8080/letsgo-rest-resteasy-password-utils/webresources/user/" + originalPassword;
        final ResteasyClient client = new ResteasyClientBuilder().build();
        final ResteasyWebTarget target = client.target(url);
        final PasswordHash passwordHash = target.request().get(PasswordHash.class);
        final GoUser goUser = new GoUser(); //TODO: get url from eurica, consul, uuid
        goUser.setUserName(user.getLogin());
        goUser.setPassword(passwordHash.getHash());
        goUser.setSalt(passwordHash.getSalt());

        try {
            create(goUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        user.setUserURL(goUser.getId().toString());
        return Response.ok(user).build();
    }

    @Override
    public void create(GoUser entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, GoUser entity) {
        // super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        //super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public GoUser find(@PathParam("id") Integer id) {
        super.find(id);
        return null;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<GoUser> findAll() {
        super.findAll();
        return null;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<GoUser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        super.findRange(new int[]{from, to});
        return null;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    private boolean passwordComplexityChecks(String originalPassword) {
        //TODO: вызвать службу валидации пароля
        // PasswordValidator passwordValidator = new PasswordValidator();
        return true; //passwordValidator.validate(originalPassword);
    }
}
