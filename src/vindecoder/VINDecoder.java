/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vindecoder;

import java.util.Scanner;

/**
 *
 *  @author Rosario Marin
 */
public class VINDecoder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                try {
            System.out.println("-------------------------------------------");
            System.out.println("\t VIN Decoder (17 Digits)");
            System.out.println("-------------------------------------------");
            System.out.println("Numero de VIN:");
            String input;
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();
            
            VIN vin = new VIN(input);
            System.out.println("");
            System.out.println(vin.getInformationVIN());
            
        } catch (Exception ex) {
            System.out.println("ERROR while decoding VIN");
            //Logger.getLogger(VINDecoder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
