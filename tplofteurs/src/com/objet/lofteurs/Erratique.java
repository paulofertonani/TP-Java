/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

import java.util.Random;

/**
 *
 * @author paulo
 */
public class Erratique extends Neuneu{
    
    public Erratique(int energie, int typeNeuneu, Loft monLoft, int position[]){
        super(energie, typeNeuneu, monLoft, position);
        this.nomImage = "erratique.png";
    }

    @Override
    public void manger() {
        //vérifier si il y a une nourriture dans la case oú le neuneu se trouve
        if(this.monLoft.c[this.position[0]][this.position[1]].getNourriture() != null){
            this.energie = this.energie + 20;
            this.monLoft.c[this.position[0]][this.position[1]].soustraireNourriture();
            //vérifier si la lourriture est dejà fini, et la effacer dans ce cas
            if( this.monLoft.c[this.position[0]][this.position[1]].getQuantiteNourriture() <=0  ){
                this.effacerNourriture( this.monLoft.c[this.position[0]][this.position[1]].getNourriture() );
            }
            

        }
    }

    @Override
    public void reproduire() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   @Override
    public void deplacer() {
        Random randomGenerator = new Random();
        
        //je fait ça parce que si je faire testVide = this.position, en changeant 
        //testVide, je vais changer aussi this.position..........
        int[] testVide;
        int intermediario, intermediario2;
        testVide = new int[2];
        intermediario = this.position[0];
        intermediario2 = this.position[1];
        
        testVide[0] = intermediario;
        testVide[1] = intermediario2;
        
        
        switch (randomGenerator.nextInt(8)){
            case 0:
                if(this.position[0] != 0){
                    testVide[0] = this.position[0] - 1;
                }
                if(this.position[1] != 0){
                   testVide[1] = this.position[1] - 1; 
                }
                if (this.monLoft.caseVide(testVide[0], testVide[1])){
                    this.position = testVide;
                }
                break;
            case 1:
                if(this.position[1] != 0){
                   testVide[1] = this.position[1] - 1; 
                }
                if (this.monLoft.caseVide(testVide[0], testVide[1])){
                    this.position = testVide;
                }
                break;
            case 2:
                if(this.position[0] != this.monLoft.getTailleLoft() - 1){
                    testVide[0] = this.position[0] + 1;
                }
                if(this.position[1] != 0){
                   testVide[1] = this.position[1] - 1; 
                }
                if (this.monLoft.caseVide(testVide[0], testVide[1])){
                    this.position = testVide;
                }
                break;
            case 3:
                if(this.position[0] != this.monLoft.getTailleLoft() - 1){
                    testVide[0] = this.position[0] + 1;
                }
                if (this.monLoft.caseVide(testVide[0], testVide[1])){
                    this.position = testVide;
                }
                break;
            case 4:
                if(this.position[0] != this.monLoft.getTailleLoft() - 1){
                    testVide[0] = this.position[0] + 1;
                }
                if(this.position[1] != this.monLoft.getTailleLoft() - 1){
                   testVide[1] = this.position[1] + 1; 
                }
                if (this.monLoft.caseVide(testVide[0], testVide[1])){
                    this.position = testVide;
                }
                break;
            case 5:
                if(this.position[1] != this.monLoft.getTailleLoft() - 1){
                   testVide[1] = this.position[1] + 1; 
                }
                if (this.monLoft.caseVide(testVide[0], testVide[1])){
                    this.position = testVide;
                }
                break;
            case 6:
                if(this.position[0] != 0){
                    testVide[0] = this.position[0] - 1;
                }
                if(this.position[1] != this.monLoft.getTailleLoft() - 1){
                   testVide[1] = this.position[1] + 1; 
                }
                if (this.monLoft.caseVide(testVide[0], testVide[1])){
                    this.position = testVide;
                }
                break;
            case 7:
                if(this.position[0] != 0){
                    testVide[0] = this.position[0] - 1;
                }
                if (this.monLoft.caseVide(testVide[0], testVide[1])){
                    this.position = testVide;
                }
                break;
            default:
                System.out.println("deu pau !!");
                break;
        }
        
        this.energie--;
    }
    
    
}
