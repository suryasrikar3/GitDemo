package DataDrivenTesting;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    datadriven d = new datadriven();
  ArrayList<String> data =  d.getData("PaymentVerification", "testdata");
  
  for(int i =0; i<data.size();i++)
  {
	  System.out.println(data.get(i));
  }
  
  System.out.println("SampleTest");
  System.out.println("SampleTestGit");
  System.out.println("SampleTestGitStuff");
   System.out.println("SampleTestGitStuff0");
 System.out.println("SampleTestGitStuff1");
 System.out.println("SampleTestGitStuff2");
 System.out.println("SampleTestGitStuff3");
 System.out.println("SampleTestGitStuff4");
 System.out.println("SampleTestGitStuff5");
 System.out.println("SampleTestGitStuff6");
 System.out.println("SampleTestGitStuff7");
 System.out.println("SampleTestGitStuff8");
 System.out.println("SampleTestGitStuff9");
 System.out.println("SampleTestGitStuff10");
 System.out.println("SampleTestGitStuff11");
 System.out.println("SampleTestGitStuff12");
 System.out.println("SampleTestGitStuff13");



	}

}
