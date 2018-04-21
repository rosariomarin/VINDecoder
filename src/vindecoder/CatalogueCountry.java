/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vindecoder;

import java.util.HashMap;

/**
 *
 * @author rmarin
 */
class CatalogueCountry extends HashMap<String, String> {

  private static final String CountryCode[] = {
      "AA-AH", "South Africa", /* A–H = Africa */
      "AJ-AN", "Ivory Coast",
      "AP-A0", "not assigned",
      "BA-BE", "Angola",
      "BF-BK", "Kenya",
      "BL-BR", "Tanzania",
      "BS-B0", "not assigned",
      "CA-CE", "Benin",
      "CF-CK", "Malagasy",
      "CL-CR", "Tunisia",
      "CS-C0", "not assigned",
      "DA-DE", "Egypt",
      "DF-DK", "Morocco",
      "DL-DR", "Zambia",
      "DS-D0", "not assigned",
      "EA-EE", "Ethiopia",
      "EF-EK", "Mozambique",
      "EL-E0", "not assigned",
      "FA-FE", "Ghana",
      "FF-FK", "Nigeria",
      "FF-FK", "Madagascar",
      "FL-F0", "not assigned",
      "GA-G0", "not assigned",
      "HA-H0", "not assigned",
      "JA-J0", "Japan", /* J–R = Asia */
      "KA-KE", "Sri Lanka",
      "KF-KK", "Israel",
      "KL-KR", "Korea (South)",
      "KS-K0", "not assigned",
      "LA-L0", "China",
      "MA-ME", "India",
      "MF-MK", "Indonesia",
      "ML-MR", "Thailand",
      "MS-M0", "not assigned",
      "NF-NK", "Pakistan",
      "NL-NR", "Turkey",
      "NS-N0", "not assigned",
      "PA-PE", "Philipines",
      "PF-PK", "Singapore",
      "PL-PR", "Malaysia",
      "PS-P0", "not assigned",
      "RA-RE", "United Arab Emirates",
      "RF-RK", "Taiwan",
      "RL-RR", "Vietnam",
      "RS-R0", "not assigned",
      "SA-SM", "United Kingdom", /* S–Z = Europe */
      "SN-ST", "Germany",
      "SU-SZ", "Poland",
      "S1-S0", "not assigned",
      "S1-S4", "Latvia",
      "S5-S0", "not assigned",
      "TA-TH", "Switzerland",
      "TJ-TP", "Czech Republic",
      "TR-TV", "Hungary",
      "TW-T1", "Portugal",
      "T2-T0", "not assigned",
      "UA-UG", "not assigned",
      "UH-UM", "Denmark",
      "UN-UT", "Ireland",
      "UU-UZ", "Romania",
      "U1-U4", "not assigned",
      "U5-U7", "Slovakia",
      "U8-U0", "not assigned",
      "VA-VE", "Austria",
      "VF-VR", "France",
      "VS-VW", "Spain",
      "VX-V2", "Yugoslavia",
      "V3-V5", "Croatia",
      "V6-V0", "Estonia",
      "WA-W0", "Germany",
      "XA-XE", "Bulgaria",
      "XF-XK", "Greece",
      "XL-XR", "Netherlands",
      "XS-XW", "U.S.S.R.",
      "XX-X2", "Luxembourg",
      "X3-X0", "Russia",
      "YA-YE", "Belgium",
      "YF-YK", "Finland",
      "YL-YR", "Malta",
      "YS-YW", "Sweden",
      "YX-Y2", "Norway",
      "Y3-Y5", "Belarus",
      "Y6-Y0", "Ukraine",
      "ZA-ZR", "Italy",
      "ZS-ZW", "not assigned",
      "ZX-Z2", "Slovenia",
      "Z3-Z5", "Lithuania",
      "Z6-Z0", "not assigned",
      "1A-10", "United States", /* 1–5 = North America */
      "2A-20", "Canada",
      "3A-3W", "Mexico",
      "3X-37", "Costa Rica",
      "38-30", "not assigned",
      "38-39", "Cayman Islands",
      "4A-40", "United States",
      "5A-50", "United States",
      "6A-6W", "Australia", /* 6–7 = Oceania */
      "6X-60", "not assigned",
      "7A-7E", "New Zealand",
      "7F-70", "not assigned",
      "8A-8E", "Argentina", /* 8–9 = South America */
      "8F-8K", "Chile",
      "8L-8R", "Ecuador",
      "8S-8W", "Peru",
      "8X-82", "Venezuela",
      "83-80", "not assigned",
      "9A-9E", "Brazil",
      "9F-9K", "Colombia",
      "9L-9R", "Paraguay",
      "9S-9W", "Uruguay",
      "9X-92", "Trinidad & Tobago",
      "93-99", "Brazil",
      "90-90", "not assigned",
  };

  public static CatalogueCountry getDefault() {
    CatalogueCountry defaultMap = new CatalogueCountry();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < CountryCode.length; i++) {
      String rangeStr = CountryCode[i++];
      String country = CountryCode[i];
      String rangeStart = rangeStr.substring(1, 2);
      String rangeEnd = rangeStr.substring(4, 5);
      int startIndex = VINConstants.ALPHABET_INDEX.get(rangeStart);
      int endIndex = VINConstants.ALPHABET_INDEX.get(rangeEnd);
      for (int j = startIndex; j <= endIndex; j++) {
        sb.setLength(0);
        sb.append(rangeStr.charAt(0));
        sb.append(VINConstants.ALPHABET_CHARS[j]);
        defaultMap.put(sb.toString(), country);
      }
    }
    return defaultMap;
  }

}
