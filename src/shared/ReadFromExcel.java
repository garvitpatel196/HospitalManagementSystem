/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import hospitalmanagementsystem.models.UserRecordModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author NIAR Tech
 */
public class ReadFromExcel {
    Workbook workbook = null;
    ArrayList<String> dataObj = new ArrayList<>();
    ArrayList<UserRecordModel> userRecorddataList = new ArrayList<>();;
    private void readData(String fromClass, String fileName){
        String path = CommonVariables.directoryPath+fileName;
    try {

            workbook = Workbook.getWorkbook(new File(path));
            Sheet sheet = workbook.getSheet(0);
            System.out.println(sheet.getRows()+"---------------123232-----------");
            for (int rowCount=1 ; rowCount < sheet.getRows() ; rowCount++){
                for(int col = 0; col < sheet.getColumns(); col++){
                    System.out.println(rowCount);
                    dataObj.add(sheet.getCell(col,rowCount).getContents());
                }
                switch(fromClass){
                    case "signup" :
                        UserRecordModel usermodel = new UserRecordModel(dataObj);
                        userRecorddataList.add(usermodel);
                        dataObj.clear();
                        
                }
//                System.out.println(dataObj.get(0));
            }
           

        } catch (IOException | BiffException e) {
            e.printStackTrace();
        } 
    }
    
    public ArrayList<UserRecordModel> readUserRecord(String fromClass, String fileName){
        readData(fromClass,fileName);
        return userRecorddataList;
    }
    
    
}
