package sample_gradle_project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import sample_gradle_project.rna_transcription.RnaTranscription;

public interface RnaTranscriptionRepository extends MongoRepository<RnaTranscription, String> {

}