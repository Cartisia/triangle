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
				{99,101,99,false,"边取值超出范围"},
				{1,2,-1,false,"边取值超出范围"},
				{99,99,101,false,"边取值超出范围"},
				{2,2,3,false,"等腰三角形"},
				{2,3,2,false,"等腰三角形"},
				{3,2,2,false,"等腰三角形"},
				{2,2,2,false,"等边三角形"},
				{3,4,5,true,"直角三角形"},
				{4,3,5,true,"直角三角形"},
				{5,3,4,true,"直角三角形"},
				{4,5,3,true,"直角三角形"},
				{2,3,4,false,"一般三角形"},
				{3,2,4,false,"一般三角形"},
				{4,2,3,false,"一般三角形"},
				{3,4,2,false,"一般三角形"},
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
		//获取Class 对象
				Class<? extends triangle> triangle = tr.getClass();
				//获取方法
				Method method = triangle.getDeclaredMethod("IsRtTriangle", 
						new Class[]{int.class,int.class,int.class});
				//将私有设置可访问
				method.setAccessible(true);
				//传值，返回结果对象
				Object actual = method.invoke(tr,input1,input2,input3);
				//比较预期和结果
				assertEquals(this.expected,actual);

	}
}
