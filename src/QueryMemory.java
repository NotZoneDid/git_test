


public class QueryMemory {
	private final static Runtime comput =Runtime.getRuntime();
	
	public static String getMaxMemory(){
		return "最大可用内存:"+(comput.maxMemory()>>20)+"M ";
	}
	public static String getTotalMemory(){
		return "总内存:"+(comput.totalMemory()>>20)+"M ";
	}
	public static String getNotUseMemory(){
		return "空闲内存:"+(comput.freeMemory()>>20)+"M ";
	}
	public static void clear(){
		comput.gc();
	}
	public static void getUseingMemory(){
		comput.addShutdownHook(new Thread(){
			@Override
			public void run() {
				StringBuffer sb =new StringBuffer();
				sb.append(getTotalMemory());
				sb.append(getNotUseMemory());
				System.out.println(sb);
			}
		});
	}
}
