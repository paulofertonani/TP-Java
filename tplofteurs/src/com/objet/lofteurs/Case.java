/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

/**
 *
 * @author paulo
 */
public class Case {
    /**
     * Definition des elements possibles dans une case
     * 
     * 
     * 
     *  */
    private Nourriture nourriture;
    private Neuneu neuneu;

    public Case(Nourriture n) {
        this.nourriture = n;
    }

    public Neuneu getNeuneu() {
        return neuneu;
    }

    public void setNeuneu(Neuneu neuneu) {
        this.neuneu = neuneu;
    }

    public Nourriture getNourriture() {
        return nourriture;
    }

    public void setNourriture(Nourriture nourriture) {
        this.nourriture = nourriture;
    }
    
    public int getQuantiteNourriture(){
        return this.nourriture.quantiteNourriture;
    }
    
    
    public void soustraireNourriture(){
        this.nourriture.quantiteNourriture--;
    }

    
    
    
    
    
    
    
    
}
