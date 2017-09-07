/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flatfilegenerator;

import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smorcja
 */
public class RecordBuilder {

    /* public void generateFixedLEngthBilledFile(String fielPath) {
        FixedWidthFields billedFields = new FixedWidthFields();
        billedFields.addField("HomeSbid", 5);
        billedFields.addField("ServingSbid", 5);
        billedFields.addField("MessageSource", 1);
        billedFields.addField("IncompleteInd", 1);
        billedFields.addField("AirProdId", 4);
        billedFields.addField("IncompleteProdId", 4);
        billedFields.addField("IncompleteCallSurcharge", 4);
        billedFields.addField("AirSurchargeProductId", 4);
        billedFields.addField("");
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();
        billedFields.addField();

        //Format for clients' records
//        FixedWidthFields clientFields = new FixedWidthFields();
//        clientFields.addField("Lookahead", 5); //clients have their lookahead in a separate column
//        clientFields.addField("ClientID", 15, FieldAlignment.RIGHT, '0'); //let's pad client ID's with leading zeroes.
//        clientFields.addField("Name", 20);
        FixedWidthWriterSettings settings = new FixedWidthWriterSettings();
        settings.getFormat().setLineSeparator("\n");
        settings.getFormat().setPadding('_');

        //If a record starts with C#, it's a client record, so we associate "C#" with the client format.
        //settings.addFormatForLookahead("C#", clientFields);
        //Rows starting with #A should be written using the account format
        settings.addFormatForLookahead("A#", accountFields);

        StringWriter out = new StringWriter();

        //Let's write
        FixedWidthWriter writer = new FixedWidthWriter(out, settings);

        writer.writeRow(new Object[]{"C#", 23234, "Miss Foo"});
        writer.writeRow(new Object[]{"A#23234", "HSBC", "123433-000", "HSBCAUS"});
        writer.writeRow(new Object[]{"A#234", "HSBC", "222343-130", "HSBCCAD"});
        writer.writeRow(new Object[]{"C#", 322, "Mr Bar"});
        writer.writeRow(new Object[]{"A#1234", "CITI", "213343-130", "CITICAD"});

        writer.close();

        System.out.println(out.toString());
    } */
    public void generateCsvBilledFile(String filePath) {
//        try {
            //OutputStream outputFile = new FileOutputStream(filePath);

            ByteArrayOutputStream csvResult = new ByteArrayOutputStream();
            Writer outputWriter = new OutputStreamWriter(csvResult);
            CsvWriter writer = new CsvWriter(outputWriter, new CsvWriterSettings());
//            writer.writeHeaders("homeSbid",
//                    "servingSbid",
//                    "messageSource",
//                    "incompleteInd",
//                    "airProdId",
//                    "incompleteProdId",
//                    "incompleteCallSurcharge",
//                    "airSurchargeProductId",
//                    "airSurcharge",
//                    "interExchangeCarrierCode",
//                    "tollProductId",
//                    "tollCharge",
//                    "tollSurchargeProductId",
//                    "tollSurcharge",
//                    "tollStateTax",
//                    "tollLocalTax",
//                    "localAirTax",
//                    "stateAirTax",
//                    "wholesalePeakAirCharge",
//                    "wholesaleOffPeakAirCharge",
//                    "wholesaleTollChargeLDPeak",
//                    "wholesaleTollChargeLDOther",
//                    "space",
//                    "financialMarket",
//                    "deviceType",
//                    "airBillSeconds",
//                    "tollBillSeconds",
//                    "wholesaleUsageBytes");

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
            List<Object[]> rows = new ArrayList();
            rows.add(list.toArray());
            writer.writeRowsAndClose(rows);
//            List<String> result = writer.writeRowsToString(rows);
//            for (String row : result) {
//                System.out.println(row.toString());
//            }

            //csvResult.writeTo(outputFile);
            Object[] objRows = rows.toArray();
            
            System.out.println(printArrayElements(objRows));
            
//        } catch (FileNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
    }

    private static <T> String printArrayElements(T[] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }
        StringBuilder out = new StringBuilder();
        out.append('[');

        for (int i = 0; i < array.length; i++) {
            T value = array[i];
            if (out.length() != 1) {
                out.append(',');
            }
            if (value == null) {
                out.append("<null>");
            } else {
                out.append('<').append(String.valueOf(value)).append('>');
            }
        }

        out.append(']');
        return out.toString();
    }
}
