package utils;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.InputStream;
	import java.io.OutputStream;

	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelDriver {

		// read from file

		private InputStream fileReader;

		private OutputStream fileWriter;

		// ouput file

		private Workbook excelworkbook;

		private String excelfilename;

		public void createWorkbook(String fileName) throws Exception {
			fileName = fileName.trim();

			File file = new File(fileName);

			if (file.exists()) {
				throw new Exception("File already exist");

			}

			if (fileName.endsWith(".xls")) {
				excelworkbook = new HSSFWorkbook();

			} else if (fileName.endsWith(".xlsx")) {
				excelworkbook = new XSSFWorkbook();
			} else {
				throw new Exception("Invalid type");
			}
			fileWriter = new FileOutputStream(fileName);

			excelworkbook.write(fileWriter);

			fileWriter.close();

			excelworkbook.close();
		}

		public void openWorkbook(String filename) throws Exception {

			filename = filename.trim();

			excelfilename = filename;

			File file = new File(filename);
			if (!file.exists()) {
				throw new Exception("File already exist");
			}

			fileReader = new FileInputStream(filename );

			excelworkbook = WorkbookFactory.create(fileReader);
			// this will actually create data in xml format.
			// poi appache variable this can recognize row and columns we pass reader

		}

		public void createSheet(String sheetname) throws Exception {
			sheetname = sheetname.trim();

			Sheet sheet = excelworkbook.getSheet(sheetname);

			if (sheet != null) {

				throw new Exception("Sheet already exist");

			}

			excelworkbook.createSheet(sheetname);

		}

		public int getRowCount(String sheetname) throws Exception {
			// consider row which has data only
			// no blank rows will consider
			sheetname = sheetname.trim();

			Sheet sheet = excelworkbook.getSheet(sheetname);

			if (sheet == null) {

				throw new Exception("Sheet does not exist");

			}
			return sheet.getLastRowNum();
		}

		public int getCellCount(String sheetname, int rowNumber) throws Exception {

			sheetname = sheetname.trim();

			Sheet sheet = excelworkbook.getSheet(sheetname);

			if (sheet == null) {

				throw new Exception("Sheet does not exist");

			}
			if (rowNumber < 0) {
				throw new Exception("Invalid row number");

			}
			Row row = sheet.getRow(rowNumber);

			if (row == null) {
				return 0;
			}


			return row.getLastCellNum();

		}

		public String getCellData(String sheetname, int rowNumber, int cellNumber) throws Exception {

			sheetname = sheetname.trim();

			Sheet sheet = excelworkbook.getSheet(sheetname);

			if (sheet == null) {

				throw new Exception("Sheet does not exist");

			}
			if (rowNumber < 0 || cellNumber < 0) {
				throw new Exception("Invalid row number");

			}
			Row row = sheet.getRow(rowNumber);

			if (row == null) {
				return "";
			}

			Cell cell = row.getCell(cellNumber);

			if (cell == null) {
				return "";

			} else {
				if (cell.getCellTypeEnum() == CellType.NUMERIC) {
					return String.valueOf(cell.getNumericCellValue());
				} else {
					return cell.getStringCellValue();
				}
			}

		}

		public void setCellData(String sheetname, int rowNumber, int cellNumber, String text) throws Exception {

			sheetname = sheetname.trim();

			Sheet sheet = excelworkbook.getSheet(sheetname);

			if (sheet == null) {

				throw new Exception("Sheet does not exist");

			}
			if (rowNumber < 0 || cellNumber < 0) {
				throw new Exception("Invalid row number");

			}
			Row row = sheet.getRow(rowNumber);

			if (row == null) {
				row = sheet.createRow(rowNumber);
				row = sheet.getRow(rowNumber);

			}

			Cell cell = row.getCell(cellNumber);

			if (cell == null) {
				cell = row.createCell(cellNumber);

				cell = row.getCell(cellNumber);

			}
			cell.setCellValue(text);

		}

		public void saveFile() throws Exception {
			fileWriter = new FileOutputStream(excelfilename);

			excelworkbook.write(fileWriter);
			fileReader.close(); 

		}

		public void saveAsFile(String newexcelFile) throws Exception {
			newexcelFile = newexcelFile.trim();
			File file = new File(newexcelFile);

			if (file.exists()) {
				throw new Exception("File already exists..");
			}

			fileWriter = new FileOutputStream(newexcelFile);

			excelworkbook.write(fileWriter);

			fileWriter.close();
		}

		public void closeWorkbook() throws Exception {
			fileReader.close();

			fileWriter.close();

			excelworkbook.close();
		}

	}


