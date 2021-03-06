package hillbillies.part3.programs.expressions;


import java.util.Set;

import hillbillies.activities.TargetMove;
import hillbillies.model.Unit;


/**
 * @author kenneth
 *
 */
public class Friend extends Expression<Unit> {

	/**
	 * 
	 */
	public Friend() {
		super();
	}

	@Override
	public Unit evaluate() throws NullPointerException {
		Unit thisUnit = this.getRunner().getExecutingUnit();
		Set<Unit> units = this.getRunner().getExecutingWorld().getUnits();
		units.removeIf(unit -> unit.getFaction()!=thisUnit.getFaction() || unit.isFalling() || unit == thisUnit);
		if (units.isEmpty()){
			this.getRunner().stop();
			return null;
		}
		TargetMove targetmove = new TargetMove(this.getRunner().getExecutingUnit(), units);
		Unit NearestUnit = (Unit) targetmove.getNearestObject();
		if(NearestUnit == null)
			this.getRunner().stop();
		return NearestUnit;
	}
}