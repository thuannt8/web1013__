package asm2;

import java.util.Scanner;

public class asm2 {
	static int soLuong;
	static String[] ma, ten ;
    static double[] luong;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner input=new Scanner(System.in);
		     do
		     {
		    	 System.out.println("+======================================+");
			     System.out.println("                MENU               ");
			     System.out.println("1.Nhap danh sach nhan vien"); 
			     System.out.println("2.Xuat danh sach nhan vien"); 
			     System.out.println("3.Tim va hien thi nhan vien"); 
			     System.out.println("4.Xoa nhan vien theo ma");
			     System.out.println("5.Cap nhat thong tin nhan vien theo ma");
			     System.out.println("5.Tim nhan vien theo luong");
			     System.out.println("7.Sap xep nhan vien theo ho ten");
			     System.out.println("8.Sap xep nhan vien theo thu nhap");
			     System.out.println("9.Hien thi top 5");
			     System.out.println("10.Thoat");
			     System.out.println("+======================================+");
			     System.out.print("Hay chon chuc nang: ");
			     int chon=input.nextInt();
		        
		        	 switch(chon) {
		             case 1:
		             	CN1();
		             	break;
		             case 2:
		             	CN2();
		             	break;
		             case 3:
		             	CN3();
		             	break;
		             case 4:
		             	CN4();
		             	break;
		             case 5:
		             	CN5();
		             	break;
		             case 6:
		             	CN6();
		             	break;
		             case 7:
		             	CN7();
		             	break;
		             case 8:
		             	CN8();
		             	break;
		             case 9:
		             	CN9();
		             	break;
		             case 10:		            	
		             	break;
		            
		             }
		     }while(true);
			
	}
	
	public static void CN1() {
		System.out.print("----Chuc nang 1----\n");
		Scanner s= new Scanner(System.in);
		System.out.print("Nhap so luong nhan vien:\n"); 
		soLuong=Integer.parseInt(s.nextLine());
		ma = new String[soLuong];
		ten= new String[soLuong];
		luong= new double[soLuong];
		for(int i=0 ; i < soLuong ; i++) {
			System.out.print("Ma nhan vien :");
			ma[i]=s.nextLine();
			System.out.print("Ten nhan vien :");
			ten[i]=s.nextLine();
			System.out.print("Luong :");
			luong[i]= Double.parseDouble( s.nextLine());
			System.out.println("==================");
			}
	}
	
	
	public static void CN2() {
		System.out.print("----Chuc nang 2----\n");
		System.out.print("==XUAT DANH SACH==\n");
		for(int i=0 ; i< soLuong ; i++) {
			System.out.printf("Ma: %s ", ma[i]);
			System.out.printf("Ten: %s ", ten[i]);
			System.out.printf("Luong: %.1f \n ", luong[i]);
		}
	}
	
	
	public static void CN3() {
		System.out.print("----Chuc nang 3----\n");
		System.out.print("=== TIM NHAN VIEN===\n");
		Scanner s = new Scanner(System.in);
		System.out.print("Nhap vao thong tin can tim :");
		String ma1 = s.nextLine();
		for(int i=0 ; i<soLuong ; i++ ) {
			if(ma[i].equalsIgnoreCase(ma1)) {
				System.out.print("Thong tin nhan vien can tim: ");
				System.out.printf("Ma : %s , Ten: %s , Luong: %.1f\n", ma[i], ten[i],luong[i]);
			}
		}
	}
	
	
	public static void CN4() {
		System.out.print("----Chuc nang 4----\n");
		System.out.print("== XOA NHAN VIEN ==\n");
		Scanner s = new Scanner(System.in);
		System.out.print("Nhap vao ma muon xoa: ");
		String ma1= s.nextLine();
		for(int i=0 ; i<soLuong ; i++) {
			if ( ma[i].equalsIgnoreCase(ma1)) {
				removeItemString(ma,i);
			}
		}
	}
	static String[] removeItemString (String[] arr , int index) {
		if(arr==null || index<0 || index> arr.length) {
			return arr;
		}
		  String[] Array= new String[arr.length-1];
		  for(int i=0, k=0 ; i<arr.length; i++) {
			  if(i==index) {
				  continue;
			  }
			  Array[k++]=arr[i];
		  }
		  return Array;
	}
	
	
	public static void CN5() {
		System.out.print("----Chuc nang 5----\n");
		System.out.print("== CAP NHAT ==\n");
		System.out.print("Nhap ma can cap nhat");
		Scanner s = new Scanner(System.in);
		String ma1= s.nextLine();
		for(int i=0 ; i< soLuong ; i++) {
			if(ma[i].equalsIgnoreCase(ma1)) {
				System.out.print("Cap nhat thong tin moi ( ten, luong)");
				ten[i]=s.nextLine();
				luong[i]= s.nextDouble();
			}
		}
		
	}
	
	
	public static void CN6() {
		System.out.print("----Chuc nang 6----\n");
		System.out.print("== TIM THEO KHOANG LUONG==\n");
		Scanner s= new Scanner(System.in);
		System.out.print("Min:");
		double min= Double.parseDouble(s.nextLine());
		System.out.print("Max:");
		double max= Double.parseDouble(s.nextLine());
		for(int i=0 ; i<soLuong ; i++) {
			if(min <= luong[i] && luong[i] <= max) {
				System.out.printf("Ma: %s\n", ma[i]);
				System.out.printf("Ten: %s\n", ten[i]);
				System.out.printf("Luong: %.1f\n", luong[i]);
				System.out.printf("=====================\n");
			}
		}
	}
	
	
	public static void CN7() {
		System.out.print("----Chuc nang 7----\n");
		System.out.print("== SAP XEP THEO TEN ==\n");
		for( int i=0 ; i< soLuong ;i++) {
			for( int j=i+1 ; j<soLuong ;j++) {
				if( ten[i].charAt(0) > ten[j].charAt(0)) {
					
					String maTam = ma[i];
					ma[i] = ma[j];
					ma[j] = maTam;
					
					String tenTam = ten[i];
					ten[i] = ten[j];
					ten[j] = tenTam;
					
					double luongTam = luong[i];
					luong[i] = luong[j];
					luong[j] = luongTam;
				}
			}
		}
	}
	
	
	public static void CN8() {
		System.out.print("----Chuc nang 8----\n");
		System.out.print("== SAP XEP THEO THU NHAP==\n");
		for( int i=0 ; i< soLuong ;i++) {
			for( int j=i+1 ; j<soLuong ;j++) {
				if( luong[i] < luong[j]) {
					
					String maTam = ma[i];
					ma[i] = ma[j];
					ma[j] = maTam;
					
					String tenTam = ten[i];
					ten[i] = ten[j];
					ten[j] = tenTam;
					
					double luongTam = luong[i];
					luong[i] = luong[j];
					luong[j] = luongTam;
				}
			}
		}
	}
	
	
	public static void CN9() {
		System.out.print("----Chuc nang 9----\n");
		System.out.print("== TOP 5 ==");
		CN8();
		if(soLuong>5) {
			for( int i=0 ; i<5 ;i++) {
				System.out.printf("Ma: %s ", ma[i]);
				System.out.printf("Ten: %s ", ten[i]);
				System.out.printf("Luong: %.1f \n ", luong[i]);
			}
		}
	}
	

}


