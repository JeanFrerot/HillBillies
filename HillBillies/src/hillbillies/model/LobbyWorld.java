package hillbillies.model;

import java.util.*;

import hillbillies.utils.Vector;

public class LobbyWorld implements IWorld {
	
	private final List<Faction> factions = new ArrayList<>();
	public final static LobbyWorld lobby = new LobbyWorld();

	private LobbyWorld() {
		// This class cannot be instantiated elsewhere (singleton).
	}

	/**
	 * Check whether the given position is a valid position
	 * for any IWorldObject in this world.
	 * @param position The position to check
	 * @return True. Since this is the LobbyWorld, all possible positions are valid.
	 */
	@Override
	public boolean isValidPosition(Vector position){
		return true;
	}

	/**
	 * Get the minimum position in this world.
	 * This is the position of the most bottom left back cube.
	 * Since this is the LobbyWorld, the minimum position is never used so it is null.
	 */
	@Override
	public Vector getMinPosition() {
		return null;
	}

	/**
	 * Get the maximum position in this world.
	 * This is the position of the most up right front cube.
	 * Since this is the LobbyWorld, the maximum position is never used so it is null.
	 */
	@Override
	public Vector getMaxPosition() {
		return null;
	}

	/**
	 * Add the given unit to the set of units of this world.
	 *
	 * @param unit The unit to be added.
	 * @pre The given unit is effective and already references
	 * this world.
	 * | (unit != null) && (unit.getWorld() == this)
	 */
	@Override
	public void addUnit(Unit unit) {
		if(getCurrentFaction().canHaveNewUnit())
			getCurrentFaction().addUnit(unit);
		else
			addNewFaction(unit);
	}

	private Faction getCurrentFaction(){
		return this.factions.get(this.factions.size()-1);
	}
	
	private void addNewFaction(Unit unit){
		this.factions.add(new Faction(unit));
	}
	@Override
	public boolean isCubePassable(Vector vector){
		return true;
	}

	@Override
	@Deprecated
	public Vector getSpawnPosition() {
		throw new NoSuchMethodError("This method is not supported by the lobby.");
	}

	@Override
	@Deprecated
	public Set<Cube> getDirectlyAdjacentCubes(Vector position) {
		throw new NoSuchMethodError("This method is not supported by the lobby.");
	}

	@Override
	public Set<Cube> getNeighbouringCubes(Vector position) {
		throw new NoSuchMethodError("This method is not supported by the lobby.");
	}

	@Override
	@Deprecated
	public List<Vector> getDirectlyAdjacentCubesPositions(Vector cubeCoordinates) {
		throw new NoSuchMethodError("This method is not supported by the lobby.");
	}

	@Override
	@Deprecated
	public List<Vector> getNeighbouringCubesPositions(Vector cubeCoordinates) {
		throw new NoSuchMethodError("This method is not supported by the lobby.");
	}

	@Override
	@Deprecated
	public Set<Unit> getUnitsInCube(Cube cube) {
		throw new NoSuchMethodError("This method is not supported by the lobby.");
	}

	@Override
	@Deprecated
	public Cube getCube(Vector position) {
		throw new NoSuchMethodError("This method is not supported by the lobby.");
	}

	@Override
	public void collapse(Vector cube) {

	}

}