/*
 * Copyright (C) 2017 surzhin.konstantin
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
package org.igo.letsgo.security.resteasy.skeleton.key.games;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author surzhin.konstantin
 */
@Path("games")
public class GameService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GameService
     */
    public GameService() {
    }

    /**
     * Retrieves representation of an instance of
     * org.igo.letsgo.security.resteasy.skeleton.key.games.GameService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getGames() {
        final ArrayList<String> games = new ArrayList<>();
        games.add("game 1");
        games.add("game 2");
        games.add("game 3");
        return games;
    }

    /**
     * PUT method for updating or creating an instance of GameService
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putGame(String content) {
    }
}
