package supportFiles;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static int testcaseIndex=0;
	public static List<TestData> arrayList;

	public static String getData(String FilePath, String SheetName,String TestCase,String Field) throws Exception {
		
		String retrieved_value = null;
		arrayList = new ArrayList<TestData>();
		Map<String, Integer> map = new HashMap<String,Integer>(); 
		sheet = getsheet(FilePath, SheetName);
		XSSFRow row = sheet.getRow(0); 
		short minColIx = row.getFirstCellNum(); 
		short maxColIx = row.getLastCellNum(); 
		for(short colIx=minColIx; colIx<maxColIx; colIx++) { 
			XSSFCell cell = row.getCell(colIx); 
			
			map.put(cell.getStringCellValue(),cell.getColumnIndex()); 
		
		}
		
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		while (rowIterator.hasNext()){
			row = (XSSFRow) rowIterator.next();
			
			int idxForTestCase = map.get("TestCaseID");	
			
				
				XSSFCell requestedField_cell = row.getCell(idxForTestCase);
				String Cell_Content = requestedField_cell.getStringCellValue().trim();
				
				if (Cell_Content.equals(TestCase)){
					
				
				int idxForrequestedField = map.get(Field);
				XSSFCell requestedField_cell1 = row.getCell(idxForrequestedField);
				
				 retrieved_value =  requestedField_cell1.toString().trim();
				
				break;
				
			}else{
				
				throw new Exception("Matching TestCaseID not found");
			}
		}	
		
			return retrieved_value;		
	}
	
	public static XSSFSheet getsheet(String FilePath, String sheetname) throws Exception{
		XSSFSheet ExcelWSheet;
	    XSSFWorkbook ExcelWBook;
	    FileInputStream ExcelFile;
		ExcelFile = new FileInputStream(FilePath);
        ExcelWBook = new XSSFWorkbook(ExcelFile);
        ExcelWSheet = ExcelWBook.getSheet(sheetname);
	
	return ExcelWSheet;		
}

}
