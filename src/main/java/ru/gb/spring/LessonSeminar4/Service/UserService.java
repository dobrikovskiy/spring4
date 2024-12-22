package ru.gb.spring.LessonSeminar4.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import ru.gb.spring.LessonSeminar4.Model.ModelUser;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.*;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

@Service
public class UserService {

    private List<ModelUser> modelUserList;

    @PostConstruct
    public void generateStudentList(){
        try{
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users_database.json");
        String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, ModelUser> csGradStudents = objectMapper.readValue(content, new TypeReference<Map<String, ModelUser>>(){});
        this.modelUserList = new ArrayList<ModelUser>();
        this.modelUserList.addAll(csGradStudents.values());
        }catch (IOException e){
            System.out.println(e);
        }

    }

    public List<ModelUser> getAllStudents() {
        return this.modelUserList;
    }

    public ModelUser getStudentByID(int id){
            for(ModelUser student:this.modelUserList){
                if(student.getId() == id){
                    return student;
                }
            }

        return null;
    }

    public HashMap<String,String> getCourseRegisteredById(int id){
            for(ModelUser student:this.modelUserList){
                if(student.getId() == id){
                    return student.getCourseRegistered();
                }
            }
        return null;
    }

    public HashMap<String,String> getCourseName(int id, int courseNumber){
            for(ModelUser student:this.modelUserList){
                if(student.getId() == id && student.getCourseRegistered().get(Integer.toString(courseNumber)) != null){
                    HashMap<String,String> course = new HashMap<>();
                    course.put(Integer.toString(courseNumber), student.getCourseRegistered().get(Integer.toString(courseNumber)));
                    return course;
                }
            }
        return null;
    }



}
