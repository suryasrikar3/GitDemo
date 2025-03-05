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
	}

}
