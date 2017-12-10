
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class backpack {
    static int Max = 0;
    private final int L = 100; //Грузоподъемность рюкзака
    Chromosome[] Generation = new Chromosome[8];  //Поколение
    Subject[] SetOfSubject = new Subject[6];

    public void createSet() {        // набор предметов max ценность 165 - 011010
        SetOfSubject[0] = new Subject(15, 60);
        SetOfSubject[1] = new Subject(45, 30);
        SetOfSubject[2] = new Subject(80, 20);
        SetOfSubject[3] = new Subject(60, 60);
        SetOfSubject[4] = new Subject(40, 50);
        SetOfSubject[5] = new Subject(40, 100);
    }


    public class Subject {  //Предмет с определенной ценностью и весом

        private final double Ci;
        private final double Wi;

        public Subject(int Ci, int Wi) {
            this.Ci = Ci;
            this.Wi = Wi;
        }


        @Override
        public String toString() {
            return ("Ценность = " + Ci + ",Вес = " + Wi + " ");
        }
    }

    public class Chromosome {  //Хромосома = набор бит
        int[] x = new int[6];

        public Chromosome(int[] x) {
            this.x = x;
        }


        @Override
        public String toString() {
            String abc = "";
            for (int i = 0; i < x.length; i++) {
                abc += (x[i]);
            }
            return abc;
        }

        public Chromosome createChromosome() {  //создание случайной хромосомы,такой что рюкзак не переполняется
            int y[] = new int[6];
            int sum = 0;
            Chromosome chr = new Chromosome(y);
            for (int i = 0; i < y.length; i++) {
                y[i] = 0;
                if ((sum > L) || (sum + SetOfSubject[i].Wi > L)) continue;
                Random random = new Random();
                y[i] = random.nextInt(2);
                if (y[i] == 1) sum += SetOfSubject[i].Wi;
            }
            return chr;
        }

        public int worthChromosome(Chromosome chr) {
            int sum = 0;
            for (int i = 0; i < chr.x.length; i++) {
                if (x[i] == 1) sum += SetOfSubject[i].Ci;
            }
            return sum;
        }

        public int weigthChromosome(Chromosome chr) {
            int sum = 0;
            for (int i = 0; i < chr.x.length; i++) {
                if (x[i] == 1) sum += SetOfSubject[i].Wi;
            }
            return sum;
        }
    }


    public void creationGeneration() {     //Создадим первое поколение из 8 случайных наборов хромосом
        int y[] = new int[6];
        for (int i = 0; i < Generation.length; i++) {
            Generation[i] = new Chromosome(y).createChromosome();
        }
        System.out.println("Начальные случайные хромосомы:");
        for (int i = 0; i < Generation.length; i++) {
            System.out.println(Generation[i]);

        }
    }


    public Chromosome crossingChromosome(Chromosome father, Chromosome mother) {    //Скрещивание хромосом
        Chromosome child = new Chromosome(new int[6]);
        for (int i = 0; i < mother.x.length; i++) {
            if (father.x[i] == mother.x[i]) child.x[i] = mother.x[i];
            else {
                Random random = new Random();
                child.x[i] = random.nextInt(2);                       //там где "гены" различны,происходит мутация
            }

        }
        return child;
    }

    public void crossingAll() {               //скрещивание всех между собой

        List<Chromosome> crossingResults = new LinkedList<Chromosome>();

        for (int i = 0; i < Generation.length; i++) {
            for (int k = 0; k < Generation.length; k++) {
                if (k != i) crossingResults.add(crossingChromosome(Generation[k], Generation[i]));

            }

        }
        System.out.println("Список скрещенных хромосом или 'детей':");
        System.out.println(crossingResults);


        java.util.ListIterator<Chromosome> listIter = crossingResults.listIterator();

        Chromosome[] arr = new Chromosome[crossingResults.size()];          //переношу данные из листа в массив
        int count = 0;
        while (listIter.hasNext()) {
            arr[count] = listIter.next();
            count++;

        }


        int index = 0;
        while (index < 5) {                  //Провожу селекцию,удаляя те хромосомы где вес больше заданного,и оставляю хромосомы с максимальной ценностью в количестве равном начальной популяции
            int cnt = 0;
            int[] ar = {0, 0, 0, 0, 0, 0};
            Chromosome maximum = new Chromosome(ar);
            for (int i = 0; i < arr.length; i++) {
                if ((maximum.worthChromosome(maximum) < arr[i].worthChromosome(arr[i])) && (arr[i].weigthChromosome(arr[i]) < L)) {
                    maximum = arr[i];
                    cnt = i;
                }
            }
            Generation[index] = maximum;
            arr[cnt] = new Chromosome(ar);
            index++;

        }
        System.out.println("Список выживших,прошедших отбор:");
        for (int i = 0; i < Generation.length; i++) {
            if (Generation[i].worthChromosome(Generation[i]) > Max) Max = Generation[i].worthChromosome(Generation[i]);
            System.out.println(Generation[i]);
        }


    }


    public static void main(String[] args)  {   //пример использования для набора предметов,указанного в условии
        backpack demo = new backpack();                                           //для увеличения точности можно увеличить генотип,т.е количество хромосом
        demo.createSet();                                                         //в одном из трех случаев получаю верный ответ,в остальных приблеженный
        demo.creationGeneration();
        demo.crossingAll();
        demo.crossingAll();
        demo.crossingAll();
        demo.crossingAll();
        demo.crossingAll();
        demo.crossingAll();
        System.out.println("Максимальная ценность при данном наборе хромосом - " + Max);

    }
}
