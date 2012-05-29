package servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import beans.BeanCargarPrecios;

public class ServletCargarPrecios {

	 List<BeanCargarPrecios> array;

		public ServletCargarPrecios() {
			array= new ArrayList<BeanCargarPrecios>();
		}
		public  void adicionar(BeanCargarPrecios exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanCargarPrecios obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanCargarPrecios eliminar(int alt){
			return array.remove(alt);
		}
		
		
		public  int tamañodelExcel(String cadenar){
			 boolean valor=true;
			 int tamaño=0;
				 
				try {
					POIFSFileSystem  fs = new POIFSFileSystem(new FileInputStream(cadenar.trim()));
					HSSFWorkbook wb = new HSSFWorkbook(fs);
					
					while (valor) {
						try {
							//HSSFCell cell = wb.getSheetAt("Hoja1").getRow(tamaño).getCell((short)0);
							HSSFCell cell = wb.getSheet("Hoja1").getRow(tamaño).getCell((short)0);
							
							if(cell.equals("")||cell==null||cell.equals(" ")){
								valor=false;
							}
							
							if(cell==null){
								valor=false;
							}
							if(cell.equals(" ")){
								valor=false;
							}
							if(cell.equals("")){
								valor=false;
							}
							if(cell.equals(null)){
								valor=false;
							}
			    	
			    	
						} catch (Exception e) {
							valor=false;
							// TODO: handle exception
						}
						tamaño++;
					
			    	}
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	//ESTE TAMAÑO ES EL TAMAÑO PERO TIENES QUE DISMINUIRLE -1
				return tamaño-1;
		}
		
		
		public String Sindecimal(String cad){
			   
			   String pal="",pal2="";
			   for(int i=0;i<cad.length();i++){
				   pal=""+cad.charAt(i);
				   if(pal.equals(".")){
					   break;
				   }else{
					   pal2+=pal;
				   }
			   }
			   
			return pal2; 
		 }
		
		public String SinAsterisco(String cad){
			   
			   String pal="",pal2="";
			   for(int i=0;i<cad.length();i++){
				   pal=""+cad.charAt(i);
				   if(pal.equals("*")){
					   break;
				   }else{
					   pal2+=pal;
				   }
			   }
			   
			return pal2; 
		 }
		 /*************************************************************************************************************************************/
		 
	     public  void cargarExcel(String cadenar) throws FileNotFoundException, IOException{
			 
			 HSSFCell descripcion=null,modelo=null,cod_prove = null,cod_mar = null,cod_umed=null,
			 cod_rubro=null,cos_det=null,mon_det=null,igv_det=null;
			 POIFSFileSystem  fs = new POIFSFileSystem(new FileInputStream(cadenar.trim()));
			 HSSFWorkbook wb = new HSSFWorkbook(fs);
			int tamañ=tamañodelExcel(cadenar.trim());
			//System.out.println("EL TAMAÑO DEL EXCEL ES:"+tamañ);
			
			 for (int i = 0; i < tamañ; i++) {
				if(i==0){
					//NADAAAAAAA
				}else{
					descripcion= wb.getSheetAt(0).getRow(i).getCell((short)0);
					modelo = wb.getSheetAt(0).getRow(i).getCell((short)1);	
					cod_prove = wb.getSheetAt(0).getRow(i).getCell((short)2);
					cod_mar = wb.getSheetAt(0).getRow(i).getCell((short)3);	
					cod_umed = wb.getSheetAt(0).getRow(i).getCell((short)4);
                    cod_rubro=wb.getSheetAt(0).getRow(i).getCell((short)5);	
					cos_det= wb.getSheetAt(0).getRow(i).getCell((short)6);	
					mon_det= wb.getSheetAt(0).getRow(i).getCell((short)7);	
					igv_det= wb.getSheetAt(0).getRow(i).getCell((short)8);
					
					//System.out.println("des:"+descripcion+" "+"codrubro:"+cod_rubro);
				    //if(descripcion.equals("")){
				    	//NADA
				    	//System.out.println("nada");
				    //}else{
				    	//System.out.println("si");
				    	
				    	BeanCargarPrecios objPre=new BeanCargarPrecios(""+descripcion,SinAsterisco(""+modelo),
				    			  Sindecimal(""+cod_prove),Sindecimal(""+cod_mar),Sindecimal(""+cod_umed),
				    			  Sindecimal(""+cod_rubro),""+cos_det,""+mon_det,Sindecimal(""+igv_det));
						 
						  adicionar(objPre);
				    //}
					
				  	
				}
			}
			 
			 
		 }
		 /********************************************************************************************************************************************/

		
		

}
