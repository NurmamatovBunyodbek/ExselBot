package bd.uz.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Service {
    public static void main(String[] args) {

    }
    public List<Users> getList() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            List<Users> usersList = objectMapper.readValue(inputStream, new TypeReference<List<Users>>() {
            });
            return usersList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void createExcel(List<Users> list) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Users");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Id");
        Cell cell1 = row.createCell(1, CellType.STRING);
        cell1.setCellValue("Name");
        Cell cell2 = row.createCell(2, CellType.STRING);
        cell2.setCellValue("UserName");
        Cell cell3 = row.createCell(3, CellType.STRING);
        cell3.setCellValue("Email");
        Cell cell4 = row.createCell(4, CellType.STRING);
        cell4.setCellValue("Street");
        Cell cell5 = row.createCell(5, CellType.STRING);
        cell5.setCellValue("suite");
        Cell cell6 = row.createCell(6, CellType.STRING);
        cell6.setCellValue("city");
        Cell cell7 = row.createCell(7, CellType.STRING);
        cell7.setCellValue("zipcode");
        Cell cell8 = row.createCell(8, CellType.STRING);
        cell8.setCellValue("lat");
        Cell cell9 = row.createCell(9, CellType.STRING);
        cell9.setCellValue("lng");
        Cell cell10 = row.createCell(10, CellType.STRING);
        cell10.setCellValue("phone");
        Cell cell11 = row.createCell(11, CellType.STRING);
        cell11.setCellValue("website");
        Cell cell12 = row.createCell(12, CellType.STRING);
        cell12.setCellValue("company name");
        Cell cell13 = row.createCell(13, CellType.STRING);
        cell13.setCellValue("catchPhrase");
        Cell cell14 = row.createCell(14, CellType.STRING);
        cell14.setCellValue("bs");
        int i = 1;
        for (Users u : list) {
            Row row1 = sheet.createRow(i);
            row1.createCell(0, CellType.STRING).setCellValue(u.getId());
            row1.createCell(1, CellType.STRING).setCellValue(u.getName());
            row1.createCell(2, CellType.STRING).setCellValue(u.getUsername());
            row1.createCell(3, CellType.STRING).setCellValue(u.getEmail());
            row1.createCell(4, CellType.STRING).setCellValue(u.getAddress().getStreet());
            row1.createCell(5, CellType.STRING).setCellValue(u.getAddress().getSuite());
            row1.createCell(6, CellType.STRING).setCellValue(u.getAddress().getCity());
            row1.createCell(7, CellType.STRING).setCellValue(u.getAddress().getZipcode());
            row1.createCell(8, CellType.STRING).setCellValue(u.getAddress().getGeo().getLat());
            row1.createCell(9, CellType.STRING).setCellValue(u.getAddress().getGeo().getLng());
            row1.createCell(10, CellType.STRING).setCellValue(u.getPhone());
            row1.createCell(11, CellType.STRING).setCellValue(u.getWebsite());
            row1.createCell(12, CellType.STRING).setCellValue(u.getCompany().getName());
            row1.createCell(13, CellType.STRING).setCellValue(u.getCompany().getCatchPhrase());
            row1.createCell(14, CellType.STRING).setCellValue(u.getCompany().getBs());
            i++;
        }
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        sheet.autoSizeColumn(4);
        sheet.autoSizeColumn(5);
        sheet.autoSizeColumn(6);
        sheet.autoSizeColumn(7);
        sheet.autoSizeColumn(8);
        sheet.autoSizeColumn(9);
        sheet.autoSizeColumn(10);
        sheet.autoSizeColumn(11);
        sheet.autoSizeColumn(12);
        sheet.autoSizeColumn(13);
        sheet.autoSizeColumn(14);
        try {
            workbook.write(new FileOutputStream("C:\\PDP Academy\\users.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
