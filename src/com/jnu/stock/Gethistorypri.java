package com.jnu.stock;
import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Gethistorypri 
{
	String[][] str1={
			{"2015/3/31","30.85"},
			{"2015/3/30","31.36"},
			{"2015/3/27","31.1"},
			{"2015/3/26","31.43"},
			{"2015/3/25","30.39"},
			{"2015/3/24","29.96"},
			{"2015/3/23","30.57"},
			{"2015/3/20","29.45"},
			{"2015/3/19","28.56"},
			{"2015/3/18","28.82"},
			{"2015/3/17","28.39"},
			{"2015/3/16","28.1"},
			{"2015/3/13","27.46"},
			{"2015/3/12","27.5"},
			{"2015/3/11","27.18"},
			{"2015/3/10","27.24"},
			{"2015/3/9","27.44"},
			{"2015/3/6","27.24"},
			{"2015/3/5","27.23"},
			{"2015/3/4","27.78"},
			{"2015/3/3","27.56"},
			{"2015/3/2","28"}
	};
	String[][] str2 = {
			{"2015/3/31","4.86"},
			{"2015/3/30","4.92"},
			{"2015/3/27","4.71"},
			{"2015/3/26","4.72"},
			{"2015/3/25","4.69"},
			{"2015/3/24","4.8"},
			{"2015/3/23","4.78"},
			{"2015/3/20","4.72"},
			{"2015/3/19","4.69"},
			{"2015/3/18","4.73"},
			{"2015/3/17","4.63"},
			{"2015/3/16","4.6"},
			{"2015/3/13","4.57"},
			{"2015/3/12","4.57"},
			{"2015/3/11","4.46"},
			{"2015/3/10","4.42"},
			{"2015/3/9","4.52"},
			{"2015/3/6","4.34"},
			{"2015/3/5","4.31"},
			{"2015/3/4","4.38"},
			{"2015/3/3","4.4"},
			{"2015/3/2","4.57"}
	};
	String[][] str3 = {

{"2015/3/31","10.91"},
{"2015/3/30","11.1"},
{"2015/3/27","10.79"},
{"2015/3/26","10.88"},
{"2015/3/25","10.86"},
{"2015/3/24","11.18"},
{"2015/3/23","11.2"},
{"2015/3/20","11.14"},
{"2015/3/19","11.03"},
{"2015/3/18","11.2"},
{"2015/3/17","11.09"},
{"2015/3/16","11.07"},
{"2015/3/13","11.06"},
{"2015/3/12","11.08"},
{"2015/3/11","10.47"},
{"2015/3/10","10.38"},
{"2015/3/9","10.8"},
{"2015/3/6","9.89"},
{"2015/3/5","9.85"},
{"2015/3/4","10.02"},
{"2015/3/3","10.05"},
{"2015/3/2","10.45"}
	};
	String[][] str4 = {
			{"2015/3/31","37.81"},
			{"2015/3/30","38.23"},
			{"2015/3/27","37.83"},
			{"2015/3/26","36.69"},
			{"2015/3/25","37.25"},
			{"2015/3/24","35.32"},
			{"2015/3/23","35.8"},
			{"2015/3/20","35.3"},
			{"2015/3/19","35.18"},
			{"2015/3/18","35.4"},
			{"2015/3/17","34.41"},
			{"2015/3/16","34.34"},
			{"2015/3/13","33.28"},
			{"2015/3/12","33"},
			{"2015/3/11","33.61"},
			{"2015/3/10","34.09"},
			{"2015/3/9","33.9"},
			{"2015/3/6","33.65"},
			{"2015/3/5","33.88"},
			{"2015/3/4","33.73"},
			{"2015/3/3","32.65"},
			{"2015/3/2","33.38"}	
	};
	String[][] str5 = {
			{"2015/3/31","33.3"},
			{"2015/3/30","32.35"},
			{"2015/3/27","31.76"},
			{"2015/3/26","31.86"},
			{"2015/3/25","32.75"},
			{"2015/3/24","32.13"},
			{"2015/3/23","32.3"},
			{"2015/3/20","31.34"},
			{"2015/3/19","31.7"},
			{"2015/3/18","31.98"},
			{"2015/3/17","31.12"},
			{"2015/3/16","31.4"},
			{"2015/3/13","30.92"},
			{"2015/3/12","31.01"},
			{"2015/3/11","31.11"},
			{"2015/3/10","31"},
			{"2015/3/9","29.44"},
			{"2015/3/6","29.2"},
			{"2015/3/5","30.14"},
			{"2015/3/4","29.44"},
			{"2015/3/3","28.95"},
			{"2015/3/2","29.45"}
	};

	
	String[][] str6 = {
			{"2015/3/27","24.79"},
			{"2015/3/26","24.75"},
			{"2015/3/25","25.33"},
			{"2015/3/24","24.79"},
			{"2015/3/23","25.03"},
			{"2015/3/20","24.61"},
			{"2015/3/19","24.13"},
			{"2015/3/18","24.44"},
			{"2015/3/17","24.09"},
			{"2015/3/16","23.71"},
			{"2015/3/13","23.11"},
			{"2015/3/12","22.92"},
			{"2015/3/11","23.29"},
			{"2015/3/10","23.37"},
			{"2015/3/9","23.03"},
			{"2015/3/6","22.97"},
			{"2015/3/5","23.51"},
			{"2015/3/4","23.67"},
			{"2015/3/3","23.02"},
			{"2015/3/2","22.85"}
	};
	String[][] str7 = {
			{"2015/3/31","42.53"},
			{"2015/3/30","43.21"},
			{"2015/3/27","43.25"},
			{"2015/3/26","43.46"},
			{"2015/3/25","42.75"},
			{"2015/3/24","42.98"},
			{"2015/3/23","41.6"},
			{"2015/3/20","41.68"},
			{"2015/3/19","42.28"},
			{"2015/3/18","42.04"},
			{"2015/3/17","41.83"},
			{"2015/3/16","42.42"},
			{"2015/3/13","41.23"},
			{"2015/3/12","40.75"},
			{"2015/3/11","41.16"},
			{"2015/3/10","41.41"},
			{"2015/3/9","39.08"},
			{"2015/3/6","38.82"},
			{"2015/3/5","37.1"},
			{"2015/3/4","37.48"},
			{"2015/3/3","37"},
			{"2015/3/2","38.19"}	
	};
	

	public String Getprice(String num,String searchdate)
	{
		String price="0";
		if(num.equals("sh600887"))
		{
			for(int i=0;i<str1.length;i++)
			{
				if(str1[i][0].equals(searchdate))
				{
					price  = str1[i][1];
					break;				
				}
			}
		}
		else if(num.equals("sh601398"))
		{
			for(int i=0;i<str2.length;i++)
			{
				if(str2[i][0].equals(searchdate))
				{
					price  = str2[i][1];
					break;				
				}
			}
		}
		else if(num.equals("sh601169"))
		{
			for(int i=0;i<str3.length;i++)
			{
				if(str3[i][0].equals(searchdate))
				{
					price  = str3[i][1];
					break;				
				}
			}
		}
		else if(num.equals("sz002603"))
		{
			for(int i=0;i<str4.length;i++)
			{
				if(str4[i][0].equals(searchdate))
				{
					price  = str4[i][1];
					break;				
				}
			}
		}
		else if(num.equals("sz002241"))
		{
			for(int i=0;i<str5.length;i++)
			{
				if(str5[i][0].equals(searchdate))
				{
					price  = str5[i][1];
					break;				
				}
			}
		}
		else if(num.equals("sh600196"))
		{
			for(int i=0;i<str6.length;i++)
			{
				if(str6[i][0].equals(searchdate))
				{
					price  = str6[i][1];
					break;				
				}
			}
		}
		else if(num.equals("sh600315"))
		{
			for(int i=0;i<str7.length;i++)
			{
				if(str7[i][0].equals(searchdate))
				{
					price  = str7[i][1];
					break;				
				}
			}
		}
	return price;
		
	}		
}
