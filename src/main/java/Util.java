import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import java.io.File;


public class Util {
    public static final String CHROM_PATH = "C:\\Users\\Olga\\IdeaProjects\\javaguru\\src\\test\\resources\\";
    public static final String BASE_URL = "http://www.demo.guru99.com/";
    public static final int WAIT_TIME = 30;
    public static final String VALID_USER_NAME = "mngr358985";
    public static final String INVALID_USER_NAME = "1234";
    public static final String VALID_PASS = "pAbasEg";
    public static final String INVALID_PASS = "1234";
    public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
    public static final String EXPECT_ERROR = "User or Password is not valid";
    public static final String FILE_PATH = "testData.xls"; // File Path
    public static final String SHEET_NAME = "Data"; // Sheet name
    public static final String TABLE_NAME = "testData"; // Name of data table

    public static String[][] getDataFromExcel(String xlFilePath, String sheetName, String tableName) throws Exception {

        String[][] tabArray = null;
        Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
        Sheet sheet = workbook.getSheet(sheetName);

        int startRow, startCol, endRow, endCol, ci, cj;
        Cell tableStart = sheet.findCell(tableName);
        startRow = tableStart.getRow();
        startCol = tableStart.getColumn();

        Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1,
                100, 64000, false);
        endRow = tableEnd.getRow();
        endCol = tableEnd.getColumn();

        tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
        ci = 0;

        // Store all data in an array
        for (int i = startRow + 1; i < endRow; i++, ci++) {
            cj = 0;
            for (int j = startCol + 1; j < endCol; j++, cj++) {
                //Get content of each cell and store to each array element.
                tabArray[ci][cj] = sheet.getCell(j, i).getContents();
            }
        }
        return (tabArray);
    }

}
