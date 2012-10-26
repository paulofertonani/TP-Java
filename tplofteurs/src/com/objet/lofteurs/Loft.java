/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author paulo
 */
public class Loft implements ObjetDessinable{
    /**
     * Nombre de cases du Loft sera w*h
     * Pour la création des contenus au dedans des cases, j'ai ajouté des 
     * nourritures (et ses quantites en chaque case) par hazard, et en ce
     * que les quantités seront au maximum de 10 par case
     * 
     * 
     * @param w dimension horizontale
     * @param h dimension verticale
     * 
     */
    private int tailleLoft;
    private ZoneGraphique zone;
    protected Case[][] c;
    protected ArrayList<Nourriture> listanou;
    protected ArrayList<Neuneu> listaneu;
    
    
    
    
    public Loft(int tailleLoft, ZoneGraphique zone ) {
        this.tailleLoft = tailleLoft;
        this.zone = zone;
    }

    @Override
    public void dessinerObjet(Graphics g) {
        int size = 600; //size in pixels
                
        BufferedImage bufImg = new BufferedImage(size, size, BufferedImage.TYPE_4BYTE_ABGR);

        BufferedImage solo;

        try {
                solo        = ImageIO.read(new File("brown.jpeg"));

                Graphics horsEcran = bufImg.getGraphics();

                for(int i = 0; i < this.tailleLoft; i++){
                        for(int j = 0; j < this.tailleLoft; j++){
                                horsEcran.drawImage(solo, i * 20, j * 20, null);
                        }
                }
                
                //pour dessiner des nourritures
                for(Nourriture n : this.listanou){
                        BufferedImage bufImgNourriture = ImageIO.read(new File(n.getNomImage()));
                       int pos[] = n.getPosition();
                        horsEcran.drawImage(bufImgNourriture, pos[0] * 20, pos[1] * 20, null);        
                }
                
                //pour dessiner des neuneus
                for(Neuneu n : this.listaneu){
                        BufferedImage imgNeneu = ImageIO.read(new File(n.getNomImage()));
                        int pos[] = n.getPosition();
                        horsEcran.drawImage(imgNeneu, pos[0] * 20, pos[1] * 20, null);
                }

                g.drawImage(bufImg, 0, 0, null);

        } catch (IOException e) {
                System.out.println("Exception:(image!!) " + e.getMessage());
                e.printStackTrace();
        }
        
        
        
    }
    
    public void remplissageAleatoire(int proportionAleatoire){
        this.listanou = new ArrayList<Nourriture>();
        this.c = new Case[this.tailleLoft][this.tailleLoft];
        
        for(int i=0; i<tailleLoft; i++){
            for(int j=0; j<tailleLoft; j++){
                int position[];
                position = new int[2];
                position[0] = i;
                position[1] = j;
                Random randomGenerator = new Random();
                
                if (randomGenerator.nextInt(proportionAleatoire) >= 10){
                    Nourriture n;
                    //n = new Nourriture(randomGenerator.nextBoolean(), randomGenerator.nextInt(5), position);
                    n = new Nourriture(randomGenerator.nextBoolean(), randomGenerator.nextInt(2), 2, this, position);
                    
                    this.listanou.add(n);
                
                    this.c[i][j] = new Case(n);
                }
                else{                
                    this.c[i][j] = new Case(null);
                }
                    
                
            }
            
            
            
        }
    }
    
    public void ajouterNeuneusAleatoire(int proportionAleatoire){
        this.listaneu = new ArrayList<Neuneu>();
        
        for(int i=0; i<tailleLoft; i++){
            for(int j=0; j<tailleLoft; j++){
                int position[];
                position = new int[2];
                position[0] = i;
                position[1] = j;
                Random randomGenerator = new Random();
                
                if (randomGenerator.nextInt(proportionAleatoire) >= 100){
                    Erratique e;
                    e = new Erratique(100, 1, this, position);
                    
                    this.listaneu.add(e);
                    this.c[i][j].setNeuneu(e);
                    
                }
                else{                
                    this.c[i][j].setNeuneu(null);
                }
                
                
            }
        }
    }
    
    public int getTailleLoft(){
        return this.tailleLoft;
    }
    
    //methode que retourne true si la case est vide...
    public boolean caseVide(int positionX, int positionY){
        if (this.c[positionX][positionY].getNeuneu() == null ){
            return true;
        }
        
        return false;
    }
    
    public void remplacerNeuneuCase(int[] positionInitial, int[] positionFinal, Neuneu n){
        this.c[positionInitial[0]][positionInitial[1]].setNeuneu(null);
        this.c[positionFinal[0]][positionFinal[1]].setNeuneu(n);
        
    }
    
    public void go(Graphics g){
        
        while(true){
            
            
            //ce structure est necessaire pour deplacer chaque neuneu, et 
            //de temps en temps tuer des neuneus sans energie sufisante pour vivre
            int flag = listaneu.size();
            int counter = 0;
            while(flag > 0){
                Neuneu pointer;
                 
                pointer = listaneu.get(counter);
                
                pointer.deplacer();
                pointer.manger();
                if(pointer.getEnergie()<=0){
                    pointer.tuerNeuneu();
                    flag--;
                }
                
                flag--;
                counter++;
                
            }
            //fin de la structure de deplacement

            this.dessinerObjet(g);
        
        }
        
        
        
        
        
        
    
    }
    

    
    
}
