/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flatfilegenerator;

/**
 *
 * @author smorcja
 */
public class FlatFileGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        RecordBuilder builder = new RecordBuilder();
//        builder.generateCsvBilledFile("c:/Users/smorcja/Temp/SPRING-BATCH-IN/billed-bookins.csv");
        
        StringBuilderWay builder = new StringBuilderWay();
        builder.generate();
    }
    
}
