package Task8Program;
import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;   
public class CreateExcel {

	public static void main(String[] args) {
		try   
		{  
	    	File file = new File("C:\\Users\\girit\\OneDrive\\JavaTesting\\data.xlsx");
			//create a workbook
			XSSFWorkbook workbook = new XSSFWorkbook();

			//create a sheet in the workbook(you can give it a name)
			XSSFSheet sheet = workbook.createSheet("Sheet1");
			
			Object[][] excelData = {
	                {"Name", "Age", "Email"},
	                {"John Doe", "30", "john@test.com"},
	                {"Jane Doe", "28", "john@test.com"},
	                {"Bob Smith", "35", "jacky@example.com"},
	                {"Swapnil", "37", "swapnil@example.com"},
	        };
	 
	        int rowCount = 0;
	         
	        for (Object[] sheet1 : excelData) {
	            XSSFRow row = sheet.createRow(rowCount);
	             
	            int columnCount = 0;
	             
	            for (Object field : sheet1) {
	            	XSSFCell cell = row.createCell(columnCount);
	                if (field instanceof String) {
	                    cell.setCellValue((String) field);
	                } else if (field instanceof Integer) {
	                    cell.setCellValue((Integer) field);
	                }
	                columnCount++;
	            }
	             
	            rowCount++;
	        }

			//create a row in the sheet
			//XSSFRow row = sheet.createRow(0);

			//add cells in the sheet
			//XSSFCell cell = row.createCell(0);

			//set a value to the cell
			//cell.setCellValue("something");
			
			//save the Excel file
			try {
			    FileOutputStream out = new FileOutputStream(file);
			    workbook.write(out);
			    out.close();
			    workbook.close();
			} catch (Exception e) {
			    e.printStackTrace();
			} 
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  
		
		
	}

}
