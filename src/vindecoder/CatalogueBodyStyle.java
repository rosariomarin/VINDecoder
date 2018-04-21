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
 * @author rmarin
 */
class CatalogueBodyStyle {

    private Map<String, String> catalogueBodyStyle;

    public CatalogueBodyStyle() {
        setupCatalogue();
    }

    public Map<String, String> setupCatalogue() {
        catalogueBodyStyle = new HashMap();

        catalogueBodyStyle.put("A", "5 puertas");
        catalogueBodyStyle.put("B", "3 puertas");
        catalogueBodyStyle.put("C", "");
        catalogueBodyStyle.put("D", "");
        catalogueBodyStyle.put("E", "");
        catalogueBodyStyle.put("F", "4 puertas");
        catalogueBodyStyle.put("N", "Familiar");

        return catalogueBodyStyle;
    }

    public String getValue(String code) {
        return catalogueBodyStyle.get(code);
    }

    public Map<String, String> getCatalogueBodyStyle() {
        return catalogueBodyStyle;
    }
}


