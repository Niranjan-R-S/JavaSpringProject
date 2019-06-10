package sample_gradle_project.rna_transcription;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

public class RnaTranscription {

    @Id
    public ObjectId _id;

    public String dnaValue;
    public String rnaValue;
    public boolean converted;

    public RnaTranscription(){}

    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public HashMap<String, Object> convertDnaToRna(HashMap<String, String> payload){
        String dnaComponent[] = {"G", "C", "T", "A"};
        String rnaComponent[] = {"C", "G", "A", "U"};
        boolean converted = false;
        Map< String,String> hm = new HashMap< String,String>();
        for(int i=0;i<dnaComponent.length; i++){
            hm.put(dnaComponent[i], rnaComponent[i]);
        }
        String dnaValue = payload.get("dnaValue");
        StringBuilder rnaValue = new StringBuilder(dnaValue);
        for(int i=0; i<dnaValue.length(); i++){
            char characterFound;
            try{
                characterFound = (hm.get(("" + dnaValue.charAt(i)).toUpperCase())).charAt(0);
            }
            catch(Exception e){
                characterFound = 'N';
            }
            rnaValue.setCharAt(i, characterFound);
        }
        HashMap<String, Object> finalMap = new HashMap<>();
        if ((rnaValue.indexOf("N") < 0)) {
            converted = true;
        }
        finalMap.put("rnaStrand", rnaValue);
        finalMap.put("converted", converted);
        finalMap.put("dnaValue", dnaValue);
        return finalMap;
    }
}
