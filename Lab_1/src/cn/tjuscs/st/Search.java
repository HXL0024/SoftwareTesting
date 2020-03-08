package cn.tjuscs.st;

public class Search {
	public boolean Search1(int totalAmount){
		int figure[] = {50,20,10,5,1};
		int quantity[] = {1,1,1,2,3};
		int m=0;
		
		for(int i=0;i<=quantity[0];i++)
		{
			for(int j=0;j<=quantity[1];j++)
			{
				for(int k=0;k<=quantity[2];k++)
				{
					for(int l=0;l<=quantity[3];l++)
					{
						for(int p=0;p<=quantity[4];p++)
						{
							int total = i*figure[0]+j*figure[1]+k*figure[2]+l*figure[3]+p*figure[4];
							if(totalAmount == total)
							{
								m++;
								System.out.println(figure[0]+" "+i);
								System.out.println(figure[1]+" "+j);
								System.out.println(figure[2]+" "+k);
								System.out.println(figure[3]+" "+l);
								System.out.println(figure[4]+" "+p);
								System.out.println();
								
							}
						}
					}
				}
			}
		}
		System.out.println(m);
		System.out.println();
		System.out.println();
		if(m==0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}

}
