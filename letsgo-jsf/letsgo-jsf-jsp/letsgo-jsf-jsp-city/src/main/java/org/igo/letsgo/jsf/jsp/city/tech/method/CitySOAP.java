/*
 * Copyright (C) 2016 pl
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
package org.igo.letsgo.jsf.jsp.city.tech.method;

import javax.ws.rs.core.MediaType;
import org.igo.letsgo.jsf.jsp.city.entity.City;
import org.igo.letsgo.jsf.jsp.city.CityRestClientInterface;

/**
 *
 * @author pl
 */
public class CitySOAP implements CityRestClientInterface{

    @Override
    public City sendCity(String url, MediaType msgMediaType, String dbMetod, String dbName, City city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public City recieveCity(String msgContentType, String dbMetod, String dbName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
