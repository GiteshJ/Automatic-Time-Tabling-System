package phoenix;

/** To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class DataManager {
    public ArrayList<Instructors> readInstructors(String addr){
		String line = "";
                String cvsSplitBy = ",";
        ArrayList<Instructors> instructors = new ArrayList<Instructors>();        
        try{
        	BufferedReader br = new BufferedReader(new FileReader(addr));       	
        	line = br.readLine();
            while ((line = br.readLine()) != null) {
                Instructors i =new Instructors();
                String[] sec = line.split(cvsSplitBy);
                i.name=sec[0];
                i.expertise1=sec[1];
                if(sec.length==5){
                	i.expertise2=sec[2];
                	i.expertise3=sec[3];
                	i.expertise4=sec[4];
                }
                else if(sec.length==4){
                	i.expertise2=sec[2];
                	i.expertise3=sec[3];
                	i.expertise4="0";
                }
                else if(sec.length==3){
                	i.expertise2=sec[2];
                	i.expertise3="0";
                	i.expertise4="0";
                }               
                instructors.add(i);               
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(instructors.get(11).expertise1);
        return instructors;
	}
	public ArrayList<Courses> readCourses(String addr){
		String line = "";
                String cvsSplitBy = ",";
                ArrayList<Courses> courses = new ArrayList<Courses>();
        try{
        	BufferedReader br = new BufferedReader(new FileReader(addr));
        	
        	line = br.readLine();
            while ((line = br.readLine()) != null) {
            	Courses c = new Courses();
                String[] sec = line.split(cvsSplitBy);
                c.code=sec[0];
                c.name=sec[1];
                c.contact_slots= Integer.parseInt(sec[2]);
                c.course_type=sec[3];
                c.resource_type=sec[4];
                if(sec.length==6){
                c.association= sec[5];
                }
                else{
                	c.association="Null";
                }
                courses.add(c);                
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(courses.get(11).name);
        	return courses;
	}
	public ArrayList<Rooms> readRooms(String add){
		String csvFile = add;
	    String line = "";
	    String cvsSplitBy = ",";
	    ArrayList<Rooms> rooms = new ArrayList<Rooms>();
	    
	    try{
	    	BufferedReader br = new BufferedReader(new FileReader(csvFile));
	    	line = br.readLine();
	        while ((line = br.readLine()) != null) {

	            // use comma as separator
	        	Rooms r  = new Rooms();
	            String[] sec = line.split(cvsSplitBy);
	            r.resource=sec[0];
	            r.type=sec[1];
	            r.capacity=Integer.parseInt(sec[2]);
	           
	            
	            rooms.add(r);
	            
	        }
	        br.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println(rooms.get(0).capacity);
	    return rooms;
	}
	
	public ArrayList<Sections> readSections(String add){
		//sections[] section;
		String csvFile = add;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Sections> sections = new ArrayList<Sections>();
        
        try{
        	BufferedReader br = new BufferedReader(new FileReader(csvFile));
        	
        	line = br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
            	Sections s = new Sections();
                String[] sec = line.split(cvsSplitBy);
                s.year=Integer.parseInt(sec[0]);
                s.section=sec[1];
                s.labsection=sec[2];
                s.enrolment=Integer.parseInt(sec[3]);
                
                sections.add(s);
                
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sections.get(11).labsection);
		return sections;
	}
	
	public ArrayList<Timeslots> readTimeslots(String add){
		String csvFile = add;
	    String line = "";
	    String cvsSplitBy = ",";
	    ArrayList<Timeslots> timeslots = new ArrayList<Timeslots>();
	    
	    try{
	    	BufferedReader br = new BufferedReader(new FileReader(csvFile));
	    	line = br.readLine();
	        while ((line = br.readLine()) != null) {

	            // use comma as separator
	        	Timeslots t  = new Timeslots();
	            String[] sec = line.split(cvsSplitBy);
	            t.day_of_week=sec[0];
	            t.slot=Integer.parseInt(sec[1]);
	            t.start_time=(sec[2]);
	            t.end_time=(sec[3]);
	            
	            timeslots.add(t);
	            
	        }
	        br.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println(timeslots.get(11).day_of_week);
	    return timeslots;
	}
        public void editor(ArrayList<Courses> courses,ArrayList<Instructors> instructors,int[][] cat)throws FileNotFoundException
        {
            	PrintWriter pw = new PrintWriter(new File("C:/Users/ANJALI/Desktop/java_project/test.csv"));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
        StringBuilder sb = new StringBuilder();
        sb.append("Teachers");
        sb.append(",");
        for(int i=0;i<courses.size();i++){
       	 	sb.append(courses.get(i).name);
       	 	sb.append(",");	       	 
        }
        sb.append('\n');
        for(int i=0;i<instructors.size();i++){
        	 sb.append(instructors.get(i).name);
        	 sb.append(",");
        	 for(int j=0;j<courses.size();j++){
                        if(cat[i][j]==0)
                        {
                            sb.append("-");
                        }
                        else{
        	 	sb.append( Integer.toString((cat[i][j])));
                        }
        	 	sb.append(",");
        	 }
        	 sb.append('\n');
        }
        pw.write(sb.toString());
        pw.close();
        System.out.println("Task Done !");
        
	}
}

