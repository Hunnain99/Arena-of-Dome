/**
 * ClassName - An example class for assignment: EXERCISE COMPOSITION
 * Copyright 2021 Howard Community College
 * @author Hunnain Arsalan
 * @version 1.0
 *
 */
// CREATE POLYTEST CLASS
public class PolyTest {

// CREATE MAIN METHOD

    public static void main(String[] args) {

        // CREATE ARRAY OF COMBATANT HAVING 4 OBJECTS

        Combatant[] combatant = new Combatant[4];

        // CREATING OBJECTS TO STORE THEM IN ARRAY

        Goblin goblin = new Goblin();
        Ogre ogre = new Ogre();
        Gladiator gladiator = new Gladiator();
        Ogre ogre1 = new Ogre();

        // FILLING ARRAY WITH OBJECTS

        combatant[0] = goblin;
        combatant[1] = ogre;
        combatant[2] = gladiator;
        combatant[3] = ogre1;

        // TRAVERSING ARRAY USING FOR LOOP TO DISPLAY

        for (Combatant i: combatant)
        {
            System.out.println("\n"+i.toString());
        }

        // SET THE CURRENT HEALTH OF EACH COMBATANT TO 20

        for (int i=0; i<4; i++)
        {
            combatant[i].set_Current_Health(20);
        }
        System.out.println("\nCurrent health of each Combatant is set to 20.\n");
        
    }
}
