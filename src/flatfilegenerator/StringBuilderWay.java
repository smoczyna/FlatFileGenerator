/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flatfilegenerator;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smorcja
 */
public class StringBuilderWay {

    private static final String CSV_SEPARATOR = ";";

    private static void writeToCSV(List<BilledCsvFileDTO> items, String filePath) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
            for (BilledCsvFileDTO item : items) {
                StringBuffer row = new StringBuffer();
                row.append(item.getHomeSbid());
                row.append(CSV_SEPARATOR);
                row.append(item.getServingSbid());
                row.append(CSV_SEPARATOR);
                row.append(item.getMessageSource() == null || item.getMessageSource().isEmpty() ? "" : item.getMessageSource());
                row.append(CSV_SEPARATOR);
                row.append(item.getIncompleteInd()==null || item.getIncompleteInd().isEmpty() ? "" : item.getIncompleteInd());
                row.append(CSV_SEPARATOR);
                row.append(item.getAirProdId() == null ? "" : item.getAirProdId());
                row.append(CSV_SEPARATOR);
                row.append(item.getIncompleteProdId() == null ? "" : item.getIncompleteProdId());
                row.append(CSV_SEPARATOR);
                row.append(item.getIncompleteCallSurcharge() == null ? "" : item.getIncompleteCallSurcharge());
                row.append(CSV_SEPARATOR);
                row.append(item.getAirSurchargeProductId() == null ? "" : item.getAirSurchargeProductId());
                row.append(CSV_SEPARATOR);
                row.append(item.getAirSurcharge() == null ? "" : item.getAirSurcharge());
                row.append(CSV_SEPARATOR);
                row.append(item.getInterExchangeCarrierCode() == null ? "" : item.getInterExchangeCarrierCode());
                row.append(CSV_SEPARATOR);
                row.append(item.getTollProductId() == null ? "" : item.getTollProductId());
                row.append(CSV_SEPARATOR);
                row.append(item.getTollCharge() == null ? "" : item.getTollCharge());
                row.append(CSV_SEPARATOR);
                row.append(item.getTollSurchargeProductId() == null ? "" : item.getTollSurchargeProductId());
                row.append(CSV_SEPARATOR);
                row.append(item.getTollSurcharge() == null ? "" : item.getTollSurcharge());
                row.append(CSV_SEPARATOR);
                row.append(item.getTollStateTax() == null ? "" : item.getTollStateTax());
                row.append(CSV_SEPARATOR);
                row.append(item.getTollLocalTax() == null ? "" : item.getTollLocalTax());
                row.append(CSV_SEPARATOR);
                row.append(item.getLocalAirTax() == null ? "" : item.getLocalAirTax());
                row.append(CSV_SEPARATOR);
                row.append(item.getStateAirTax() == null ? "" : item.getStateAirTax());
                row.append(CSV_SEPARATOR);
                row.append(item.getWholesalePeakAirCharge() == null ? "" : item.getWholesalePeakAirCharge());
                row.append(CSV_SEPARATOR);
                row.append(item.getWholesaleOffPeakAirCharge() == null  ? "" : item.getWholesaleOffPeakAirCharge());
                row.append(CSV_SEPARATOR);
                row.append(item.getWholesaleTollChargeLDPeak() == null ? "" : item.getWholesaleTollChargeLDPeak());
                row.append(CSV_SEPARATOR);
                row.append(item.getWholesaleTollChargeLDOther() == null ? "" : item.getWholesaleTollChargeLDOther());
                row.append(CSV_SEPARATOR);
                row.append(item.getSpace() == null || item.getSpace().isEmpty() ? "" : item.getSpace());
                row.append(CSV_SEPARATOR);
                row.append(item.getFinancialMarket() == null || item.getFinancialMarket().isEmpty() ? "" : item.getFinancialMarket());
                row.append(CSV_SEPARATOR);
                row.append(item.getTollProductId() == null ? "" : item.getTollProductId());
                row.append(CSV_SEPARATOR);
                row.append(item.getDeviceType() == null || item.getDeviceType().isEmpty()  ? "" : item.getDeviceType());
                row.append(CSV_SEPARATOR);
                row.append(item.getAirBillSeconds() == null ? "" : item.getAirBillSeconds());
                row.append(CSV_SEPARATOR);
                row.append(item.getTollBillSeconds() == null ? "" : item.getTollBillSeconds());
                row.append(CSV_SEPARATOR);
                row.append(item.getWholesaleUsageBytes() == null ? "" : item.getWholesaleUsageBytes());               
                bw.write(row.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
    
    public void generate() {
        BilledCsvFileDTO rec = new BilledCsvFileDTO();
        rec.setHomeSbid("1");
        rec.setServingSbid("1");
        rec.setMessageSource("generated");
        rec.setFinancialMarket("dublin");
        rec.setAirBillSeconds(500);
        rec.setAirSurcharge(34.67);
        rec.setTollCharge(345.78);
        
        List<BilledCsvFileDTO> list = new ArrayList();
        list.add(rec);
        
        writeToCSV(list, "c:/Users/smorcja/Temp/SPRING-BATCH-IN/billed-bookins.csv");
    }
}
