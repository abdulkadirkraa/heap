
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Sayıları virgül ile giriniz: ");

        String nums = input.nextLine();
        String[] virgul = nums.split(",");
        int[] dizi = new int[virgul.length];

        for (int i = 0; i < virgul.length; i++) {
            dizi[i] = Integer.parseInt(virgul[i]);
        }

        System.out.println("Girilen sayıların dizisi: ");

        for (int i = 0; i < dizi.length; i++) {
        	System.out.print(dizi[i] + " ");
        }
        isMinHeap(dizi);
        
        Heap heap=new Heap();
        for(int i=0;i<dizi.length;i++) {
        	heap.insert(dizi[i]);
        }
        heap.gezinti();
    }
    public static void isMinHeap(int[] dizi) {

        boolean isminheap = true;
        boolean ucludurumlari;

        if (dizi.length != 0) {
            for (int i = 0; i < (dizi.length - 3) / 3; i++) {
                //sol çocuk
                if (dizi[3 * i + 1] < dizi[i]) {
                    //Orta Çocuk 
                    if (3 * i + 2 < dizi.length && dizi[3 * i + 2] < dizi[i]) {
                        //Sağ Çocuk
                        if (3 * i + 3 < dizi.length && dizi[3 * i + 3] < dizi[i]) {
                            ucludurumlari = true;
                        } else {
                            ucludurumlari = false;
                            isminheap = false;
                        }
                    } else {
                        ucludurumlari = false;
                        isminheap = false;
                    }
                } else {
                    ucludurumlari = false;
                    isminheap = false;
                }
            }
        } else {
            ucludurumlari = false;
            isminheap = false;
        }

        if (isminheap) {
            System.out.println("Dizi uclu min heaptir");
        } else {
            System.out.println("Dizi uclu min heap degildir");
        }

    }


}
