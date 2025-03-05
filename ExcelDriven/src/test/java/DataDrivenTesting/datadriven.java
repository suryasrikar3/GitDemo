package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadriven {
	
	
	
 public ArrayList<String> getData(String testcaseName, String sheetName) throws IOException
 {
		// TODO Auto-generated method stub
	 
	 ArrayList<String> a = new ArrayList<String>();
	// File input stream Argument
			FileInputStream fis = new FileInputStream("C:\\Surya\\demodata.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int sheets= workbook.getNumberOfSheets();
			for(int i=0;i<sheets;i++)
			{
				if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
				{
					XSSFSheet sheet= workbook.getSheetAt(i);
					
					//Identify testcases column by scanning the entire 1st row
					//sheet is collection of rows
					Iterator<Row>rows = sheet.iterator(); 
					Row firstrow = rows.next();
					//rows is collection of cells
					
					Iterator<Cell> ce = firstrow.cellIterator(); 
					
					int k=0;
					int column=0;
					while(ce.hasNext())
					{
						Cell value = ce.next();
						if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
						{
							column=k;
						}
						k++;
						
					}
					System.out.println(column);
					//after column is identified the scan entire testcases column to identify payment verification test case row
					while(rows.hasNext())
					{
						Row r = rows.next();
						if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
							//pulling all the data of payment verification
						{
							Iterator<Cell> cv= r.cellIterator();
							while(cv.hasNext())
								
							{
								Cell c =cv.next();
								if(c.getCellType()==CellType.STRING)
								{
								a.add(c.getStringCellValue());
								}
								else
								{
									a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								}
							}
						}
						
					}
					
					
				}

			}
			return a;
			
	
			
		}
 

}