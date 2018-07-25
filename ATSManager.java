package phoenix;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileNotFoundException;
import java.util.ArrayList;
public class ATSManager {
    DataManager dataMgr;
    LogicManager logicMgr;
    DisplayManager dispMgr;
    ArrayList<Courses> courses;
    ArrayList<Rooms> rooms;
    ArrayList<Sections> sections;
    ArrayList<Timeslots> timeslots;
    ArrayList<Instructors> instructors;
    public static void main(String[] args) throws FileNotFoundException{       
        String instructorFile = "C:/Users/ANJALI/Desktop/java_project/instructors.csv";
        String courseFile ="C:/Users/ANJALI/Desktop/java_project/courses.csv";
        String roomFile= "C:/Users/ANJALI/Desktop/java_project/rooms.csv";
        String sectionFile= "C:/Users/ANJALI/Desktop/java_project/sections.csv";
        String timeslotFile= "C:/Users/ANJALI/Desktop/java_project/timeslots.csv";
        ATSManager myMgr = new ATSManager();        
        myMgr.dataMgr = new DataManager();
        myMgr.logicMgr = new LogicManager();
        //myMgr.dispMgr=new DisplayManager();
        //myMgr.dispMgr.load(myMgr.dispMgr);
       
           /* myMgr.dispMgr.pathscreen.instructorspath.getText().replace('\\','/');
            myMgr.dispMgr.pathscreen.coursespath.getText().replace('\\','/');
        String insFile=myMgr.dispMgr.pathscreen.instructorspath.getText();
        String courseFile=myMgr.dispMgr.pathscreen.coursespath.getText();
        System.out.println(insFile);
        System.out.println(courseFile);*/
        myMgr.courses = myMgr.dataMgr.readCourses(courseFile);
        myMgr.instructors = myMgr.dataMgr.readInstructors(instructorFile);  
        myMgr.rooms=myMgr.dataMgr.readRooms(roomFile);
        myMgr.sections=myMgr.dataMgr.readSections(sectionFile);
        myMgr.timeslots = myMgr.dataMgr.readTimeslots(timeslotFile);
        myMgr.logicMgr.generate(myMgr.timeslots,myMgr.courses,myMgr.sections,myMgr.rooms,myMgr.instructors);
        //myMgr.dispMgr.loadtt();
        
    }    
}