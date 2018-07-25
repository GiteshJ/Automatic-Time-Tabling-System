package phoenix;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class DisplayManager {
	Instructorfilter instructorfilter;
	Roomfilter roomfilter;
    FilterScreen filtscreen;
    Labfilter labfilter;
    PathScreen pathscreen;
    Welcome w;
    TimeTable tt; 
   public void load(DisplayManager dm) {
        w=new Welcome(dm);
        w.setTitle("Welcome");
        w.setVisible(true);
    }
    public void setPathScreen(DisplayManager dm)
    {
           pathscreen=new PathScreen(dm);
           pathscreen.setTitle("AUTOMATIC TIME TABLING SYSTEM");
           pathscreen.setVisible(true);
    }
    public void setFilterScreen(DisplayManager dm)
    {
           filtscreen=new FilterScreen(dm);
           filtscreen.setTitle("AUTOMATIC TIME TABLING SYSTEM");
           filtscreen.setVisible(true);
    }
    public void setLabfilter(DisplayManager dm)
    {
    	labfilter=new Labfilter(dm);
    	labfilter.setTitle("AUTOMATIC TIME TABLING SYSTEM");
    	labfilter.setVisible(true);
    }
    public void setInstructorfilter(DisplayManager dm)
    {
    	instructorfilter=new Instructorfilter(dm);
    	instructorfilter.setTitle("AUTOMATIC TIME TABLING SYSTEM");
    	instructorfilter.setVisible(true);
    }
  
    public void setTimeTable(DisplayManager dm)
    {
        tt=new TimeTable();
        tt.setVisible(true);
    }
    public void setRoomfilter(DisplayManager dm)
    {
    	roomfilter=new Roomfilter(dm);
    	roomfilter.setTitle("AUTOMATIC TIME TABLING SYSTEM");
    	roomfilter.setVisible(true);
    }
//    public String getinspath()
//    {
//        System.out.println(s4.instructorspath.getText()); 
//        char c='\\';
//        char d='/';
//        s4.instructorspath.getText().replace(c,d);
//        return(s4.instructorspath.getText());        
//        //b=s4.coursespath.getText();                
//    }
//    public String getcoursespath()
//    {
//        System.out.println(s4.coursespath.getText());
//        char c='\\';
//        char d='/';
//        s4.coursespath.getText().replace(c,d);
//        return(s4.coursespath.getText());                
//    }
}

