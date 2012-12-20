
package partly.cloudy;

import org.jmock.Expectations;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jmock.Mockery;

public class CloudTest {
    
    private Mockery context = new Mockery();
    final IDaylight dl = context.mock(IDaylight.class);
    final IWind w = context.mock(IWind.class);
    final ILuminary l = context.mock(ILuminary.class);
    final IMagic m = context.mock(IMagic.class);
    
    public CloudTest() {
    }
    
    @Test
    public void PuppyCreate()
    {
        System.out.println("create puppy");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.Noon), new TestLuminary(true),
                                   new TestWind(1), new Magic());
        CreatureType expResult = CreatureType.Puppy;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void KittenCreate()
    {
        System.out.println("create kitten");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.Night), new TestLuminary(true),
                                   new TestWind(4), new Magic());
        CreatureType expResult = CreatureType.Kitten;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void BearcubCreate()
    {
        System.out.println("create bearcub");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.Morning), new TestLuminary(true),
                                   new TestWind(6), new Magic());
        CreatureType expResult = CreatureType.Bearcub;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void HedgehodCreate()
    {
        System.out.println("create hedgehog");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.Noon), new TestLuminary(true),
                                   new TestWind(9), new Magic());
        CreatureType expResult = CreatureType.Hedgehog;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void PigletCreate()
    {
        System.out.println("create piglet");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.Morning), new TestLuminary(false),
                                   new TestWind(3), new Magic());
        CreatureType expResult = CreatureType.Piglet;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void BatCreate()
    {
        System.out.println("create bat");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.Evening), new TestLuminary(false),
                                   new TestWind(6), new Magic());
        CreatureType expResult = CreatureType.Bat;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
    @Test
    public void BaloonCreate()
    {
        System.out.println("create baloon");
        Cloud instance = new Cloud(new TestDaylight(DaylightType.Morning), new TestLuminary(false),
                                   new TestWind(9), new Magic());
        CreatureType expResult = CreatureType.Baloon;
        Creature result = instance.create();
        assertEquals(expResult, result.getCreatureType());
    }
    
     @Test
     public void PuppyDynamicCreateTest()
     {
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations()
        {{
            one(dl).current(); will(returnValue(DaylightType.Noon));
            one(w).windStrength(); will(returnValue(1));
            one(l).isShining(); will(returnValue(true));
            one(m).callDaemon(CreatureType.Puppy);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();
     }
     
     @Test
     public void KittenDynamicCreateTest()
     {
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations()
        {{
            one(dl).current(); will(returnValue(DaylightType.Night));
            one(w).windStrength(); will(returnValue(4));
            one(l).isShining(); will(returnValue(true));
            one(m).callStork(CreatureType.Kitten);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();
     }
     
     @Test
     public void BearcubDynamicCreateTest()
     {
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations()
        {{
            one(dl).current(); will(returnValue(DaylightType.Morning));
            one(w).windStrength(); will(returnValue(6));
            one(l).isShining(); will(returnValue(true));
            one(m).callDaemon(CreatureType.Bearcub);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();
     }
     
     @Test
     public void HedgehogDynamicCreateTest()
     {
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations()
        {{
            one(dl).current(); will(returnValue(DaylightType.Noon));
            one(w).windStrength(); will(returnValue(9));
            one(l).isShining(); will(returnValue(true));
            one(m).callDaemon(CreatureType.Hedgehog);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();
     }
     
     @Test
     public void PigletDynamicCreateTest()
     {
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations()
        {{
            one(dl).current(); will(returnValue(DaylightType.Noon));
            one(w).windStrength(); will(returnValue(3));
            one(l).isShining(); will(returnValue(false));
            one(m).callDaemon(CreatureType.Piglet);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();
     }
     
     @Test
     public void BatDynamicCreateTest()
     {
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations()
        {{
            one(dl).current(); will(returnValue(DaylightType.Noon));
            one(w).windStrength(); will(returnValue(6));
            one(l).isShining(); will(returnValue(false));
            one(m).callDaemon(CreatureType.Bat);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();
     }
     
     @Test
     public void BaloonDynamicCreateTest()
     {
        Cloud cloud = new Cloud(dl, l, w, m);
        context.checking(new Expectations()
        {{
            one(dl).current(); will(returnValue(DaylightType.Noon));
            one(w).windStrength(); will(returnValue(10));
            one(l).isShining(); will(returnValue(false));
            one(m).callDaemon(CreatureType.Baloon);
        }}
        );
        cloud.create();
        context.assertIsSatisfied();
     }
}
