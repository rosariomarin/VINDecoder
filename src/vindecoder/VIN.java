/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vindecoder;

/**
 *
 * @author Rosario Marin
 */
public class VIN {

    private final String value;

    private CatalogueCountry countryMap = CatalogueCountry.getDefault();
    private CatalogueManufacturer manufacturerMap = CatalogueManufacturer.getDefault();
    private CatalogueBodyStyle catalogueBodyStyle = new CatalogueBodyStyle();

    public VIN(String vin) throws Exception {
        value = vin.toUpperCase();
        if (isValidSize()) {
            if (isValidCharacters()) {
                try {
                    getInformationVIN();
                } catch (Exception e) {
                    throw new Exception("Error while parsing VIN");
                }
            } else {
                System.out.println("Invalid character in VIN");
            }
        } else {
            System.out.println("Invalid size VIN");
        }

    }

    private boolean isValidSize() {
        return value.length() == 17;
    }

    private boolean isValidCharacters() {
        char character;
        for (int i = 0; i < value.length(); i++) {
            character = value.charAt(i);
            if (character == 'I' || character == 'O' || character == 'Q') {
                return false;
            }
        }
        return true;
    }

    public String getInformationVIN() {
        return "Pais: " + getCountry() + " - [" + getCountryCode() + "] \n"
                + "Fabricante: " + getManufacturer() + " - [" + getManufacturerCode() + "] \n"
                + "Descripcion de Vehiculo: [" + getVDSCode() + "] \n"
                + "Tipo de Carroceria: " + getBodyStyle() + " - [" + getBodyStyleCode() + "] \n"
                + "Tipo de Motor: [" + getEngineCode() + "] \n"
                + "Modelo: [" + getModelCode() + "] \n"
                + "Digito de Confirmacion: [" + getWeightDigit() + "] \n"
                + validateWeightDigit() + " \n"
                + "Año: " + getYear() + " - [" + getYearCode() + "] \n"
                + "Planta de Ensamblaje: [" + getAssemblyPlantCode() + "] \n"
                + "Numero de Serie: [" + getSerialNumber() + "] \n";
    }

    public String getCountryCode() {
        return value.substring(0, 2);
    }

    public String getCountry() {
        String country;
        country = countryMap.get(getCountryCode());
        return country != null ? country : "Country is not in Catalogue";
    }

    public String getManufacturerCode() {
        return isLess500() ? value.substring(11, 13) : value.substring(1, 3);
    }

    public String getManufacturer() {
        String manufacturer;
        manufacturer = manufacturerMap.get(getManufacturerCode());
        return manufacturer != null ? manufacturer : "Manufacturer is not in Catalogue";

    }

    /**
     * @return Whether production line is less than 500 unit per year.
     */
    public boolean isLess500() {
        char ch = value.charAt(2);
        return ch == '9';
    }

    /**
     * @return Vehicle Description(VDS).
     */
    public String getVDSCode() {
        return value.substring(3, 8);
    }

    public String getBodyStyleCode() {
        return value.substring(3, 4);
    }

    public String getBodyStyle() {
        String bodyStyle;
        bodyStyle = catalogueBodyStyle.getValue(getBodyStyleCode());
        return bodyStyle != null ? bodyStyle : "BodyStyle is not in Catalogue";

    }

    public String getEngineCode() {
        return value.substring(4, 5);
    }

    public String getModelCode() {
        return value.substring(6, 8);
    }

    /**
     * @return Checksum digit (Position 9 in VIN).
     */
    public char getWeightDigit() {
        int prodSum = 0;
        for (int i = 0; i < value.length(); i++) {
            String letter = value.substring(i, i + 1);
            int factor = VINConstants.WEIGHT_FACTOR[i];
            int weight = VINConstants.WEIGHTS.get(letter);
            prodSum += factor * weight;
        }
        if (prodSum % 11 == 10) {
            return 'X';
        } else {
            return (char) ('0' + prodSum % 11);
        }
    }

    /**
     * @return Check-digit
     */
    private String validateWeightDigit() {
        return getWeightDigit() == value.charAt(8) ? "VIN valido" : "VIN NO valido ";
    }

    public String getYearCode() {
        return value.substring(9, 10);
    }

    public int getYear() {
        String yearModelCode = value.substring(9, 10);
        int yearModelVal = VINConstants.YEAR_INDEX.get(yearModelCode);
        yearModelVal = 1980 + (yearModelVal % 30);
        return yearModelVal;
    }

    public String getAssemblyPlantCode() {
        return value.substring(10, 11);
    }

    public String getSerialNumber() {
        return isLess500() ? value.substring(14, 17) : value.substring(11, 17);
    }

    public String getValue() {
        return this.value;
    }

    public CatalogueCountry getCountryMap() {
        return countryMap;
    }

    public void setCountryMap(CatalogueCountry countryMap) {
        this.countryMap = countryMap;
    }

    public CatalogueManufacturer getManufacturerMap() {
        return manufacturerMap;
    }

    public void setManufacturerMap(CatalogueManufacturer manufacturerMap) {
        this.manufacturerMap = manufacturerMap;
    }

}
