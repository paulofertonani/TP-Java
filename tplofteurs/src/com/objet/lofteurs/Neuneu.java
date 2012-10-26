/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

/**
 *
 * @author paulo
 */
public abstract class Neuneu {
    protected int energie;
    protected int typeNeuneu;
    protected Loft monLoft;
    protected int[] position;
    protected String nomImage;

    public Neuneu(int energie, int typeNeuneu, Loft monLoft, int[] position) {
        this.energie = energie;
        this.typeNeuneu = typeNeuneu;
        this.monLoft = monLoft;
        this.position = position;
    }

    public String getNomImage() {
        return nomImage;
    }
    
    /**
    * La methode retourne le valeur 'int' des neuneus:
    * 1 - erratique
    * 2 - voraces
    * 3 - canibales 
    * 4 - lapins
    *
    */
    public int getTypeNeuneu(){
        return this.typeNeuneu;
    }

    public int getEnergie(){
        return this.energie;
    }

    public void setEnergie(int par){
        this.energie = par;
    }
    
    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }
    
    public void tuerNeuneu(){
        this.monLoft.c[this.position[0]][this.position[1]].setNeuneu(null);
        this.monLoft.listaneu.remove(this);
        
    }
    
    public void effacerNourriture(Nourriture n){
        this.monLoft.c[this.position[0]][this.position[1]].setNourriture(null);
        this.monLoft.listanou.remove(n);
    }

    public abstract void manger();

    public abstract void reproduire();

    public abstract void deplacer();

    
    
}
