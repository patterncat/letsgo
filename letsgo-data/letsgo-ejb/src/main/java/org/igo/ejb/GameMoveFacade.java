/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.igo.entities.GameMove;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class GameMoveFacade extends AbstractFacade<GameMove> {

    @PersistenceContext(unitName = "gamePU")
    private EntityManager em;

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     */
    public GameMoveFacade() {
        super(GameMove.class);
    }
    
}
