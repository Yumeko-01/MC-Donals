package co.edu.unipiloto.estdatos.colas.interfaz;

import co.edu.unipiloto.estdatos.colas.interfaz.*;
import co.edu.unipiloto.estdatos.colas.mundo.AdministracionMcDonalds;

public class Main{
  
  
  public static void main(String[] args){
    
    AdministracionMcDonalds administracion = new AdministracionMcDonalds();  
    McDonaldsCLI mcDonaldsCLI = new McDonaldsCLI();
    try {
      mcDonaldsCLI.mainMenu();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
  
}