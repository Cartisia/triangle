package triangle;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import triangle.triangle;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class testTriangle {
	private triangle tr;
	private int input1;
	private int input2;
	private int input3;
	private String expType;
	private boolean expected;

	public testTriangle(int input1,int input2,int input3,boolean expected,String expType)
	{
		this.input1 = input1;
		this.input2 = input2;
		this.input3 = input3;
		this.expType = expType;
		this.expected = expected;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp()
	{
		tr = new triangle();
	}
	
	@Parameters
	public static Collection<Object[]>getData(){
		return Arrays.asList(new Object[][]{
				{99,101,99,false,"��ȡֵ������Χ"},
				{1,2,-1,false,"��ȡֵ������Χ"},
				{99,99,101,false,"��ȡֵ������Χ"},
				{2,2,3,false,"����������"},
				{2,3,2,false,"����������"},
				{3,2,2,false,"����������"},
				{2,2,2,false,"�ȱ�������"},
				{3,4,5,true,"ֱ��������"},
				{4,3,5,true,"ֱ��������"},
				{5,3,4,true,"ֱ��������"},
				{4,5,3,true,"ֱ��������"},
				{2,3,4,false,"һ��������"},
				{3,2,4,false,"һ��������"},
				{4,2,3,false,"һ��������"},
				{3,4,2,false,"һ��������"},
		});
	}
	@Test
	public void testType() throws Exception
	{
		
		assertEquals(this.expType,tr.getType(input1,input2,input3));
	}
	
	@Test
	public void testIsRtTrisngle() throws Exception
	{
		//��ȡClass ����
				Class<? extends triangle> triangle = tr.getClass();
				//��ȡ����
				Method method = triangle.getDeclaredMethod("IsRtTriangle", 
						new Class[]{int.class,int.class,int.class});
				//��˽�����ÿɷ���
				method.setAccessible(true);
				//��ֵ�����ؽ������
				Object actual = method.invoke(tr,input1,input2,input3);
				//�Ƚ�Ԥ�ںͽ��
				assertEquals(this.expected,actual);

	}
}
