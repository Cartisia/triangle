package triangle;

public class triangle {
	private int side1;
	private int side2;
	private int side3;
	
	public triangle()
	{
		this(1,1,1);
	}

	public triangle(int a, int b, int c) {
		this.side1 = a;
		this.side2 = b;
		this.side3 = c;
	}
	
	public String getType(int side1,int side2,int side3) throws Exception{
		if(side1 < 1 || side1 > 100 || side2 < 1 || side2 > 100 || side3 < 1 || side3 > 100)
			return "��ȡֵ������Χ" ;
		if(side1 + side2 <= side3 || side1 + side3 <= side2 ||side2 + side3 <= side1)
			throw new Exception("������������");
		if(side1 == side2 && side2 == side3)
			return "�ȱ�������";
		else if((side1 == side2 || side1 == side3 || side2 == side3)&&(IsRtTriangle(side1,side2,side3)))
			return "����ֱ��������" ;
		else if(side1 == side2 || side1 == side3 || side2 == side3)
		    return "����������";
		else if(IsRtTriangle(side1,side2,side3))
			return "ֱ��������";
		else
			return "һ��������";
			
		} 
	
	public boolean IsRtTriangle(int a,int b,int c){
		int a1 = a * a;
		int b1 = b * b;
		int c1 = c * c;
		if(a1 + b1 == c1 || a1 + c1 == b1 || b1 + c1 == a1)
			return true;
		return false;
	}
	
	public static void main(String[] args){
		triangle tr = new triangle (3,4,5);
		try
		{
			System.out.println(tr.getType(3,4,5));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}


