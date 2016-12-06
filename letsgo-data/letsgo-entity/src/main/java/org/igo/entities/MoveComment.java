/*
 * Copyright (C) 2016 Surzhin.Konstantin
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
package org.igo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "MOVE_COMMENTS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"move_game_id", "user_details_id", "move_ndx", "move_comment"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MoveComment.findAll", query = "SELECT m FROM MoveComment m")
    ,@NamedQuery(name = "MoveComment.findById", query = "SELECT m FROM MoveComment m WHERE m.id = :id")
    ,@NamedQuery(name = "MoveComment.findByMoveComment", query = "SELECT m FROM MoveComment m WHERE m.moveComment = :moveComment")
    ,@NamedQuery(name = "MoveComment.findByPostDateTime", query = "SELECT m FROM MoveComment m WHERE m.postDateTime = :postDateTime")})
public class MoveComment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String moveComment;
    private Date postDateTime;
    private GameMove gamesMoves;
    private Collection<MoveComment> moveCommentCollection;
    private MoveComment inReplayToId;
    private UserDetails userDetails;

    public MoveComment() {
    }

    public MoveComment(Long id) {
        this.id = id;
    }

    public MoveComment(Long id, Date postDateTime) {
        this.id = id;
        this.postDateTime = postDateTime;
    }

    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "move_comment", length = 255)
    @Size(min = 1, max = 255)
    public String getMoveComment() {
        return moveComment;
    }

    public void setMoveComment(String moveComment) {
        this.moveComment = moveComment;
    }

    @Basic(optional = false)
    @Column(name = "post_date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(Date postDateTime) {
        this.postDateTime = postDateTime;
    }

    @JoinColumns({
        @JoinColumn(name = "move_game_id", referencedColumnName = "game_id")
        ,
        @JoinColumn(name = "move_ndx", referencedColumnName = "ndx")})
    @ManyToOne
    public GameMove getGamesMoves() {
        return gamesMoves;
    }

    public void setGamesMoves(GameMove gamesMoves) {
        this.gamesMoves = gamesMoves;
    }

    @OneToMany(mappedBy = "inReplayToId")
    @XmlTransient
    public Collection<MoveComment> getMoveCommentCollection() {
        return moveCommentCollection;
    }

    public void setMoveCommentCollection(Collection<MoveComment> moveCommentCollection) {
        this.moveCommentCollection = moveCommentCollection;
    }

    @JoinColumn(name = "in_replay_to_id", referencedColumnName = "id")
    @ManyToOne
    public MoveComment getInReplayToId() {
        return inReplayToId;
    }

    public void setInReplayToId(MoveComment inReplayToId) {
        this.inReplayToId = inReplayToId;
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_moveComment_userDetails"), name = "user_details_id", referencedColumnName = "id")
    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoveComment)) {
            return false;
        }
        MoveComment other = (MoveComment) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.entities.MovesComments[ id=" + id + " ]";
    }

}
