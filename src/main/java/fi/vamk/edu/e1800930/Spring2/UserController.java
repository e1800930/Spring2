package fi.vamk.edu.e1800930.Spring2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{
 
    @Autowired
    private Userrepository repository;

    //Requset method for POST
    @RequestMapping (value= "/user",method=RequestMethod.POST)
    public @ResponseBody User create(@RequestBody User item) {
        return repository.save(item);
    }

    // method return all user from the database
    @RequestMapping("/users")
    public Iterable<User> users(){
        return repository.findAll();
    }
    //Find each user
    @RequestMapping("/user/{id}")
    public Optional<User> get(@PathVariable("id") int id){
        return repository.findById(id);
    }

    //REquest method for PUT
    @RequestMapping(value="/user", method=RequestMethod.PUT)
    public @ResponseBody User update(@RequestBody User item){
        return repository.save(item);
    }

    //Request DELETE method
    @RequestMapping(value="/user",method=RequestMethod.DELETE)
    public void delete (@RequestBody User item){
        repository.delete(item);
        //without return 
    }
}