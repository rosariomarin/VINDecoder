/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vindecoder;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rosario Marin
 */
class VINConstants {

    public static Map<String, Integer> YEAR_INDEX = new HashMap<>();
    public static String YEAR_CHARS[] = {
        "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R",
         "S", "T", "V", "W", "X", "Y", "1", "2", "3", "4", "5", "6", "7",
         "8", "9", "0"};

    public static final Map<String, Integer> ALPHABET_INDEX = new HashMap<>();
    public static final String ALPHABET_CHARS[] = {
        "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R",
         "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7",
         "8", "9", "0"};

    public static final Map<String, Integer> WEIGHTS = new HashMap<>();
    public static final int ALPHABET_WEIGHTS[] = {
        //A,B,C,D,E,F,G,H,J,K,L,M,N,P,R
        1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 7, 9,
        //S,T,U,V,W,X,Y,Z,1,2,3,4,5,6,7
        2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7,
        //8,9,0
        8, 9, 0};

    public static int WEIGHT_FACTOR[]
            = {8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2};

    static {
        int len = VINConstants.ALPHABET_CHARS.length;
        for (int i = 0; i < len; i++) {
            ALPHABET_INDEX.put(VINConstants.ALPHABET_CHARS[i], i);
        }

        for (int i = 0; i < len; i++) {
            WEIGHTS.put(VINConstants.ALPHABET_CHARS[i], ALPHABET_WEIGHTS[i]);
        }

        len = VINConstants.YEAR_CHARS.length;
        for (int i = 0; i < len; i++) {
            YEAR_INDEX.put(VINConstants.YEAR_CHARS[i], i);
        }
    }

}
