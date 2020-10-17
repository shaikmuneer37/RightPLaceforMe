package com.common.util;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class Excel{

	public List<String> arrName;


	@Test
	public void ReadExcel(String sheetName) throws InterruptedException, IOException{

		String filePath = "C:/testdata/";
		String fileName="user2.xlsx";
		File file = new File(filePath+"\\"+fileName);

		FileInputStream inputStream = new FileInputStream(file);
		Workbook AddCatalog = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if(fileExtensionName.equals(".xls")){

			AddCatalog = new HSSFWorkbook(inputStream);
		}
		else if(fileExtensionName.equals(".xlsx")){

			AddCatalog = new XSSFWorkbook(inputStream);
		}


		Sheet AddCatalogSheet = AddCatalog.getSheet(sheetName);

		int rowcount = AddCatalogSheet.getLastRowNum()- AddCatalogSheet.getFirstRowNum();

		for(int i=1; i<rowcount+1; i++){

			Row row = AddCatalogSheet.getRow(i);

			arrName = new ArrayList<String>();

			for(int j=0; j<row.getLastCellNum(); j++){

				Cell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				String str = formatter.formatCellValue(cell);

				arrName.add(str);
			}

		}
	}

}

