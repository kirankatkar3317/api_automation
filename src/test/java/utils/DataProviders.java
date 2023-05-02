package utils;

import java.io.IOException;
import org.testng.annotations.DataProvider;
public class DataProviders {
	
	@DataProvider(name = "getData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "//testData//api.xlsx";
		ExcelUtility excelutility = new ExcelUtility(path);
		int rowcount = excelutility.getRowCount("Sheet1");
		int colcount = excelutility.getCellCount("Sheet1", 1);

		System.out.println(rowcount);
		System.out.println(colcount);
		
		String apiData[][] = new String[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {

			for (int j = 0; j < colcount; j++) {
				apiData[i - 1][j] = excelutility.getCellData(i, j, "Sheet1");
			}
		}
		return apiData;
	}

	@DataProvider(name = "getUsername")
	public String[] getUserName() throws IOException {
		String path = System.getProperty("user.dir") + "//testData//api.xlsx";
		ExcelUtility excelutility = new ExcelUtility(path);
		int rowcount = excelutility.getRowCount("Sheet1");

		String apiData[] = new String[rowcount];

		for (int i = 0; i <= rowcount; i++) {

			apiData[i - 1] = excelutility.getCellData(i, 1, "Sheet1");

		}
		return apiData;
	}

}
