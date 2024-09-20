package Task8Program;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException{
		File src=new File("C:\\Users\\girit\\OneDrive\\JavaTesting\\data.xlsx");
		System.out.println(src);
		 FileInputStream fis=new FileInputStream(src);
		 System.out.println(fis);
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet1=workbook.getSheetAt(0);
		 int rowSize=sheet1.getLastRowNum();//Gives total number of rows from a sheet
		 for(int i=0;i<rowSize;i++) {
			 Row r = sheet1.getRow(i);
			 int maxCell=  r.getLastCellNum();
		     for(int j=0;j<maxCell;j++) {
		    	String cellValue=sheet1.getRow(i).getCell(j).getStringCellValue();
                System.out.print(cellValue + "|");
		     }
		    System.out.println();     
		 }
	     workbook.close();
	}	
}
