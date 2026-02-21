package ca.mcmaster.sfwreng3s03;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Test demonstrating the decoupling of the agent using a Stub.
     */
    public void testStubAgentDecoupling()
    {
        // 1. Setup: Instantiate the stub and a dummy game state
        CatanAgent stubAgent = new StubCatanAgent();
        GameState dummyState = new GameState();

        // 2. Execution: The core game engine asks the agent for a decision
        ResourceType chosenResource = stubAgent.chooseResource(dummyState);
        DevelopmentCard chosenCard = stubAgent.chooseDevelopmentCard(dummyState);

        // 3. Verification: Ensure the stub returns the deterministic, canned answers
        assertEquals("The stub should predictably return WOOD to the engine.", 
                     ResourceType.WOOD, chosenResource);
        
        assertEquals("The stub should predictably return KNIGHT to the engine.", 
                     DevelopmentCard.KNIGHT, chosenCard);
    }
}