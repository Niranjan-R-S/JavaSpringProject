package sample_gradle_project.rna_transcription;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class RnaTranscriptionTest {

    @Test public void testDnaToRnaConversionCorrectValue(){
        RnaTranscription classUnderTest = new RnaTranscription();
        HashMap< String,String> hm = new HashMap< String,String>();
        hm.put("dnaValue", "CGTA");
        String rnaValue = "GCAU";
        assertEquals(rnaValue, classUnderTest.convertDnaToRna(hm).get("rnaStrand").toString());
    }

    @Test public void testDnaToRnaConversionWrongValueOne(){
        RnaTranscription classUnderTest = new RnaTranscription();
        HashMap< String,String> hm = new HashMap< String,String>();
        hm.put("dnaValue", "CGTF");
        String rnaValue = "GCAN";
        assertEquals(rnaValue, classUnderTest.convertDnaToRna(hm).get("rnaStrand").toString());
    }

    @Test public void testDnaToRnaConversionWrongValueTwo(){
        RnaTranscription classUnderTest = new RnaTranscription();
        HashMap< String,String> hm = new HashMap< String,String>();
        hm.put("dnaValue", "CnTl");
        String rnaValue = "GNAN";
        assertEquals(rnaValue, classUnderTest.convertDnaToRna(hm).get("rnaStrand").toString());
    }

    @Test public void testDnaToRnaConversionWrongValueThree(){
        RnaTranscription classUnderTest = new RnaTranscription();
        HashMap< String,String> hm = new HashMap< String,String>();
        hm.put("dnaValue", "CnTlkk");
        String rnaValue = "GNANNN";
        assertEquals(rnaValue, classUnderTest.convertDnaToRna(hm).get("rnaStrand").toString());
    }
}
