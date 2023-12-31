package com.example.UserDetails;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.*;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.stream.Collectors;


@Slf4j

@Controller
public class UserController {
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @QueryMapping
    public Iterable<User> users(){
        List<User> u = new ArrayList<>();
        u = this.userRepo.findAll();
        log.info("No of users are : {}",u.size());

        return this.userRepo.findAll();
    }
    @QueryMapping
    public Iterable<User> findUserByStatus(@Argument String status,@Argument String pageNo,@Argument String size){
        Pageable firstPageWithTwoElements = PageRequest.of(Integer.parseInt(pageNo), Integer.parseInt(size));
        log.info("No.of.users with this status are: ");

        return userRepo.findUserByStatus(status,firstPageWithTwoElements);

    }

    @QueryMapping
    public Optional<User> findUserById(@Argument String id){
        log.info("Finding user using the id");
        return this.userRepo.findById(id);
    }

    @QueryMapping
    //implementing using stream filters and using default values for pageno and size if user doesn't provide it
    public List<User> ImgetStatus(@Argument String status,@Argument String pageNo,@Argument String size){
        List<User> u = new ArrayList<>();
        Pageable element;
        u = this.userRepo.findAll();
        int count = (int) u.stream().filter(user -> (user.getStatus()).equals(status)).count();

        List<User> userStatus = u.stream().filter(user -> (user.getStatus()).equals(status)).toList();
        log.info("No of users in this status are : {}",count);
        if( (pageNo!=null ) && (size!=null)) {
            element = PageRequest.of(Integer.parseInt(pageNo), Integer.parseInt(size));
        }
        else{
            element = PageRequest.of(0, 10);
        }

        return userRepo.findUserByStatus(status,element);
    }

    @QueryMapping
    //as the auto-generated data has repeated domains, removing them
    public List<User> removeRepeatedDomainUsers(){
        List<User> u = new ArrayList<>();
        u = this.userRepo.findAll();
        String domain;
        int index ;
        ArrayList<String> distinctDomains=new ArrayList<>();
        List<User> unew = new ArrayList<>();
        for (User mail:u) {
            domain = mail.getMail();
            index = domain.indexOf('@');
            if(!(distinctDomains.contains(domain.substring(index)))){
                distinctDomains.add(domain.substring(index));
            }
        }
        boolean f = true;
        int x=0;
        for (String distinctDomain : distinctDomains) {
            f = true;
            for (User mail : u) {
                index = mail.getMail().indexOf('@');
                if (mail.getMail().substring(index).equals(distinctDomain)) {
                    if (f) {
                        f = false;
                        unew.add(mail);
                    }
                }

            }
        }
        this.userRepo.deleteAll();

        u= u.stream().filter(unew::contains).toList();
        log.info("No.of.distinct domain users are: {}",u.size());

        return  this.userRepo.saveAll(u);

    }

















    @MutationMapping
    //adding sample data to the database for 2000 rows auto-generated with pre-defined status values
    //varying from 0 to 4 and varying 100 domain values
    public Iterable<User> addUsers() throws ParseException {
//        String jsonData = "{\"users\":[{\"id\":\"1\",\"name\":\"name1\",\"mail\":\"mail1@gmail.com\",\"company\":\"company1\",\"website\":\"website1.com\",\"status\":\"1\"}," +
//                "{\"id\":\"2\",\"name\":\"name2\",\"mail\":\"mail2@gmail.com\",\"company\":\"company2\",\"website\":\"website2.com\",\"status\":\"2\"}," +
//                "{\"id\":\"3\",\"name\":\"name3\",\"mail\":\"mail3@gmail.com\",\"company\":\"company3\",\"website\":\"website3.com\",\"status\":\"3\"}," +
//                "{\"id\":\"4\",\"name\":\"name4\",\"mail\":\"mail4@gmail.com\",\"company\":\"company4\",\"website\":\"website4.com\",\"status\":\"4\"}," +
//                "{\"id\":\"5\",\"name\":\"name5\",\"mail\":\"mail5@gmail.com\",\"company\":\"company5\",\"website\":\"website5.com\",\"status\":\"5\"}," +
//                "{\"id\":\"11\",\"name\":\"name11\",\"mail\":\"mail11@gmail.com\",\"company\":\"company11\",\"website\":\"website11.com\",\"status\":\"1\"}," +
//                "{\"id\":\"12\",\"name\":\"name12\",\"mail\":\"mail12@gmail.com\",\"company\":\"company12\",\"website\":\"website12.com\",\"status\":\"2\"}," +
//                "{\"id\":\"13\",\"name\":\"name13\",\"mail\":\"mail13@gmail.com\",\"company\":\"company13\",\"website\":\"website13.com\",\"status\":\"3\"}," +
//                "{\"id\":\"14\",\"name\":\"name14\",\"mail\":\"mail14@gmail.com\",\"company\":\"company14\",\"website\":\"website14.com\",\"status\":\"4\"}," +
//                "{\"id\":\"15\",\"name\":\"name15\",\"mail\":\"mail15@gmail.com\",\"company\":\"company15\",\"website\":\"website15.com\",\"status\":\"5\"}," +
//                "{\"id\":\"21\",\"name\":\"name21\",\"mail\":\"mail21@gmail.com\",\"company\":\"company21\",\"website\":\"website21.com\",\"status\":\"1\"}," +
//                "{\"id\":\"22\",\"name\":\"name22\",\"mail\":\"mail22@gmail.com\",\"company\":\"company22\",\"website\":\"website22.com\",\"status\":\"2\"}," +
//                "{\"id\":\"23\",\"name\":\"name23\",\"mail\":\"mail23@gmail.com\",\"company\":\"company23\",\"website\":\"website23.com\",\"status\":\"3\"}," +
//                "{\"id\":\"24\",\"name\":\"name24\",\"mail\":\"mail24@gmail.com\",\"company\":\"company24\",\"website\":\"website24.com\",\"status\":\"4\"}," +
//                "{\"id\":\"26\",\"name\":\"name26\",\"mail\":\"mail26@gmail.com\",\"company\":\"company26\",\"website\":\"website26.com\",\"status\":\"4\"}," +
//                "{\"id\":\"25\",\"name\":\"name25\",\"mail\":\"mail25@gmail.com\",\"company\":\"company25\",\"website\":\"website25.com\",\"status\":\"5\"}]}";

        String jsonData = "{\"users\":[{\"id\":\"1\",\"name\":\"name1\",\"mail\":\"mail1@gmail.com\",\"company\":\"company1\",\"website\":\"website1.com\",\"status\":\"1\"}";
        String end = "]}";
        Random rand = new Random();
        String add="";
        List<String> domains = new ArrayList<>();
        String[] domainList=
                {"gmail.com	","yahoo.com	","hotmail.com	","aol.com"	,"hotmail.co.uk","hotmail.fr","msn.com"	,"yahoo.fr"	,"wanadoo.fr"	,"orange.fr	"
                        ,"comcast.net	","yahoo.co.uk"	,"yahoo.com.br"	,"yahoo.co.in"	,"live.com"	,"rediffmail.com"	,"free.fr"	,"gmx.de"	,"web.de	","yandex.ru"
                        ,"ymail.com	","libero.it"	,"outlook.com"	,"uol.com.br"	,"bol.com.br"	,"mail.ru	","cox.net"	,"hotmail.it"	,"sbcglobal.net"
                        ,"sfr.fr	","live.fr"	,"verizon.net"	,"live.co.uk"	,"googlemail.com"	,"yahoo.es","		ig.com.br"	,"live.nl"
                        ,"bigpond.com"	,"terra.com.br	","yahoo.it"	,"neuf.fr"	,"yahoo.de"	,"alice.it"	,"rocketmail.com","att.net"
                        ,"laposte.net"	,"facebook.com"	,"bellsouth.net"	,"yahoo.in"	,"hotmail.es"	,"charter.net"	,"yahoo.ca"	,"yahoo.com.au"	,"rambler.ru"
                        ,"hotmail.de"	,"tiscali.it"	,"shaw.ca"	,"yahoo.co.jp"	,"sky.com"	,"earthlink.net"	,"optonline.net"	,"freenet.de"
                        ,"t-online.de"	,"aliceadsl.fr"	,"virgilio.it"	,"home.nl"	,"telenet.be"	,"yahoo.com.ar"	,"tiscali.co.uk"	,"yahoo.com.mx"
                        ,"voila.fr"	,"gmx.net"	,"mail.com"	,"planet.nl"	,"tin.it"	,"live.it"	,"ntlworld.com"	,"arcor.de"	,"yahoo.co.id"
                        ,"frontiernet.net"	,"hetnet.nl"	,"live.com.au"	,"yahoo.com.sg"	,"zonnet.nl"	,"club-internet.fr"	,"juno.com"	,"optusnet.cou"
                        ,"blueyonder.co.uk","bluewin.ch"	,"skynet.be"	,"sympatico.ca"	,"windstream.net"	,"mac.com"	,"centurytel.net"
                        ,"chello.nl"	,"live.ca"	,"aim.com"	,"bigpond.net.au"};
        Collections.addAll(domains, domainList);
        String id1,name1,mail1,company1,website1,status1,domain;
        for(int i=2;i<2000;i++){
            id1= String.valueOf(i);
            name1="name"+id1;
            domain=domains.get(rand.nextInt(domains.size()));
            mail1="mail"+id1+"@"+domain;
            company1="company"+id1;
            website1="website"+id1+".com";
            status1=String.valueOf(rand.nextInt(5));
            add=add+",{\"id\":\""+id1+"\",\"name\":\""+name1+"\",\"mail\":\""+mail1+"\",\"company\":\""+company1+"\",\"website\":\""+website1+"\",\"status\":\""+status1+"\"}";
        }
        jsonData=jsonData+add+end;
        JSONParser parser = new JSONParser();
        Object jsonObj =parser.parse(jsonData);
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
    @MutationMapping
    public User createUser(@Argument(name= "input" ) UserInput userInput){
        return this.userRepo.save(userInput.getUserEntity());
    }

    @MutationMapping
    public Boolean updateUser(@Argument(name= "input" ) UserInput userInput){
        Optional<User> getUser =this.userRepo.findById(userInput.getId());//checking whether if that user with that id exist
        if(getUser.isPresent()){
            User u = getUser.get();
            u.setId(userInput.getId());
            u.setName(userInput.getName());
            u.setMail(userInput.getMail() );
            u.setCompany(userInput.getCompany());
            u.setWebsite(userInput.getWebsite());
            u.setStatus(userInput.getStatus());
            this.userRepo.save(u);
        return true;}
        else{
            return false;
        }

    }

    @MutationMapping
    public Boolean deleteUser(@Argument String id){
        this.userRepo.deleteById(id);
        return true;
    }



    @MutationMapping
    //removing particular group of users with the mentioned domain
    public Boolean removeUserWithDomain(@Argument String domain ){
        List<User> u = new ArrayList<>();
        u = this.userRepo.findAll();
        int count = (int) u.stream().filter(user -> (user.getMail()).contains(domain)).count();

        List<User> userMail = u.stream().filter(user -> (user.getMail()).contains(domain)).collect(Collectors.toList());
        log.info("No of users in this domain are : {}",count);
        this.userRepo.deleteAll(userMail);
        return true;
    }

    @MutationMapping
    //distinct users from distinct companies
    public Boolean createDistinctUser(@Argument(name= "input" ) UserInput userInput){
            User u = new User();
            u.setId(userInput.getId());
            u.setName(userInput.getName());
            u.setMail(userInput.getMail() );
            u.setCompany(userInput.getCompany());
            u.setWebsite(userInput.getWebsite());
            u.setStatus(userInput.getStatus());
        List<User> user = this.userRepo.findAll();
        String id1;
        for(User u1:user){
            // cheking whether the id or company already exists in the db
            if((u1.getCompany().equals(u.getCompany()))||(u1.getId().equals(u.getId()))){
                id1= u1.getId();
                this.userRepo.findById(id1);
                return false;
            }
        }
        this.userRepo.save(u);
        return true;
    }
    }


