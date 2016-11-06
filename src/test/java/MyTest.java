import hello.dao.StudentRepository;
import hello.model.Student;
import hello.run.Run;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("hello")
@SpringBootTest(classes = {Run.class, StudentRepository.class}, webEnvironment= SpringBootTest.WebEnvironment.MOCK)
@WebAppConfiguration
public class MyTest {

    @Autowired()
    private StudentRepository repository;

    public StudentRepository getRepository() {
        return repository;
    }

    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }

    @Test
    public void addTest(){
        Student student = new Student("Bob", "J");
        repository.save(student);
        System.out.println("");
    }
}
