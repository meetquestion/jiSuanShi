package jiSuanShi;
import java.util.Random;
import java.util.Scanner;

public class JiSuanShi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入总数：");
		N = scan.nextInt();
		String[] jss = new String[N];
		System.out.println("1、整数计算式，2、真分数计算式");
		int p = scan.nextInt();
		if(p == 1) {
			jss = createZhengShuJiSuanShi(N);
		}else {
			jss = createZhenFenShuJiSuanShi(N);
		}
		scan.close();
		
		//显示结果
		for(int i = 0;i < N;i++) {
			System.out.println((i + 1) + " : " + jss[i]);
		}
	}
	
	//生成真分数计算式
	public static String[] createZhenFenShuJiSuanShi(int n) {
		int x,y,z,a,b,i = 0;
		String[] jss = new String[n];
		String t = "";
		Random rd = new Random();
		
		while(i < n) {
			a = rd.nextInt(100);
			b = rd.nextInt(100);
			
			
			
			if(a != 0 && b != 0){
				x = rd.nextInt(a);
				y = rd.nextInt(b);
				z = rd.nextInt(4);
				t = "";
				if(y != 0){
					if(z == 0) {
						if((x * b + y * a) < (a * b))
							t = "" + yueJian(x, a) + " + " + yueJian(y, b) + "=" + yueJian((x * b + y * a), (a * b));
					
					}else if(z == 1) {
						if((x * b - y * a) >= 0 && (x * b - y * a) < (a * b))
							t = "" + yueJian(x, a) + " - " + yueJian(y, b) + "=" + yueJian((x * b - y * a), (a * b));
					
					}else if(z == 2) {
						if((x * y) < (a * b))
							t = "" + yueJian(x, a) + " * " + yueJian(y, b) + "=" + yueJian((x * y),(a * b));
					
					}else{
						if((y / b) != 0){
							if((x * b) < (a * y))
								t = "" + yueJian(x, a) + " / " + yueJian(y, b) + "=" + yueJian((x * b),(a * y));
						}
					}
					if((!t.equals("")) && buChong(jss,t,i)){
						jss[i++] = t;
					}
				}
			}
		}
		return jss;
	}
	
	//生成整数计算式
	public static String[] createZhengShuJiSuanShi(int n) {
		int x,y,z,i = 0;
		String[] jss = new String[n];
		String t = "";
		Random rd = new Random();
		while(i < n) {
			x = rd.nextInt(100);
			y = rd.nextInt(100);
			z = rd.nextInt(4);
			
				if(z == 0) {
					t = "" + x + " + " + y  + "=" + (x + y);
					
				}else if(z == 1 && x >= y) {
					t = "" + x + " - " + y  + "=" + (x - y);
					
				}else if(z == 2) {
					t = "" + x + " * " + y  + "=" + (x * y);
					
				}else{
					if(y != 0){
						if(x % y == 0)
							t = "" + x + " / " + y  + "=" + (x / y);
					}
				}
				
				if(buChong(jss,t,i)){
					jss[i++] = t;
				}
			
		}
		return jss;
	}
	
	//约简分子分母，如果分子为0则返回0
	public static String yueJian(int a,int b){
		
		int y = 1;
		for(int i = a;i >= 1;i--) {
			if(a % i == 0 && b % i == 0){
				y = i;
				break;
			}
		}
		int z = a / y;
		int m = b / y;
		if(z == 0) {
			return "0";
		}
		return "" + z + "/" + m;
	}
	
	//检测是否重复（检测j是否与jss数组的前n个重复）重复返回FALSE 不重复返回TRUE
	public static boolean buChong(String[] jss,String j,int n) {
		for(int i = 0;i < n;i++) {
			if(jss[i].equals(j)){
				return false;
			}
		}
		return true;
	}



}
