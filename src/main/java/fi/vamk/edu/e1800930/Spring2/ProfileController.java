package fi.vamk.edu.e1800930.Spring2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProfileController{
    @Autowired
    private Profilerepository profile_resp;

    //Request Mapping
    @RequestMapping("/profiles")
    public Iterable<Profiler>  profiles(){
        return profile_resp.findAll();
    }
    @RequestMapping("/profile/{id}")
    public Optional<Profile> get(@PathVariable("id") int id){
        return profile_resp.findById(id);
    }


    //Request method for POST
    @RequestMapping(value="/profile",method = RequestMethod.POST)
    public @ResponseBody Profile create(@RequestBody Profile item){
        return profile_resp.save(item);
    }
    
    //REquest method for PUT
    @RequestMapping(value="/profile", method=RequestMethod.PUT)
    public @ResponseBody Profile update(@RequestBody Profile item){
        return profile_resp.save(item);
    }

    //Request DELETE method
    @RequestMapping(value="/profile",method=RequestMethod.DELETE)
    public void delete (@RequestBody Profile item){
        profile_resp.delete(item);
        //without return 
    }


}