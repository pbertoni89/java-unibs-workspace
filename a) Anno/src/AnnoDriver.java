
public class AnnoDriver {

	public static void main(String[] args) {
		
		Anno duemila= new Anno(2004);
		Anno milleQuattrocento= new Anno(1400);
		Anno trentaDue= new Anno(32);

		//duemila.bisestile();
		System.out.println(duemila.bisestile() +" "+ duemila.solare());
		System.out.println(milleQuattrocento.bisestile() +" "+ milleQuattrocento.solare());
		System.out.println(trentaDue.bisestile() +" "+ trentaDue.solare());
		
	}

}
