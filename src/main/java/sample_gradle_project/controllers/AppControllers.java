package sample_gradle_project.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;
import org.bson.types.ObjectId;
import sample_gradle_project.repositories.RnaTranscriptionRepository;
import sample_gradle_project.rna_transcription.RnaTranscription;

import java.util.HashMap;

@SpringBootApplication
@RestController
@CrossOrigin
@Document
public class AppControllers {
    private final RnaTranscriptionRepository repository;

    @Autowired
    public AppControllers(RnaTranscriptionRepository repository){
        this.repository = repository;
    }

    @RequestMapping(value="/get_json_response", method= RequestMethod.GET, produces="application/json")
    public HashMap<String, Object> getJsonResponse() {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Name", "Niranjan");
        hm.put("Age", "23");
        HashMap<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("results", hm);
        return map;
    }

    @RequestMapping(value="/get_json_response_post", method = RequestMethod.POST)
    public HashMap<String, String> getJsonResponsePost(@RequestBody HashMap<String, String> payload) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Name", payload.get("Name"));
        hm.put("Age", payload.get("Age"));
        return hm;
    }

    @RequestMapping(value="/convert_DNA_to_RNA", method = RequestMethod.POST, produces="application/json")
    public HashMap<String, Object> convertDnaToRna(@RequestBody HashMap<String, String> payload) {
        RnaTranscription conversion = new RnaTranscription();
        HashMap<String, Object> finalMap = conversion.convertDnaToRna(payload);
        conversion.dnaValue = (String)finalMap.get("dnaValue");
        conversion.rnaValue = (String)finalMap.get("rnaStrand");
        conversion.converted = (Boolean)finalMap.get("converted");
        conversion.set_id(ObjectId.get());
        this.repository.insert(conversion);
        return finalMap;
    }

}
