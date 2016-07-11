package ca.uSherbrooke.gegi.opus.shared.entity;


import ca.uSherbrooke.gegi.commons.core.shared.entity.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tomaslopinto on 01/06/16.
 */
@NamedNativeQueries({
        @NamedNativeQuery(name = "get_last_id",
                query = "SELECT LASTVAL()"),
        @NamedNativeQuery(name = "save_user",
                query = "INSERT INTO recrusimple.stagiaire (numero_stage,stagiaire_cv,user_id,departement_id)" +
                        "VALUES (#stageNumber," +
                        "        #stagiaireCV," +
                        "        #userID," +
                        "        #deptID)"),
        @NamedNativeQuery(name = "update_user",
                query = "UPDATE recrusimple.stagiaire " +
                        "SET numero_stage = #stageNumber," +
                        "    stagiaire_cv = #stagiaireCV," +
                        "    departement_id = #deptID," +
                        "    user_id = #userID " +
                        "WHERE stagiaire_id = #stagiaireID"),
        @NamedNativeQuery(name = "get_user",
                query = "SELECT stagiaire_id," +
                        "       first_name," +
                        "       last_name," +
                        "       departement_nom," +
                        "       numero_stage " +
                        "FROM recrusimple.release_stagiaire " +
                        "WHERE stagiaire_id = #stagiaireID LIMIT 1",
                resultClass = UserInfosData.class),
        @NamedNativeQuery(name = "get_next_user",
                query = "SELECT * " +
                        "FROM recrusimple.stagiaire AS stagiaire " +
                        "WHERE NOT EXISTS " +
                        "    (SELECT 1 " +
                        "     FROM recrusimple.stagiaire_interesse_par_employeur AS SIE " +
                        "     WHERE stagiaire.stagiaire_id = SIE.stagiaire_id) LIMIT 1",
                resultClass = UserInfosData.class)
})


@Entity
@Table(name = "recrusimple.release_stagiaire", schema = "recrusimple", catalog = "opus")
public class UserInfosData implements Data {
    private int stagiaireID = 0;
    private String firstName = "";
    private String lastName = "";
    private String departementNom = "";
    private String CV = "";
    private int numeroStage = 0;
    private List<ConceptData> interet = null;
    private List<ConceptData> competence = null;

    public UserInfosData(int stagiaireID, String firstName, String lastName, String departementNom, int numeroStage, String id) {
        this.stagiaireID = stagiaireID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departementNom = departementNom;
        this.numeroStage = numeroStage;
        this.id = id;
    }

    public UserInfosData() {
    }

    @Id
    @Basic
    @Column(name = "stagiaire_id")
    public int getStagiaireID() {
        return stagiaireID;
    }

    public void setStagiaireID(int stagiaireID) {
        this.stagiaireID = stagiaireID;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Basic
    @Column(name = "CV")
    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }


    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "departement_nom")
    public String getDepartementNom() {
        return departementNom;
    }

    public void setDepartementNom(String departementNom) {
        this.departementNom = departementNom;
    }

    @Basic
    @Column(name = "numero_stage")
    public int getNumeroStage() {
        return numeroStage;
    }

    public void setNumeroStage(int numeroStage) {
        this.numeroStage = numeroStage;
    }

    @OneToMany
    public List<ConceptData> getInteret() {
        return interet;
    }

    public void setInteret(List<ConceptData> interet) {
        this.interet = interet;
    }

    @OneToMany
    public List<ConceptData> getCompetence() {
        return competence;
    }

    public void setCompetence(List<ConceptData> competence) {
        this.competence = competence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfosData that = (UserInfosData) o;

        if (numeroStage != that.numeroStage) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (departementNom != null ? !departementNom.equals(that.departementNom) : that.departementNom != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (departementNom != null ? departementNom.hashCode() : 0);
        result = 31 * result + numeroStage;
        return result;
    }

    public void setUserId(Integer userId) {
    }

    public Integer getUserId() {
        return null;
    }

    public Integer getId() {
        return null;
    }

    public void setId(Integer nId) {
    }

    public String getLabel() {
        return "";
    }

    public void setLabel(String strLabel) {
    }

    private String id;

    public void setId(String id) {
        this.id = id;
    }
}