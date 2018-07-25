package phoenix;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class LogicManager {
	public int getRandom(int[] array) {
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
	}
	
	public void generate (ArrayList<Timeslots> timeslots,
			ArrayList<Courses> courses, ArrayList<Sections> sections,
			ArrayList<Rooms> rooms, ArrayList<Instructors> instructors) throws FileNotFoundException{
		 	/*PrintWriter pw = new PrintWriter(new File("C:/Users/ANJALI/Desktop/test.csv"));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	        StringBuilder sb = new StringBuilder();
	        sb.append("Teachers");
	        sb.append(",");
	        for(int i=0;i<courses.size();i++){
	       	 	sb.append(courses.get(i).code);
	       	 	sb.append(",");	       	 
	        }
	        sb.append('\n');
	        for(int i=0;i<instructors.size();i++){
	        	 sb.append(instructors.get(i).name);
	        	 sb.append('\n');
	        }0wsz 
	        pw.write(sb.toString());
	        pw.close();
	        //System.out.println("done!");
*/	   
		// initialise pat and cat     
		int[][] pat= new int[instructors.size()][courses.size()];
		int[][] cat= new int[instructors.size()][courses.size()];
		for(int j=0;j<instructors.size();j++){
			for (int i=0;i<courses.size();i++){
			cat[j][i]=0;	
			pat[j][i]=1;
		}
		}
		//initialise lat
		int[] lat=new int[courses.size()];
		for (int i=0;i<courses.size();i++){
			if(courses.get(i).course_type.toString().equals("Lecture")){
				lat[i]=courses.get(i).contact_slots*3;
			}
			else{
				lat[i]=courses.get(i).contact_slots*2*3;
			}
		}
		//printing lat
		/*for (int i=0;i<courses.size();i++){
			System.out.print(lat[i]+"      ");
		}*/
		//populate pat with correct values
		for (int i=0;i<courses.size();i++){
			for(int j=0;j<instructors.size();j++){
				  if(instructors.get(j).expertise1.toString().equals(courses.get(i).code.toString())){
					pat[j][i]=5;	
				}
				else if(instructors.get(j).expertise2.toString().equals(courses.get(i).code.toString())){
					pat[j][i]=4;
				}
				else if(instructors.get(j).expertise3.toString().equals(courses.get(i).code.toString())){
					pat[j][i]=3;
				}
				else if(instructors.get(j).expertise4.toString().equals(courses.get(i).code.toString())){
					pat[j][i]=2;
				}
				
			}
		}
		// Displaying pat
			/*for(int j=0;j<instructors.size();j++){
				for (int i=0;i<courses.size();i++){
					
				System.out.print(pat[j][i]+"   ");
			}
			System.out.println();
		}*/
		//System.out.println(courses.get(1).course_type.toString());
		// declaring pd and hat and tid;
		double[] pq=new double[instructors.size()];	
		int[] hat=new int[instructors.size()];
		int[] tid= new int[instructors.size()];
		int n=instructors.size();
		int temp;
		double temp1;
		// initialise hat and tid
		for(int i=0;i<instructors.size();i++){
			hat[i]=15;
			tid[i]=i;
		}
		for (int i=0;i<courses.size();i++){
			//System.out.println(i+"   ");
			while(lat[i]>0){
				for(int j=0;j<instructors.size();j++){
					pq[j]= ((pat[j][i])/5.0)*((hat[j])/15.0);
					//System.out.println(i+"   "+j);
				}
				for(int k=0;k<instructors.size();k++){
					
					tid[k]=k;
				}
				//sorting pd and tid
				 for (int k = 0; k <n; k++) 
			        {
			            for (int j = k + 1; j < n; j++) 
			            {
			                if (pq[k] < pq[j]) 
			                {
			                    temp1 = pq[k];
			                    pq[k] = pq[j];
			                    pq[j] = temp1;
			                    temp = tid[k];
			                    tid[k] = tid[j];
			                    tid[j] = temp;
			                }
			                
			            }
			        }
				 // Displaiyng sorted content
				 /*for(int j=0;j<instructors.size();j++){
					 System.out.println(pq[j]+"   "+tid[j]);
					}*/
				int x=0;
				for(int j=0;j<n;j++){
					
					if(courses.get(i).course_type.toString().equals("Lecture")){
						for(int k=lat[i];k>0;k--){
							if(hat[tid[j]]-k>0){
								//System.out.println("in");
								x=k;
								break;
							}
						}
					}
					else if(courses.get(i).course_type.toString().equals("Lab")){
						for(int k=lat[i];k>0;k-=3){
						if(hat[tid[j]]-k>0){
							x=k;
							//System.out.println("out");
							break;
						}
						}
					}
					if(x>0){
						cat[tid[j]][i]=cat[tid[j]][i]+x;
						hat[tid[j]]=hat[tid[j]]-x;
						lat[i]=lat[i]-x;
						x=0;
					}
				}
				
			}
		}
			// Displaying cat
		/*for(int j=0;j<instructors.size();j++){
			for (int i=0;i<courses.size();i++){
			System.out.print(cat[j][i]+"      ");
		}
			System.out.println();
		}*/
		
		//DataManager dm= new DataManager();
		//dm.editor(courses, instructors, cat);
		LogicManager lm =new LogicManager();
		//lm.ins_to_slot(timeslots, courses, sections, rooms, instructors, cat);
	}
	
	
}
