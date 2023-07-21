package com.example.UserDetails;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.Optional;



@Controller
public class UserController {
    private UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @QueryMapping
    public Iterable<User> users(){

        return this.userRepo.findAll();
    }

    @MutationMapping
    public Iterable<User> addUsers() throws ParseException {
        String jsonData = "{\"users\":[{\"id\":\"1\",\"name\":\"name1\",\"mail\":\"mail1@gmail.com\",\"company\":\"company1\",\"website\":\"website1.com\",\"status\":\"1\"}," +
                "{\"id\":\"2\",\"name\":\"name2\",\"mail\":\"mail2@gmail.com\",\"company\":\"company2\",\"website\":\"website2.com\",\"status\":\"2\"}," +
                "{\"id\":\"3\",\"name\":\"name3\",\"mail\":\"mail3@gmail.com\",\"company\":\"company3\",\"website\":\"website3.com\",\"status\":\"3\"}," +
                "{\"id\":\"4\",\"name\":\"name4\",\"mail\":\"mail4@gmail.com\",\"company\":\"company4\",\"website\":\"website4.com\",\"status\":\"4\"}," +
                "{\"id\":\"5\",\"name\":\"name5\",\"mail\":\"mail5@gmail.com\",\"company\":\"company5\",\"website\":\"website5.com\",\"status\":\"5\"}," +
                "{\"id\":\"11\",\"name\":\"name11\",\"mail\":\"mail11@gmail.com\",\"company\":\"company11\",\"website\":\"website11.com\",\"status\":\"1\"}," +
                "{\"id\":\"12\",\"name\":\"name12\",\"mail\":\"mail12@gmail.com\",\"company\":\"company12\",\"website\":\"website12.com\",\"status\":\"2\"}," +
                "{\"id\":\"13\",\"name\":\"name13\",\"mail\":\"mail13@gmail.com\",\"company\":\"company13\",\"website\":\"website13.com\",\"status\":\"3\"}," +
                "{\"id\":\"14\",\"name\":\"name14\",\"mail\":\"mail14@gmail.com\",\"company\":\"company14\",\"website\":\"website14.com\",\"status\":\"4\"}," +
                "{\"id\":\"15\",\"name\":\"name15\",\"mail\":\"mail15@gmail.com\",\"company\":\"company15\",\"website\":\"website15.com\",\"status\":\"5\"}," +
                "{\"id\":\"21\",\"name\":\"name21\",\"mail\":\"mail21@gmail.com\",\"company\":\"company21\",\"website\":\"website21.com\",\"status\":\"1\"}," +
                "{\"id\":\"22\",\"name\":\"name22\",\"mail\":\"mail22@gmail.com\",\"company\":\"company22\",\"website\":\"website22.com\",\"status\":\"2\"}," +
                "{\"id\":\"23\",\"name\":\"name23\",\"mail\":\"mail23@gmail.com\",\"company\":\"company23\",\"website\":\"website23.com\",\"status\":\"3\"}," +
                "{\"id\":\"24\",\"name\":\"name24\",\"mail\":\"mail24@gmail.com\",\"company\":\"company24\",\"website\":\"website24.com\",\"status\":\"4\"}," +
                "{\"id\":\"26\",\"name\":\"name26\",\"mail\":\"mail26@gmail.com\",\"company\":\"company26\",\"website\":\"website26.com\",\"status\":\"4\"}," +
                "{\"id\":\"25\",\"name\":\"name25\",\"mail\":\"mail25@gmail.com\",\"company\":\"company25\",\"website\":\"website25.com\",\"status\":\"5\"}]}";
        JSONParser parser = new JSONParser();
        Object jsonObj = parser.parse(jsonData);
        JSONObject jsnobject = new JSONObject(jsonData);
        JSONArray jsonArray = (JSONArray) jsnobject.get("users");
        User u;
        for (Object i : jsonArray) {
            JSONObject obj = (JSONObject) i;
            String id = (String) obj.get("id");
            String name = (String) obj.get("name");
            String mail = (String) obj.get("mail");
            String company = (String) obj.get("company");
            String website = (String) obj.get("website");
            String status= (String)obj.get("status");
            u = new User(id, name, mail, company, website, status);
                this.userRepo.save(u);
        }


        return this.userRepo.findAll();
    }
    @QueryMapping
    public Iterable<User> findUserByStatus(@Argument String status){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);

        return userRepo.findUserByStatus(status,firstPageWithTwoElements);

    }

    @QueryMapping
    public Optional<User> getUserById(@Argument String id){
        return this.userRepo.findById(id);
    }

}
