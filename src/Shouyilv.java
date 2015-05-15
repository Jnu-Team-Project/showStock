import java.awt.Font;  
import java.awt.Graphics;
import java.awt.Image;
import java.awt.RenderingHints;  
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;  
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartFrame;  
import org.jfree.chart.ChartUtilities;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis;  
import org.jfree.chart.axis.ValueAxis;  
import org.jfree.chart.plot.CategoryPlot;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.chart.title.TextTitle;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
public class Shouyilv extends JPanel
{
	//static DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	static DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
	String cggcusername="";
	int width,hight;
    public Shouyilv(int w,int h,String username) 
    {  
    	this.width=w;
    	this.hight=h;
        JFreeChart chart = ChartFactory.createLineChart(
                "������", // ͼ������  
                "ʱ��", // Ŀ¼�����ʾ��ǩ--����  
                "", // ��ֵ�����ʾ��ǩ--����  
                dataset1, // ���ݼ�  
                PlotOrientation.VERTICAL, // ͼ������ˮƽ��  
                true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ����  
                false, // �Ƿ����ɹ���  
                false // �Ƿ�����URL����  
                );  
        // 3. ����chart������ʾ����  
        cggcusername = username;
        processChart(chart);  
        Calculate("2015/03/14");
        // 4. chart���ͼƬ  
        writeChartAsImage(chart);  
  
    }  
    public void Calculate(String enddate)//date:2015/*/*
    {
    	String[] sdate = enddate.split("/");
    	Gethistorypri cat = new Gethistorypri();
    	int count = Integer.parseInt(sdate[2])-5+1;
    	
		String[][] alldata = new String[500][];//-------------------------------------------
		//Vector datedata = new Vector();
    	try {	
    			Double chengben = 0.0;
    			Double shouru = 0.0;
				//System.out.print(cggcusername+"haha");////////////////////////////////////////////////////////////////////////////////////////////		
				Workbook book = Workbook.getWorkbook(new File(cggcusername+".xls"));			
				int sheetnum = book.getNumberOfSheets();
				int index = 0;
				int everynum=0;
				for(int i=0;i<sheetnum;i++)//��һ��ѭ�����������й�Ʊ
				{
					String search = book.getSheet(i).getName();
					Sheet sheet = book.getSheet(search);
					
					String number = sheet.getCell(1, 1).getContents();
					int amountru=0;
					int amountchu=0;
					int amount=0;
					everynum = 0;
					int m = Integer.parseInt(sheet.getCell(11, 0).getContents());
					
					if (m > 0) 
					{
						for(int d=0;d<count;d++) //�ڶ���ѭ����������������
						{
							String edate;
							int dd = 5+d;
							if(dd>9)
								edate = "2015/3/"+String.valueOf(dd);
							else
								edate = "2015/3/"+String.valueOf(dd); 
							String price = cat.Getprice(number,edate);//------------------------���滻�ɱ��ػ�ȡ
							//String price = "5.5";//------------------------���滻�ɱ��ػ�ȡ
							
							for (int j = 0; j < m; j++) 
							{
								
								String date = sheet.getCell(2, j + 1).getContents();								
								String[] date1 = date.split("-");
								int idate = Integer.parseInt(date1[2]);
								if(idate == dd)//��������ʱ��
								{
									if (sheet.getCell(3, j + 1).getContents().equals("����")) 
									{
										int num = Integer.parseInt(sheet.getCell(5, j + 1)
												.getContents());
										amountru = amountru + num;
										chengben = chengben
												+ (num * Double.parseDouble(sheet.getCell(
														4, j + 1).getContents())) * 1.0013;
										//System.out.print("########" + num+" "+Double.parseDouble(sheet.getCell(
												//4, j + 1).getContents()));
									}
									//System.out.print("########" + number);
									if (sheet.getCell(3, j + 1).getContents().equals("����")) 
									{
										// amountchu = amountchu +
										// Integer.parseInt(sheet.getCell(5,j+1).getContents());
										int num = Integer.parseInt(sheet.getCell(5, j + 1)
												.getContents());
										amountchu = amountchu + num;
										shouru = shouru
												+ (num * Double.parseDouble(sheet.getCell(
														4, j + 1).getContents()))
												* (1 - 0.0013);
									}
								}
							}
							int chiyoushu = amountru - amountchu;
							double chiyouzhi = chiyoushu * Double.parseDouble(price);
							Double yingkui = chiyouzhi+shouru-chengben;
							
							
							if(!price.equals("0"))
							{
								String[] ddata = {edate,String.valueOf(yingkui),String.valueOf(chengben)};
								//System.out.print(edate+" "+yingkui+" "+chengben+" "+shouru+" "+chiyouzhi+"\n");
								//int index=d+count*i;
								alldata[index]=ddata;
								index++;
								everynum++;						
							}
						}
							
				}
					
			}
				
				
				//String date11 = new String();
				/*for(int c=0;c<count;c++)
				{
					Double yk=0.0,cb=0.0;
					String date11 = new String();
					for(int j=0;j<sheetnum;j++)
					{
						//(Vector)(alldata.elementAt(j))
						yk+=Double.parseDouble(alldata[c+j*count][1]);
						cb+=Double.parseDouble(alldata[c+j*count][2]);
						date11 = alldata[c+j*count][0];
						
					}
					
					dataset1.addValue(yk/cb,"������",date11);
					System.out.print("***"+yk/cb+"****\n");
				}*/
				
					for(int j=0;j<everynum;j++)
					{
						Double yk=0.0,cb=0.0;
						String date11 = new String();
						for(int r=0;r<sheetnum;r++)
						{
							//(Vector)(alldata.elementAt(j))
							yk+=Double.parseDouble(alldata[j+r*everynum][1]);
							cb+=Double.parseDouble(alldata[j+r*everynum][2]);
							date11 = alldata[j+r*everynum][0];
						}
						dataset1.addValue(yk/cb,"������",date11);
						//System.out.print("***"+yk/cb+"****\n"+date11);
					}
				book.close();
	  		} catch (BiffException e) {
				System.err.println(e+"");
		} catch (IOException e) {
			System.err.println(e+"�ļ���ȡ����");
		}

    }
    private static void processChart(JFreeChart chart) {  
        CategoryPlot plot = chart.getCategoryPlot();  
        CategoryAxis domainAxis = plot.getDomainAxis();  
        ValueAxis rAxis = plot.getRangeAxis();  
        chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,  
                RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);  
        TextTitle textTitle = chart.getTitle();  
        textTitle.setFont(new Font("����", Font.PLAIN, 20));  
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));  
        domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12));  
        rAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));  
        rAxis.setLabelFont(new Font("����", Font.PLAIN, 12));  
        chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));  
        // renderer.setItemLabelGenerator(new LabelGenerator(0.0));  
        // renderer.setItemLabelFont(new Font("����", Font.PLAIN, 12));  
        // renderer.setItemLabelsVisible(true);  
    }  
  
    /** 
     * ���ͼƬ 
     *  
     * @param chart 
     */  
    private static void writeChartAsImage(JFreeChart chart) {  
        FileOutputStream fos_jpg = null;  
        try {  
            fos_jpg = new FileOutputStream("fruit1.jpg");  
            ChartUtilities.writeChartAsJPEG(fos_jpg, 1, chart, 690, 380, null);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                fos_jpg.close();  
            } catch (Exception e) {  
            }  
        }  
    } 
    
    protected void paintComponent(Graphics g) 
	 {
		  ImageIcon icon = new ImageIcon("fruit1.jpg");
		  Image img = icon.getImage();
		  g.drawImage(img, 0, 0, width, hight, this);
	 }
} 