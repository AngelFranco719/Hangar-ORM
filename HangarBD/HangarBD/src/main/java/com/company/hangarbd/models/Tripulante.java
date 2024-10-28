
package com.company.hangarbd.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name = "tripulante")
public class Tripulante implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Tripulante;
    @OneToMany(mappedBy = "vueloTripulante")
    public Vuelo tripulanteVuelo;
    @OneToMany(mappedBy = "cargoTripulante")
    public Cargo tripulanteCargo;
    @OneToMany(mappedBy = "personaTripulante")
    public Persona tripulantePersona; 

    public Long getID_Tripulante() {
        return ID_Tripulante;
    }

    public void setID_Tripulante(Long ID_Tripulante) {
        this.ID_Tripulante = ID_Tripulante;
    }

    public Vuelo getTripulanteVuelo() {
        return tripulanteVuelo;
    }

    public void setTripulanteVuelo(Vuelo tripulanteVuelo) {
        this.tripulanteVuelo = tripulanteVuelo;
    }

    public Cargo getTripulanteCargo() {
        return tripulanteCargo;
    }

    public void setTripulanteCargo(Cargo tripulanteCargo) {
        this.tripulanteCargo = tripulanteCargo;
    }

    public Persona getTripulantePersona() {
        return tripulantePersona;
    }

    public void setTripulantePersona(Persona tripulantePersona) {
        this.tripulantePersona = tripulantePersona;
    }
    
    
}
