package ca.uSherbrooke.gegi.opus.shared.entity;

import javax.persistence.*;

/**
 * Created by tomaslopinto on 10/07/16.
 */
@Entity
@Table(name = "stagiaire_interesse_par_employeur", schema = "recrusimple", catalog = "opus")
@IdClass(StagiaireInteresseParEmployeurEntityPK.class)
public class StagiaireInteresseParEmployeurEntity {
    private int stagiaireId;
    private int employeurId;
    private char interet;

    @Id
    @Column(name = "stagiaire_id")
    public int getStagiaireId() {
        return stagiaireId;
    }

    public void setStagiaireId(int stagiaireId) {
        this.stagiaireId = stagiaireId;
    }

    @Id
    @Column(name = "employeur_id")
    public int getEmployeurId() {
        return employeurId;
    }

    public void setEmployeurId(int employeurId) {
        this.employeurId = employeurId;
    }

    @Basic
    @Column(name = "interet")
    public char getInteret() {
        return interet;
    }

    public void setInteret(char interet) {
        this.interet = interet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StagiaireInteresseParEmployeurEntity that = (StagiaireInteresseParEmployeurEntity) o;

        if (stagiaireId != that.stagiaireId) return false;
        if (employeurId != that.employeurId) return false;
        if (interet != that.interet) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stagiaireId;
        result = 31 * result + employeurId;
        result = 31 * result + (int) interet;
        return result;
    }
}
