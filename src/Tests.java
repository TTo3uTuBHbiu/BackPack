import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by z on 13.12.2017.
 */
public class Tests {
    @Test
    public void Test1(){
            backpack.Subject[] SetOfSubject = new backpack.Subject[1];
            SetOfSubject[0] = new backpack.Subject(15, 60);
            backpack demo = new backpack(100,SetOfSubject);
            demo.creationGeneration();
            demo.crossingAllMany();
            assertEquals(15,demo.Max);

    }
    @Test
    public void Test2(){
        backpack.Subject[] SetOfSubject2 = new backpack.Subject[5];
        SetOfSubject2[0] = new backpack.Subject(15, 60);
        SetOfSubject2[1] = new backpack.Subject(25, 60);
        SetOfSubject2[2] = new backpack.Subject(15, 60);
        SetOfSubject2[3] = new backpack.Subject(5, 60);
        SetOfSubject2[4] = new backpack.Subject(8, 60);
        backpack demo2 = new backpack(120,SetOfSubject2);
        demo2.creationGeneration();
        demo2.crossingAllMany();
        assertEquals(40,demo2.Max);

    }


    @Test
    public void Test3(){
        backpack.Subject[] SetOfSubject3 = new backpack.Subject[9];
        SetOfSubject3[0] = new backpack.Subject(43, 40);
        SetOfSubject3[1] = new backpack.Subject(25, 50);
        SetOfSubject3[2] = new backpack.Subject(35, 20);
        SetOfSubject3[3] = new backpack.Subject(55, 80);
        SetOfSubject3[4] = new backpack.Subject(86, 15);
        SetOfSubject3[5] = new backpack.Subject(23, 20);
        SetOfSubject3[6] = new backpack.Subject(48, 70);
        SetOfSubject3[7] = new backpack.Subject(24, 20);
        SetOfSubject3[8] = new backpack.Subject(81, 90);
        backpack demo3 = new backpack(200,SetOfSubject3);
        demo3.creationGeneration();
        demo3.crossingAllMany();
        assertEquals(269,demo3.Max);

    }
    @Test
    public void Test4(){
        backpack.Subject[] SetOfSubject4 = new backpack.Subject[5];
        SetOfSubject4[0] = new backpack.Subject(40, 10);
        SetOfSubject4[1] = new backpack.Subject(40, 20);
        SetOfSubject4[2] = new backpack.Subject(40, 30);
        SetOfSubject4[3] = new backpack.Subject(40, 40);
        SetOfSubject4[4] = new backpack.Subject(40, 50);
        backpack demo4 = new backpack(70,SetOfSubject4);
        demo4.creationGeneration();
        demo4.crossingAllMany();
        assertEquals(120,demo4.Max);

    }

    @Test
    public void Test5(){
        backpack.Subject[] SetOfSubject5 = new backpack.Subject[9];
        SetOfSubject5[0] = new backpack.Subject(1143, 90);
        SetOfSubject5[1] = new backpack.Subject(25, 50);
        SetOfSubject5[2] = new backpack.Subject(35, 30);
        SetOfSubject5[3] = new backpack.Subject(55, 60);
        SetOfSubject5[4] = new backpack.Subject(86, 45);
        SetOfSubject5[5] = new backpack.Subject(75, 90);
        SetOfSubject5[6] = new backpack.Subject(48, 70);
        SetOfSubject5[7] = new backpack.Subject(24, 50);
        SetOfSubject5[8] = new backpack.Subject(81, 90);
        backpack demo5 = new backpack(90,SetOfSubject5);
        demo5.creationGeneration();
        demo5.crossingAllMany();
        assertEquals(1143,demo5.Max);

    }

    @Test
    public void Test6(){
        backpack.Subject[] SetOfSubject6 = new backpack.Subject[9];
        SetOfSubject6[0] = new backpack.Subject(100, 50);
        SetOfSubject6[1] = new backpack.Subject(100, 50);
        SetOfSubject6[2] = new backpack.Subject(100, 50);
        SetOfSubject6[3] = new backpack.Subject(100, 50);
        SetOfSubject6[4] = new backpack.Subject(5, 110);
        SetOfSubject6[5] = new backpack.Subject(25, 130);
        SetOfSubject6[6] = new backpack.Subject(40, 170);
        SetOfSubject6[7] = new backpack.Subject(10, 100);
        SetOfSubject6[8] = new backpack.Subject(10, 150);
        backpack demo6 = new backpack(220,SetOfSubject6);
        demo6.creationGeneration();
        demo6.crossingAllMany();
        assertEquals(400,demo6.Max);

    }


}
