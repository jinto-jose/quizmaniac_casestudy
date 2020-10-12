package com.stackroute.finalcasestudy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.stackroute.finalcasestudy.exception.QuizDataFileNotFoundException;

public class TestDataLoader {
	
	   private static File datasheets;
	   private static FileInputStream fis;
	   private static XSSFWorkbook xssf;
	   private static Sheet sheets;
	   private static String Fileloc;
	   public static List<Row> rowDataList = new ArrayList<Row>();
	   
	   //Method to read quiz data
	   public static List<Row> loadQuizData(){
		   Fileloc = System.getProperty("user.dir")+ "/testdata/quizdata.xlsx";

		   datasheets = new File(Fileloc);
		   try {
			fis = new FileInputStream(datasheets);
			xssf = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new QuizDataFileNotFoundException("Invalid quiz data file path");
		}
		   sheets = xssf.getSheetAt(0);
		   
		   int rowcount = sheets.getLastRowNum();
		   for(int rowno =1; rowno <=rowcount; rowno++) {
			   rowDataList.add(sheets.getRow(rowno));
		   }
		 return rowDataList;
	   }
}
