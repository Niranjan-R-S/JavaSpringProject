/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package sample_gradle_project;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@RestController
@CrossOrigin
@Document(collection = "transcriptions")
public class App {

  @RequestMapping("/")
  public String getGreeting() {
    return "Hello world.";
  }

  @RequestMapping("/get_your_name_and_age")
  public String getNameAndAge() {
    return "My name is Sample java application and my age is young as you are";
  }

  public static void main(String[] args) {
      SpringApplication.run(App.class, args);
  }
}
