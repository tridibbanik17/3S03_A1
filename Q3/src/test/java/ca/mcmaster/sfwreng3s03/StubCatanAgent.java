package ca.mcmaster.sfwreng3s03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StubCatanAgent implements CatanAgent {

    @Override
    public void init(int playerId) {
        // Do nothing
    }

    @Override
    public Move chooseInitialSettlement(GameState state) {
        return new Move(); // Minimal valid return
    }

    @Override
    public Move chooseInitialRoad(GameState state) {
        return new Move();
    }

    @Override
    public Move chooseMove(GameState state) {
        return new Move(); 
    }

    @Override
    public Map<ResourceType, Integer> chooseDiscard(GameState state, int discardCount) {
        Map<ResourceType, Integer> discards = new HashMap<>();
        discards.put(ResourceType.WOOD, discardCount); // Hardcoded discard
        return discards;
    }

    @Override
    public ResourceType chooseResource(GameState state) {
        return ResourceType.WOOD; // Hardcoded resource selection
    }

    @Override
    public int chooseRobberTarget(GameState state, List<Integer> possibleTargets) {
        if (possibleTargets == null || possibleTargets.isEmpty()) return -1;
        return possibleTargets.get(0); // Hardcoded to pick the first available target
    }

    @Override
    public DevelopmentCard chooseDevelopmentCard(GameState state) {
        return DevelopmentCard.KNIGHT; // Hardcoded card selection
    }
}