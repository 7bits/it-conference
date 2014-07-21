package org.happydev.lite.service;

import org.happydev.lite.model.content.BranchLeader;
import org.happydev.lite.model.content.Speaker;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation for the Branch leaders
 */
public class BranchLeaderPresenter {

    /**
     * Finds concrete branch leader
     * @param id an ID of the Branch leader
     * @return a BranchLeader object or null when the ID is wrong
     */
    public BranchLeader findBranchLeaderById(final Long id) {
        return new BranchLeader();
    }

    /**
     * Finds all Branch leaders for the concrete Event branch
     * @param eventBranchId an ID of the Event branch
     * @return a list of BranchLeader objects
     */
    public List<BranchLeader> findLeadersByEventBranchId(final Long eventBranchId) {
        return new ArrayList<BranchLeader>();
    }

    /**
     * Finds all Branch leaders for the concrete Hall event
     * @param hallEventId an ID of the Hall event
     * @return a list of Speaker objects
     */
    public List<Speaker> findBranchLeadersByHallEventId(final Long hallEventId) {
        return new ArrayList<Speaker>();
    }
}
