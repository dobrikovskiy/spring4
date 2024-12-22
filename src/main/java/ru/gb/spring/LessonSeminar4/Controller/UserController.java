package ru.gb.spring.LessonSeminar4.Controller;

import ru.gb.spring.LessonSeminar4.Model.ModelUser;
import ru.gb.spring.LessonSeminar4.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String root(){
        return "index";
    }

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public ResponseEntity<List<ModelUser>> getStudents(){
        List<ModelUser> modelUserList = this.userService.getAllStudents();
        return new ResponseEntity<>(modelUserList,HttpStatus.OK);
    }

    @RequestMapping(value="users/{id}", method = RequestMethod.GET)
    public ResponseEntity getStudentById(@PathVariable("id") int id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok().headers(headers);
        ModelUser student = this.userService.getStudentByID(id);
//        if(student == null){
//            return responseBuilder.body(new EmptyJsonBody());
//        }
        return responseBuilder.body(student);
    }

    @RequestMapping(value="users/{id}/courseRegistered", method = RequestMethod.GET)
    public ResponseEntity getCourseRegisteredById(@PathVariable("id") int id)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok().headers(headers);
        HashMap<String,String> courseRegistered = this.userService.getCourseRegisteredById(id);
//        if(courseRegistered == null){
//            return responseBuilder.body(new EmptyJsonBody());
//        }

        return responseBuilder.body(courseRegistered);

    }

    @RequestMapping(value="users/{id}/courseRegistered/{courseNumber}", method = RequestMethod.GET)
    public ResponseEntity getCourseName(@PathVariable("id") int id,@PathVariable("courseNumber") int courseNumber)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok().headers(headers);
        HashMap<String,String> courseName = this.userService.getCourseName(id,courseNumber);
//        if(courseName == null){
//            return responseBuilder.body(new EmptyJsonBody());
//        }
        return responseBuilder.body(courseName);

    }


 }



