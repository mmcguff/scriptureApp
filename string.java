
class ScriptureString
{
    public static void main(String args[])
    {
		String[] ScriptList = new String[10];
		String scripture;

		ScriptList[0] = "Romans 12:2. Do not conform to the pattern of this world, but be transformed by the renewing of your mind. Then you will be able to test and approve what God’s will is—his good, pleasing and perfect will.";
		ScriptList[1] = "Phillipians 4:8. Finally, brothers and sisters, whatever is true, whatever is noble, whatever is right, whatever is pure, whatever is lovely, whatever is admirable—if anything is excellent or praiseworthy—think about such things.";
		ScriptList[2] = "Phillipians 4:6. Do not be anxious about anything, but in every situation, by prayer and petition, with thanksgiving, present your requests to God.";
		ScriptList[3] = "Moses 1:39. For behold, this is my work and my glory—to bring to pass the immortality and eternal life of man";
		ScriptList[4] = "1 Nephi 3:7. And it came to pass that I, Nephi, said unto my father: I will go and do the things which the Lord hath commanded, for I know that the Lord giveth no commandments unto the children of men, save he shall prepare a way for them that they may accomplish the thing which he commandeth them.";
		ScriptList[5] = "DC 10:5. Pray always, that you may come off conqueror; yea, that you may conquer Satan, and that you may escape the hands of the servants of Satan that do uphold his work.";
		ScriptList[6] = "John 3:5. Jesus answered, Verily, verily, I say unto thee, Except a man be born of water and of the Spirit, he cannot enter into the kingdom of God.";
		ScriptList[7] = "Genesis 39:9. There is none greater in this house than I; neither hath he kept back any thing from me but thee, because thou art his wife: how then can I do this great wickedness, and sin against God?";
		ScriptList[8] = "Psalms 127:3. Lo, children are an heritage of the Lord: and the fruit of the womb is his reward.";
		//ScriptList[9] = "DC 107:8. The Melchizedek Priesthood holds the right of presidency, and has power and authority over all the offices in the church in all ages of the world, to administer in spiritual things.";
		try
		{
			test1();
		}
		catch(Exception e)
		{
			System.out.println("Test 1 Failed.");
		}
		try
		{
			for (int i = 0; i < 9; i++)
			{
				scripture = ScriptList[i];
				test2(scripture);
			}
		}
		catch(Exception e)
		{
			System.out.println("Test 2 Failed.");
		}
		int random = (int)(Math.random() * 10 + 0);
		assert(9 >= random);
		assert(random >= 0);
		scripture = ScriptList[random];
		System.out.println(scripture);
    }
	public static void test1()
	{
		int random;
		for (int i = 0; i < 100; i++)
		{
			random = (int)(Math.random() * 10 + 0);
			assert(9 >= random);
			assert(random >= 0);
		}
		System.out.println("Test 1 complete");
	}
	public static void test2(String scripture)
	{
		assert (scripture instanceof String);
		System.out.println(scripture + "Pass.");
	}
}
