package footballGame;

import java.util.Random;

import fenerbahce.Fenerbahce;
import fenerbahce.Ferdi;
import fenerbahce.IrfanCan;
import fenerbahce.Pedro;
import fenerbahce.Rossi;
import galatasaray.Galatasaray;
import galatasaray.Icardi;
import galatasaray.Mertens;
import galatasaray.Oliveira;
import galatasaray.Torreira;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Galatasaray[] gs = {new Icardi(), new Mertens(), new Oliveira(), new Torreira()};
		Fenerbahce[] fb = {new IrfanCan(), new Pedro(), new Rossi(), new Ferdi()};
		Action action = new Action();

		Random random = new Random();
		
		int minute = 1; //mac dakikasi
		int attackingTeam = 0; //hangi takimin atak yapacagini belirler
		int whichFootballer = 0; //takimin kacinci oyuncusu eylem yapacak?
		int whichAction = 0; //oyuncu hangi eylemi yapacak?
		int whichActionAfterDribbling = 0; //rakibini gectikten sonra hangi eylemi yapacak?
		int previousFootballerGs = 0; //futbolcunun kendi kendine pas vermemesi icin kontrol
		int previousFootballerFb = 0;
		int fbGolSayisi=0; //skor icin gol sayaci
		int gsGolSayisi=0;
		
		
		while (minute<90) {
			attackingTeam = random.nextInt(1,3);
			minute+=random.nextInt(1,15);
			System.out.println("Dakika "+minute+"'");
			Thread.sleep(1000);
			
					
			if(attackingTeam==1) {
				System.out.println("Galatasaray ataga cikiyor");
				Thread.sleep(1000);
				while (true) {
					do {
						whichFootballer = random.nextInt(0,4);
					} while (previousFootballerGs==whichFootballer);
					
					whichAction = random.nextInt(1,4);
					
					System.out.println(gs[whichFootballer].getName()+ " topu aldi");
					Thread.sleep(1000);
					
					if (whichAction==1) {
						System.out.println("verdi pasini");
						Thread.sleep(1000);
						if (action.Pass(gs[whichFootballer].getPass())) {
							System.out.println("pas basarili");
							Thread.sleep(1000);
							previousFootballerGs=whichFootballer;
							continue;
												
						}else {
							System.out.println("ancak pasi basarisiz");
							System.out.println("-----------------");
							Thread.sleep(1000);
							break;
							
						}
						
						
					}
					
					if (whichAction==2) {
						System.out.println("cekti sutunu!");
						Thread.sleep(1000);
						if (action.Shot(gs[whichFootballer].getShot())) {
							System.out.println( "ve gol!");
							Thread.sleep(1000);
							gsGolSayisi++;
							System.out.println( "Fenerbahce : "+fbGolSayisi + " - "+gsGolSayisi+" : Galatasaray");
							
							
							
						}else {
							System.out.println( "top disarida, aut");
							
							
						}
						System.out.println("-----------------");
						Thread.sleep(1000);
						break;
					}
					
					if (whichAction==3) {
						System.out.println("bir calim denemesi!");
						Thread.sleep(1000);
						if (action.Dribbling(gs[whichFootballer].getDribbling())) {
							System.out.println( "ve gecti rakibini!");
							Thread.sleep(1000);
							
							whichActionAfterDribbling = random.nextInt(1,3);
							
							if (whichActionAfterDribbling==1) {
								System.out.println("simdi sutunu cekiyor!");
								Thread.sleep(1000);
								if (action.Shot(gs[whichFootballer].getShotAferDribbling())) {
									System.out.println( "ve gol!");
									Thread.sleep(1000);
									gsGolSayisi++;
									System.out.println( "Fenerbahce : "+fbGolSayisi + " - "+gsGolSayisi+" : Galatasaray");
																									
								}else {
									System.out.println( "az farkla kacti!");																		
								}
								break;
							}
							if (whichActionAfterDribbling==2) {
								System.out.println("simdi pasini veriyor");
								Thread.sleep(1000);
								if (action.Pass(gs[whichFootballer].getPassAfterDribbling())) {
									System.out.println("pasi basarili");
									Thread.sleep(1000);
									previousFootballerGs=whichFootballer;
									continue;
														
								}else {
									System.out.println("ancak pasi basarisiz");
									System.out.println("-----------------");
									Thread.sleep(1000);
									break;
									
								}
							}
							
																																	
						}else {
							System.out.println( "ancak kaptirdi topu");
							System.out.println("-----------------");
							Thread.sleep(1000);
							break;														
						}
					}
					
					
				}
				
				
				
			}
			
			
			if (attackingTeam==2) {
				System.out.println("Fenerbahce ataga cikiyor");
				Thread.sleep(1000);
				while (true) {
					do {
						whichFootballer = random.nextInt(0,4);
					} while (previousFootballerFb==whichFootballer);
					
					whichAction = random.nextInt(1,4);
					
					System.out.println(fb[whichFootballer].getName()+ " topu aldi");
					Thread.sleep(1000);
					
					if (whichAction==1) {
						System.out.println("verdi pasini");
						Thread.sleep(1000);
						if (action.Pass(fb[whichFootballer].getPass())) {
							System.out.println("pas basarili");
							Thread.sleep(1000);
							previousFootballerFb=whichFootballer;
							continue;
												
						}else {
							System.out.println("ancak pasi basarisiz");
							System.out.println("-----------------");
							Thread.sleep(1000);
							break;
							
							
						}
						
					}
					
					if (whichAction==2) {
						System.out.println("cekti sutunu!");
						Thread.sleep(1000);
						if (action.Shot(fb[whichFootballer].getShot())) {
							System.out.println( "ve gol!");
							Thread.sleep(1000);
							fbGolSayisi++;
							System.out.println( "Fenerbahce : "+fbGolSayisi + " - "+gsGolSayisi+" : Galatasaray");
							
						}else {
							System.out.println( "top disarida, aut");
							
							
						}
						System.out.println("-----------------");
						Thread.sleep(1000);
						break;
					}
					
					if (whichAction==3) {
						System.out.println("bir calim denemesi!");
						Thread.sleep(1000);
						if (action.Dribbling(fb[whichFootballer].getDribbling())) {
							System.out.println( "ve gecti rakibini!");
							Thread.sleep(1000);
							
							whichActionAfterDribbling = random.nextInt(1,3);
							
							if (whichActionAfterDribbling==1) {
								System.out.println("simdi sutunu cekiyor!");
								Thread.sleep(1000);
								if (action.Shot(fb[whichFootballer].getShotAferDribbling())) {
									System.out.println( "ve gol!");
									Thread.sleep(1000);
									fbGolSayisi++;
									System.out.println( "Fenerbahce : "+fbGolSayisi + " - "+gsGolSayisi+" : Galatasaray");
																									
								}else {
									System.out.println( "az farkla kacti!");																		
								}
								break;
							}
							if (whichActionAfterDribbling==2) {
								System.out.println("simdi pasini veriyor");
								Thread.sleep(1000);
								if (action.Pass(fb[whichFootballer].getPassAfterDribbling())) {
									System.out.println("pasi basarili");
									Thread.sleep(1000);
									previousFootballerFb=whichFootballer;
									continue;
														
								}else {
									System.out.println("ancak pasi basarisiz");
									System.out.println("-----------------");
									Thread.sleep(1000);
									break;
									
								}
							}
							
																																	
						}else {
							System.out.println( "ancak kaptirdi topu");
							System.out.println("-----------------");
							Thread.sleep(1000);
							break;														
						}
					}
					
				}
				
			}
			
			
			
		}
		
		System.out.println("Mac bitti!");
		System.out.println("Mac sonucu : Fenerbahce : "+fbGolSayisi + " - "+gsGolSayisi+" : Galatasaray");
		
		
		
		
		
	}

}
