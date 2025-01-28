package dev.darshan.productservice;

import dev.darshan.productservice.inheritancedemo.tableperclass.Mentor;
import dev.darshan.productservice.inheritancedemo.tableperclass.MentorRepository;
import dev.darshan.productservice.inheritancedemo.tableperclass.User;
import dev.darshan.productservice.inheritancedemo.tableperclass.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductserviceApplication
        implements CommandLineRunner {

    private MentorRepository mentorRepository;

    private UserRepository userRepository;


    public ProductserviceApplication(@Qualifier("tbc_mr") MentorRepository mentorRepository ,@Qualifier("tbc_ur") UserRepository userRepository) {
        this.mentorRepository = mentorRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(ProductserviceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Mentor mentor = new Mentor();
        mentor.setName("DArshan");
        mentor.setEmail("darshan@gmail.com");
        mentor.setAverageRating(999);
       mentorRepository.save(mentor);

       User user = new User();
       user.setName("partha");
       user.setEmail("partha@gmail.com");
       userRepository.save(user);

       List<User> users = userRepository.findAll();

       for(User u : users){
           System.out.println(u);
       }


    }
}


