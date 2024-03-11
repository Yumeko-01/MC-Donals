package co.edu.unipiloto.estdatos.colas.interfaz;

import co.edu.unipiloto.estdatos.colas.interfaz.*;

public class Main{
  
  
  public static void main(String[] args){
    
    McDonaldsCLI mcDonaldsCLI = new McDonaldsCLI();
    try {
      mcDonaldsCLI.mainMenu();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
  
}